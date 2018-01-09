package com.natation.metiers;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.natation.beans.NageuseBean;
import com.natation.dao.NageuseDAO;
import com.opencsv.CSVReader;

@MultipartConfig
public final class AdminForm {
	private NageuseDAO nageuseDAO;
	private Map<String, String> messages = new HashMap<>();

	public AdminForm(NageuseDAO n) {
		this.nageuseDAO = n;
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
			if (req.getPart("csvNageuses") != null) {
				csvReceived = true;
				List<NageuseBean> nouvellesNageuses = parseNageuses(req);
				for (NageuseBean n : nouvellesNageuses) {
					nageuseDAO.createNageuse(n);
				}
				messages.put("succesImport", "Importation terminée avec succès. " + nouvellesNageuses.size() + " nageuse(s) importée(s).");
			}
		} catch (Exception e) {
			messages.put("errImport", e.getMessage());
		}

		return csvReceived;
	}

	/**
	 * Récupère le CSV des nageuse à importer et créé une instance de nageuse
	 * par ligne du CSV
	 * 
	 * @param req
	 * @return liste des nageuses contenues dans le CSV
	 * @throws Exception
	 */
	private List<NageuseBean> parseNageuses(HttpServletRequest req) throws Exception {
		List<NageuseBean> nouvellesNageuses = new ArrayList<NageuseBean>();

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
				NageuseBean n = new NageuseBean(
						ligneCSV[0], 
						ligneCSV[1], 
						LocalDate.parse(ligneCSV[2]));
				nouvellesNageuses.add(n);
			}
			reader.close();
		} catch (Exception e) {
			throw new Exception("Erreur lors de l'import du fichier CSV. Celui-ci contient une ou plusieures erreurs");
		}

		return nouvellesNageuses;
	}

	/**
	 * @return les messages à afficher à l'utilisateur
	 */
	public Map<String, String> getMessages() {
		return messages;
	}
}
