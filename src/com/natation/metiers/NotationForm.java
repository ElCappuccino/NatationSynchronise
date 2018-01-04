package com.natation.metiers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.natation.beans.CompetitionBean;
import com.natation.beans.TourBean;
import com.natation.dao.CompetitionDAO;
import com.natation.dao.TourDAO;

public class NotationForm {
	private CompetitionDAO competitionDAO;
	private TourDAO tourDAO;
	private Map<String, String> erreurs = new HashMap<>();
	
	public NotationForm(CompetitionDAO competitionDAO, TourDAO tourDAO) {
		this.competitionDAO = competitionDAO;
		this.tourDAO = tourDAO;
	}
	
	public ArrayList<CompetitionBean> getCompetitionsByUser(String idUser) {
		ArrayList<CompetitionBean> list = null;
		try {
			list = competitionDAO.getCompetitionByUtilisateur(idUser);
		} catch (SQLException e) {
			erreurs.put("getCompetitionsByUser", e.getMessage());
		}
		return list;
	}
	
	public ArrayList<TourBean> getTourByIdCompetition(String idCompetition) {
		ArrayList<TourBean> list = null;
		try {
			int val = Integer.parseInt(idCompetition);
			list = tourDAO.getTourByIdCompetition(val); // On ne devrait pas avoir plusieurs tour par competition ? Probleme dans DAO
		} catch(Exception e) {
			erreurs.put("getTourByIdCompetition", e.getMessage());
		}
		return list;
	}
	
	public Map<String, String> getErreurs(){
		return erreurs;
	}
}