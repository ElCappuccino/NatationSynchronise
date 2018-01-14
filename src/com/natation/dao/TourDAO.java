package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.natation.beans.TourBean;
import com.natation.beans.TypeTourBean;

public class TourDAO {
	private DAOFactory daoFactory;
	
	public TourDAO(DAOFactory factory) {
		this.daoFactory = factory;
	}
	
	public ArrayList<TourBean> getTourByIdCompetition(int idCompetition) throws SQLException {
		ArrayList<TourBean> listTour = new ArrayList<>();
		Connection co = this.daoFactory.getConnection();

		try {
			String sql = "select * from tour "
					+ "where idCompetition = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idCompetition);
			ResultSet rs = requete.executeQuery();
			while(rs.next()) {
				TourBean tour = new TourBean(
						rs.getInt(1),
						null,
						rs.getInt(2)
						);
				TypeTourBean typeTour = daoFactory.getTypeTourDAO().getTypeTourById(rs.getInt(3));
				tour.setType(typeTour);
				listTour.add(tour);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		
		return listTour;
	}
}
