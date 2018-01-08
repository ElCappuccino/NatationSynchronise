package com.natation.metiers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.natation.beans.CompetitionBean;
import com.natation.beans.EpreuveBean;
import com.natation.beans.TourBean;
import com.natation.dao.CompetitionDAO;
import com.natation.dao.EpreuveDAO;
import com.natation.dao.TourDAO;

public class NotationForm {
	private CompetitionDAO competitionDAO;
	private TourDAO tourDAO;
	private EpreuveDAO epreuveDAO;
	private Map<String, String> erreurs = new HashMap<>();
	
	/**
	 * Constructeur
	 * @param competitionDAO
	 * @param tourDAO
	 */
	public NotationForm(CompetitionDAO competitionDAO, TourDAO tourDAO, EpreuveDAO epreuveDAO) {
		this.competitionDAO = competitionDAO;
		this.tourDAO = tourDAO;
		this.epreuveDAO = epreuveDAO;
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
	
	public Map<String, String> getErreurs(){
		return erreurs;
	}
}