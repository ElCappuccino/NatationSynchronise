package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.natation.beans.TypeJugeBean;

public class TypeJugeDAO {
	private DAOFactory daoFactory;
	
	public TypeJugeDAO(DAOFactory factory) {
		this.daoFactory = factory;
	}
	
	public TypeJugeBean getTypeJugeById(int id) throws SQLException {
		TypeJugeBean typeJuge = null;
		
		Connection co = this.daoFactory.getConnection();
		try {
			String sql = "select * from typeJuge where idTypeJuge = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, id);
			ResultSet rs = requete.executeQuery();
			if(rs.next()) {
				typeJuge = new TypeJugeBean(rs.getInt(1), rs.getDouble(2), rs.getString(3));
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		
		return typeJuge;
	}
}
