package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.natation.beans.TypeBalletBean;

public class TypeBalletDAO {
	private DAOFactory daoFactory;

	public TypeBalletDAO(DAOFactory factory) {
		this.daoFactory = factory;
	}
	
	public TypeBalletBean getTypeBalletById(int idTypeBallet) throws SQLException {
		TypeBalletBean typeBallet = null;
		Connection co = this.daoFactory.getConnection();

		try {
			String sql = "select * from typeBallet where idtypeballet = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idTypeBallet);
			ResultSet rs = requete.executeQuery();
			if(rs.next()) {
				typeBallet = new TypeBalletBean(
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
		return typeBallet;
	}
}
