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
	
	/**
	 * Recupere les associations Equipe/Competition pour la competition passée en parametre
	 * @param idCompetition
	 * @return
	 * @throws SQLException
	 */
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

	/**
	 * Créé l'association Equipe/Competition la compétition et l'équipe passés en paramètre
	 * @param idCompetition
	 * @param idEquipe
	 * @throws SQLException
	 */
	public void createEquipeCompetitionLink(int idCompetition, int idEquipe) throws SQLException {	
		if (idCompetition > 0 && idEquipe > 0) {
			Connection co = this.daoFactory.getConnection();
			try {
				String sql = "insert into EQUIPECOMPETITION (IDEQUIPE, IDCOMPETITION) "
						+ "values(?,?)";
				PreparedStatement requete = co.prepareStatement(sql);
				requete.setInt(1, idEquipe);
				requete.setInt(2, idCompetition);
				requete.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
			} finally {
				co.close();
			}
		}
	}
}
