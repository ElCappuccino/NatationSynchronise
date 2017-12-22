package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.natation.beans.TypeTourBean;

public class TypeTourDAO {
	private DAOFactory daoFactory;
	
	public TypeTourDAO(DAOFactory factory) {
		this.daoFactory = factory;
	}
	
	public TypeTourBean getTypeTourById(int idTypeTour) throws SQLException {
		TypeTourBean typeTour = null;
		Connection co = this.daoFactory.getConnection();

		try {
			String sql = "select IDTYPETOUR, LIBELLETYPETOUR from TYPETOUR "
					+ "where IDTYPETOUR = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idTypeTour);
			ResultSet rs = requete.executeQuery();
			
			if(rs.next()) {
				typeTour = new TypeTourBean(
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
		return typeTour;
	}
}
