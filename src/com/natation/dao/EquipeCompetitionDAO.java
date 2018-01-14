package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.natation.beans.EquipeCompetitionBean;

public class EquipeCompetitionDAO {
	private DAOFactory daoFactory;
	
	public EquipeCompetitionDAO(DAOFactory factory) {
		this.daoFactory = factory;
	}
	
	public ArrayList<EquipeCompetitionBean> getEquipeCompetionByIdCompetition(int idCompetition) throws SQLException {
		ArrayList<EquipeCompetitionBean> listEquipeCompetition = new ArrayList<>();
		
		Connection co = this.daoFactory.getConnection();
		try {
			String sql = "select * from equipecompetition where idcompetition = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idCompetition);

			ResultSet rs = requete.executeQuery();
			while(rs.next()) {
				EquipeCompetitionBean equipeCompet = new EquipeCompetitionBean(
						null,
						rs.getInt(2));
				equipeCompet.setEquipe(daoFactory.getEquipeDAO().getEquipeById(rs.getInt(1)));
				listEquipeCompetition.add(equipeCompet);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		return listEquipeCompetition;
	}
}
