package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.natation.beans.CategorieBean;

public class CategorieDAO {
	private DAOFactory daoFactory;

	public CategorieDAO(DAOFactory factory) {
		this.daoFactory = factory;
	}
	
	public CategorieBean getCategorieById(int idCategorie) throws SQLException {
		CategorieBean categorie = null;
		Connection co = this.daoFactory.getConnection();
		try {
			String sql = "select idCategorie, libelleCategorie from Categorie "
					+ "where idCategorie = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idCategorie);
			ResultSet rs = requete.executeQuery();
			
			if(rs.next()) {
				categorie = new CategorieBean(
						rs.getInt(1),
						rs.getString(2)
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		
		return categorie;
	}
}
