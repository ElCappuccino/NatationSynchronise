package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.natation.beans.JugeBean;

public class JugeDAO {
	private DAOFactory daoFactory;
	private TypeJugeDAO daoTypeJuge;
	
	public JugeDAO(DAOFactory factory) {
		this.daoFactory = factory;
		this.daoTypeJuge = factory.getTypeJugeDAO();
	}
	
	public JugeBean getJugeById(String id) throws SQLException {
		JugeBean juge = null;
		
		Connection co = this.daoFactory.getConnection();
		try {
			String sql = "select * from Juge where idUtilisateur = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setString(1, id);
			ResultSet rs = requete.executeQuery();
			if(rs.next()) {
				juge = new JugeBean(rs.getString(1), null);
				juge.setTypeJuge(daoTypeJuge.getTypeJugeById(rs.getInt(2)));
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		
		return juge;
	}
}
