package com.natation.metiers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.natation.beans.BalletBean;
import com.natation.beans.CompetitionBean;
import com.natation.beans.EpreuveBean;
import com.natation.beans.EquipeBean;
import com.natation.beans.EquipeCompetitionBean;
import com.natation.beans.JugeBean;
import com.natation.beans.NageuseBean;
import com.natation.beans.TourBean;
import com.natation.beans.TypeFigureBean;
import com.natation.beans.UtilisateurBean;
import com.natation.dao.BalletDAO;
import com.natation.dao.CompetitionDAO;
import com.natation.dao.EpreuveDAO;
import com.natation.dao.EquipeCompetitionDAO;
import com.natation.dao.EquipeDAO;
import com.natation.dao.ExecutionFigureDAO;
import com.natation.dao.JugeDAO;
import com.natation.dao.TourDAO;
import com.natation.dao.TypeFigureDAO;

public class NotationForm {
	private CompetitionDAO competitionDAO;
	private TourDAO tourDAO;
	private EpreuveDAO epreuveDAO;
	private BalletDAO balletDAO;
	private ExecutionFigureDAO executionFigureDAO;
	private EquipeDAO equipeDAO;
	private EquipeCompetitionDAO equipeCompetitionDAO;
	private TypeFigureDAO typeFigureDAO;
	private JugeDAO jugeDAO;
	private Map<String, String> erreurs = new HashMap<>();
	
	public static final String ATTR_SESSION_USERBEAN = "userBean";

	
	/**
	 * Constructeur
	 */
	public NotationForm(CompetitionDAO competitionDAO, TourDAO tourDAO, EpreuveDAO epreuveDAO, BalletDAO balletDAO,
			ExecutionFigureDAO executionFigureDAO, EquipeDAO equipeDAO, EquipeCompetitionDAO equipeCompetitionDAO,
			TypeFigureDAO typeFigureDAO, JugeDAO jugeDAO) {
		this.competitionDAO = competitionDAO;
		this.tourDAO = tourDAO;
		this.epreuveDAO = epreuveDAO;
		this.balletDAO = balletDAO;
		this.executionFigureDAO = executionFigureDAO;
		this.equipeDAO = equipeDAO;
		this.equipeCompetitionDAO = equipeCompetitionDAO;
		this.typeFigureDAO = typeFigureDAO;
		this.jugeDAO = jugeDAO;
	}
	
	/**
	 * Récupère une liste des compétitions associé à un utilisateur
	 * @param idUser
	 * @return Liste des compétitions
	 */
	public ArrayList<CompetitionBean> getCompetitionsByUser(String idUser) {
		ArrayList<CompetitionBean> list = null;
		try {
			list = competitionDAO.getCompetitionByUtilisateur(idUser);
		} catch (SQLException e) {
			erreurs.put("getCompetitionsByUser", e.getMessage());
		}
		return list;
	}
	
	/**
	 * Récupère une liste de tour associé à une compétition
	 * @param idCompetition
	 * @return Liste de tour
	 */
	public ArrayList<TourBean> getTourByIdCompetition(String idCompetition) {
		ArrayList<TourBean> list = null;
		try {
			int val = Integer.parseInt(idCompetition);
			list = tourDAO.getTourByIdCompetition(val);
		} catch(Exception e) {
			erreurs.put("getTourByIdCompetition", e.getMessage());
		}
		return list;
	}
	
	/**
	 * Récupère une liste d'epreuve associé à un tour
	 * @param idTour
	 * @return Liste d'epreuve
	 */
	public ArrayList<EpreuveBean> getEpreuveByIdTour(String idTour) {
		ArrayList<EpreuveBean> list = null;
		try {
			int val = Integer.parseInt(idTour);
			list = epreuveDAO.getEpreuveByIdTour(val);
		} catch(Exception e) {
			erreurs.put("getEpreuveByIdTour", e.getMessage());
		}
		return list;
	}
	
	public ArrayList<BalletBean> getBalletByIdEpreuve(String idEpreuve) {
		ArrayList<BalletBean> list = null;
		try {
			int val = Integer.parseInt(idEpreuve);
			list = balletDAO.getBalletByIdEpreuve(val);
		} catch(Exception e) {
			erreurs.put("getBalletByIdEpreuve", e.getMessage());
		}
		return list;
	}
	
	public ArrayList<EquipeBean> getEquipeByIdCompetition(String idJuge, String idCompet, String idBallet) {
		ArrayList<EquipeBean> list = new ArrayList<>();
		try {
			int valCompet = Integer.parseInt(idCompet);
			int valBallet = Integer.parseInt(idBallet);
			
			// On récupere les équipe liées à la compétition
			ArrayList<EquipeCompetitionBean> equipeCompet = equipeCompetitionDAO.getEquipeCompetionByIdCompetition(valCompet);
			
			for(EquipeCompetitionBean ec : equipeCompet) { // On récupère la liste de nageuse de chaque équipes
				Boolean verif = false;
				ArrayList<NageuseBean> nageuses = equipeDAO.getNageusesByIdEquipe(ec.getEquipe().getId());
				for(NageuseBean n : nageuses) { // Pour chaque nageuse on test son existence dans ExecutionFigure quand le ballet vaut idBallet et le juge idJuge
					if(executionFigureDAO.checkExecutionFigureExist(idJuge, valBallet, n.getId())) {
						verif = true;
						break;
					}
				}
				// Si une nageuse est présente on ajoute pas l'équipe dans list (on considère qu'elle a déjà recu une note sur ce ballet)
				if(!verif)
					list.add(ec.getEquipe());
			}	
			
		} catch (Exception e) {
			erreurs.put("getEquipeByIdCompetition", e.getMessage());
		}
		return list;
	}
	
	public ArrayList<NageuseBean> getNageuseByIdEquipe(String idEquipe) {
		ArrayList<NageuseBean> list = new ArrayList<>();
		try {
			int val = Integer.parseInt(idEquipe);
			list = equipeDAO.getNageusesByIdEquipe(val);
			
		} catch(Exception e) {
			erreurs.put("getNageuseByIdEquipe", e.getMessage());
		}
		return list;
	}
	
	public JugeBean getJugeById(String idUtilisateur) {
		JugeBean juge = null;
		try {
			juge = jugeDAO.getJugeById(idUtilisateur);
		} catch(Exception e) {
			erreurs.put("getJugeById", e.getMessage());
		}
		return juge;
	}
	
	public ArrayList<TypeFigureBean> getAllTypeFigure() {
		ArrayList<TypeFigureBean> list = new ArrayList<>();
		try {
			list = typeFigureDAO.getAllTypeFigure();
		} catch(Exception e) {
			erreurs.put("getAllTypeFigure", e.getMessage());
		}
		return list;
	}
	
	public void sendFields(HttpServletRequest request, HttpServletResponse response, HttpSession session, String selec) throws IOException {
		String value = request.getParameter("valeur");
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();
		
		// Selon la liste
		String json;
		switch(selec) {
			case "competition":
				// On récupère les tours selon la valeur récupérée
	    		ArrayList<TourBean> listTours = getTourByIdCompetition(value);
	    		
	    		Map<Integer, String> mapTours = new HashMap<>();
	    		for(TourBean t : listTours) {
	    			mapTours.put(t.getId(), t.getType().getLibelle());
	    		}
	    		json = gson.toJson(mapTours);
				response.getWriter().write(json);
				return;
			case "tour":
				// Récupération des epreuves liées à ce tour
	    		ArrayList<EpreuveBean> listEpreuves = getEpreuveByIdTour(value);
	    		Map<Integer, String> mapEpreuves = new HashMap<>();
	    		for(EpreuveBean e : listEpreuves) {
	    			mapEpreuves.put(e.getId(), e.getTypeEpreuve().getLibelle());
	    		}
	    		json = gson.toJson(mapEpreuves);
				response.getWriter().write(json);
				return;
			case "epreuve":
				// Récupération des ballets liés à cette épreuve
	    		ArrayList<BalletBean> listBallets = getBalletByIdEpreuve(value);
	    		Map<Integer, String> mapBallets = new HashMap<>();
	    		for(BalletBean b : listBallets) {
	    			mapBallets.put(b.getId(), b.getTypeBallet().getLibelle());
	    		}
	    		json = gson.toJson(mapBallets);
				response.getWriter().write(json);
				return;
			case "ballet":
				// On récupère les équipes liées à la compétition sélectionné
	    		// On enleve toutes celles possédant déjà leurs notes sur ce ballet pour ce juge		
	    		String valueCompet = request.getParameter("compvaleur");
	    		ArrayList<EquipeBean> listEquipes = getEquipeByIdCompetition(((UtilisateurBean)session.getAttribute(ATTR_SESSION_USERBEAN)).getId(), valueCompet, value);
	    		Map<Integer, String> mapEquipe = new HashMap<>();
	    		for(EquipeBean e : listEquipes) {
	    			mapEquipe.put(e.getId(), e.getLibelle());
	    		}
	    		json = gson.toJson(mapEquipe);
				response.getWriter().write(json);
				return;
			case "equipe":
				// On récupère la liste des nageuses
	    		// On récupère les différentes figures possible
	    		Map<String, Map<Integer, String>> map = new HashMap<>();
	    		Map<Integer, String> mapNageuseT = new HashMap<>();
	    		Map<Integer, String> mapNageuseR = new HashMap<>();
	    		Map<Integer, String> mapFigures = new HashMap<>();
	    		Map<Integer, String> mapUtilisateurs = new HashMap<>();
	    		
	    		ArrayList<NageuseBean> listNageuse = getNageuseByIdEquipe(value);
	    		for(NageuseBean n : listNageuse) {
	    			if(n.getIsTitulaire())
	    				mapNageuseT.put(n.getId(), n.getNom() + " " + n.getPrenom());
	    			else
	    				mapNageuseR.put(n.getId(), n.getNom() + " " + n.getPrenom());
	    		}
	    		
	    		ArrayList<TypeFigureBean> listFigure = getAllTypeFigure();
	    		for(TypeFigureBean typeFigure : listFigure) {
	    			mapFigures.put(typeFigure.getId(), typeFigure.getLibelle());
	    		}
	    		
	    		JugeBean juge = getJugeById(((UtilisateurBean)session.getAttribute(ATTR_SESSION_USERBEAN)).getId());
	    		mapUtilisateurs.put(0, juge.getTypeJuge().getLibelle());
	    		mapUtilisateurs.put(1, ((UtilisateurBean)session.getAttribute(ATTR_SESSION_USERBEAN)).getAdmin().toString());
	    		
	    		map.put("nageusesT", mapNageuseT);
	    		map.put("nageusesR", mapNageuseR);
	    		map.put("figures", mapFigures);
	    		map.put("infoUser", mapUtilisateurs);
	    		
	    		json = gson.toJson(map);
				response.getWriter().write(json);
				return;
		}
	}
	
	public Map<String, String> getErreurs(){
		return erreurs;
	}
}