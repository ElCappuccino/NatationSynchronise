package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.natation.beans.TourBean;
import com.natation.beans.TypeTourBean;

public class TourDAO {
	private DAOFactory daoFactory;
	private TypeTourDAO daoTypeTour;
	
	public TourDAO(DAOFactory factory) {
		this.daoFactory = factory;
		daoTypeTour = factory.getTypeTourDAO();
	}
	
	public TourBean getTourByIdCompetition(int idCompetition) throws SQLException {
		TourBean tour = null;
		
		Connection co = this.daoFactory.getConnection();

		try {
			String sql = "select * from tour "
					+ "where idCompetition = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idCompetition);
			ResultSet rs = requete.executeQuery();
			
			if(rs.next()) {
				tour = new TourBean(
						rs.getInt(1),
						null,
						rs.getInt(2)
						);
				TypeTourBean typeTour = daoTypeTour.getTypeTourById(rs.getInt(3));
				tour.setType(typeTour);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		
		return tour;
	}
}
