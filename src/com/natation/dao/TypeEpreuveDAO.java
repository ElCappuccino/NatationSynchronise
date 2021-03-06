package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.natation.beans.TypeEpreuveBean;

public class TypeEpreuveDAO {
	private DAOFactory daoFactory;
	
	public TypeEpreuveDAO(DAOFactory factory) {
		this.daoFactory = factory;
	}
	
	public TypeEpreuveBean getTypeEpreuveById(int idTypeEpreuve) throws SQLException {
		TypeEpreuveBean typeEpreuve = null;
		
		Connection co = this.daoFactory.getConnection();
		try {
			String sql = "select * from typeepreuve where idtypeepreuve = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idTypeEpreuve);

			ResultSet rs = requete.executeQuery();
			if(rs.next()) {
				typeEpreuve = new TypeEpreuveBean(
						rs.getInt(1),
						rs.getString(2)
						);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		return typeEpreuve;
	}
}
