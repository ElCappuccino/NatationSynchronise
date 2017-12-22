package com.natation.metiers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.natation.beans.CompetitionBean;
import com.natation.dao.CompetitionDAO;

public class NotationForm {
	private CompetitionDAO competitionDAO;
	private Map<String, String> erreurs = new HashMap<>();
	
	public NotationForm(CompetitionDAO competitionDAO) {
		this.competitionDAO = competitionDAO;
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
	
	public Map<String, String> getErreurs(){
		return erreurs;
	}
}