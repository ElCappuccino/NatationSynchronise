package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.natation.beans.CompetitionBean;
import com.natation.beans.LieuBean;

public class CompetitionDAO {
	private DAOFactory daoFactory;
	private LieuDAO lieuDAO;
	
	public CompetitionDAO(DAOFactory factory) {
		this.daoFactory = factory;
		lieuDAO = new LieuDAO(factory);
	}
	
	/**
	 * R�cup�re les comp�titions li�s � un utilisateur
	 * @param idUtilisateur
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<CompetitionBean> getCompetitionByUtilisateur(String idUtilisateur) throws SQLException {
		ArrayList<CompetitionBean> listCompet = new ArrayList<>();
		Connection co = this.daoFactory.getConnection();
		
		try {
			String sql = "select idCompetition, idLieu, idCategorie, idUtilisateur\n"
					+ "from competition c"
					+ "inner join jugecompetition jc on c.idCompetition = jc.idCompetition"
					+ "where lower(jc.idutilisateur) = lower(?)";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setString(1, idUtilisateur);

			ResultSet rs = requete.executeQuery();
			while(rs.next()) {
				CompetitionBean comp = new CompetitionBean(
						rs.getInt(1),
						rs.getInt(3),
						idUtilisateur,
						rs.getDate(5),
						rs.getDate(6),
						rs.getString(7),
						null
						);
				LieuBean lieu = lieuDAO.getLieuById(rs.getInt(2));
				comp.setLieu(lieu);
				listCompet.add(comp);
			}
		} catch (SQLException e) {
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		
		return listCompet;
	}

}
