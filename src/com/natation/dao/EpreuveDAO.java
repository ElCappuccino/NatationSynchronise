package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.natation.beans.EpreuveBean;

public class EpreuveDAO {
	private DAOFactory daoFactory;
	private TypeEpreuveDAO daoTypeEpreuve;
	
	public EpreuveDAO(DAOFactory factory) {
		this.daoFactory = factory;
		this.daoTypeEpreuve = factory.getTypeEpreuveDAO();
	}
	
	public ArrayList<EpreuveBean> getEpreuveByIdTour(int idTypeTour) throws SQLException {
		ArrayList<EpreuveBean> listeEpreuves = new ArrayList<>();
		
		Connection co = this.daoFactory.getConnection();

		try {
			String sql = "select * from epreuve where idtour = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idTypeTour);

			ResultSet rs = requete.executeQuery();
			while(rs.next()) {
				EpreuveBean epreuve = new EpreuveBean(
						rs.getInt(1),
						rs.getInt(2),
						null
						);
				epreuve.setTypeEpreuve(daoTypeEpreuve.getTypeEpreuveById(rs.getInt(3)));
				listeEpreuves.add(epreuve);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		
		return listeEpreuves;
	}
}
