package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import com.natation.beans.CompetitionBean;

public class CompetitionDAO {
	private DAOFactory daoFactory;
	
	public CompetitionDAO(DAOFactory factory) {
		this.daoFactory = factory;
	}
	
	/**
	 * Récupère les compétitions liés à un utilisateur
	 * @param idUtilisateur
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<CompetitionBean> getCompetitionByUtilisateur(String idUtilisateur) throws SQLException {
		Connection co = this.daoFactory.getConnection();
		
		try {
			String sql = "select idCompetition, idLieu, idCategorie, idUtilisateur\n"
					+ "from competition where lower(idutilisateur) = lower(?)";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setString(1, idUtilisateur);

		} catch (SQLException e) {
			
		} finally {
			co.close();
		}
		
		return null;
	}

}
