package com.natation.metiers;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.natation.beans.BalletBean;
import com.natation.beans.ClubBean;
import com.natation.beans.CompetitionBean;
import com.natation.beans.EpreuveBean;
import com.natation.beans.EquipeBean;
import com.natation.beans.JugeBean;
import com.natation.beans.NageuseBean;
import com.natation.beans.TourBean;
import com.natation.beans.TypeFigureBean;
import com.natation.beans.UtilisateurBean;
import com.natation.dao.DAOFactory;
import com.opencsv.CSVReader;

@MultipartConfig
public final class AdminForm {
	private DAOFactory daoFactory;
	private Map<String, String> messages = new HashMap<>();

	public AdminForm(DAOFactory d) {
		this.daoFactory = d;
	}

	/**
	 * @return les messages à afficher à l'utilisateur
	 */
	public Map<String, String> getMessages() {
		return messages;
	}

	/**
	 * @param key
	 *            identifiant du message
	 * @param value
	 *            contenu du message
	 */
	public void addMessage(String key, String value) {
		this.messages.put(key, value);
	}

	/**
	 * Inscrit l'equipe a une competition si les listes on été renseignées
	 * @param req
	 */
	public void inscrireEquipeCompetition(HttpServletRequest req) {
		try {
			if (req.getParameter("listeClubs") != null && req.getParameter("listeEquipes") != null
					&& req.getParameter("listeCompetitions") != null) {
				daoFactory.getEquipeCompetitionDAO().createEquipeCompetitionLink(
						Integer.parseInt(req.getParameter("listeCompetitions")),
						Integer.parseInt(req.getParameter("listeEquipes")));
				messages.put("successAJAX", "Inscription de l'équipe enregistrée.");
			}
		} catch (Exception e) {
			messages.put("errAJAX", e.getMessage());
		}
	}

	/**
	 * Parse le contenu d'un CSV et l'ajoute en BdD
	 * 
	 * @param req
	 * @return true si un csv a été reçu et traité, false sinon
	 * @throws Exception
	 */
	public boolean uploadCsv(HttpServletRequest req) {
		boolean csvReceived = false;

		try {
			// TODO : check if set or not, cause always non-null when a form is sent!
			if (req.getPart("csvNageuses") != null) {
				csvReceived = true;
				List<NageuseBean> nouvellesNageuses = parseNageuses(req);
				for (NageuseBean n : nouvellesNageuses) {
					daoFactory.getNageuseDAO().createNageuse(n);
				}

				if (nouvellesNageuses.size() > 0)
					messages.put("succesImport", "Importation terminée avec succès. " + nouvellesNageuses.size()
							+ " nageuse(s) importée(s).");
				else
					messages.put("errImport", "Veuillez spécifier un fichier à importer");
			}
		} catch (Exception e) {
			messages.put("errImport", e.getMessage());
		}

		return csvReceived;
	}

	// -------
	// --- Helpers CSV
	// -------

	/**
	 * Récupère le CSV des nageuse à importer et créé une instance de nageuse par
	 * ligne du CSV
	 * 
	 * @param req
	 * @return liste des nageuses contenues dans le CSV
	 * @throws Exception
	 */
	private List<NageuseBean> parseNageuses(HttpServletRequest req) throws Exception {
		List<NageuseBean> nouvellesNageuses = new ArrayList<NageuseBean>();
		// TODO : check if lists have a value, because  succes messages apears when everything is not set (check JS because it can be the defaults values of the inputs!)
		try {
			// Récupération csv nageuses
			Part filePart;
			filePart = req.getPart("csvNageuses");

			// Création d'un CsvReader à partir du contenu envoyé
			InputStream fileContent = filePart.getInputStream();
			CSVReader reader = new CSVReader(new InputStreamReader(fileContent, "UTF-8"));

			// Creation instances NageuseBean à partir des données du csv
			// Contenu CSV attendu : nom, prenom, dateNaissance
			String[] ligneCSV = null;
			while ((ligneCSV = reader.readNext()) != null) {
				NageuseBean n = new NageuseBean(ligneCSV[0], ligneCSV[1], LocalDate.parse(ligneCSV[2]));
				nouvellesNageuses.add(n);
			}
			reader.close();
		} catch (Exception e) {
			throw new Exception("Erreur lors de l'import du fichier CSV. Celui-ci contient une ou plusieures erreurs");
		}

		return nouvellesNageuses;
	}

	// -------
	// --- Helpers Traitements AJAX
	// -------

	public void handleAJAXCall(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

	}

	/**
	 * Créé un liste contenant les clubs et l'ajoute dans l'objet requete
	 * 
	 * @param req
	 * @throws SQLException
	 */
	public void fillClubList(HttpServletRequest req) throws SQLException {
		ArrayList<ClubBean> clubs = daoFactory.getClubDAO().getAllClubs();
		req.setAttribute("listeClubs", clubs);
	}

	public void sendFields(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			String selectEquipeCompet) throws IOException, NumberFormatException, SQLException {
		String value = request.getParameter("valeur");
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		// Selon l'element qui a été modifié dans la liste, on lance le traitement
		// approprié
		String json;
		switch (selectEquipeCompet) {
		case "club":
			// Récupération des équipes du club
			List<EquipeBean> listeEquipes = daoFactory.getEquipeDAO().getEquipeByClubId(Integer.parseInt(value));
			Map<Integer, String> mapEquipes = new HashMap<>();
			for (EquipeBean eq : listeEquipes) {
				mapEquipes.put(eq.getId(), eq.getLibelle());
			}
			// Parsing de la map en JSON puis ajout dans response
			json = gson.toJson(mapEquipes);
			response.getWriter().write(json);
			return;
		case "equipe":
			// Récupération des compétitions disponibles pour cette équipe
			List<CompetitionBean> listeCompets = daoFactory.getCompetitionDAO()
					.getUnregisteredCompetitionsByEquipe(value);
			Map<Integer, String> mapCompets = new HashMap<>();
			for (CompetitionBean comp : listeCompets) {
				mapCompets.put(comp.getId(), comp.getLibelle());
			}
			json = gson.toJson(mapCompets);
			response.getWriter().write(json);
			return;

		}
	}
}
