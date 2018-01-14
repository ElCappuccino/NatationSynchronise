package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.natation.beans.DirigeantBean;
import com.natation.beans.LieuBean;

public class DirigeantDAO {
	private DAOFactory daoFactory;
	
	public DirigeantDAO(DAOFactory factory) {
		this.daoFactory = factory;
	}
	
	public DirigeantBean getDirigeantById(int idDirigeant) throws SQLException {
		DirigeantBean dirigeant = null;
		
		Connection co = this.daoFactory.getConnection();
		try {
			String sql = "select * from dirigeant where idDirigeant = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idDirigeant);

			ResultSet rs = requete.executeQuery();
			if(rs.next()) {
				LieuBean lieu = daoFactory.getLieuDAO().getLieuById(rs.getInt(2));
				dirigeant = new DirigeantBean(
						rs.getInt(1),
						lieu,
						rs.getString(3),
						rs.getString(4)
						);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		
		return dirigeant;
	}
}
