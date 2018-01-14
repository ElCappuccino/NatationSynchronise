package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.natation.beans.ClubBean;
import com.natation.beans.DirigeantBean;

public class ClubDAO {
	private DAOFactory daoFactory;
	
	public ClubDAO(DAOFactory factory) {
		this.daoFactory = factory;
	}
	
	public ClubBean getClubById(int idClub) throws SQLException {
		ClubBean club = null;
		
		Connection co = this.daoFactory.getConnection();
		try {
			String sql = "select * from club where idClub = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idClub);

			ResultSet rs = requete.executeQuery();
			if(rs.next()) {
				DirigeantBean dirigeant = daoFactory.getDirigeantDAO().getDirigeantById(rs.getInt(2));
				club = new ClubBean(
						rs.getInt(1),
						dirigeant,
						rs.getString(3)
						);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		
		return club;
	}
	
	public ArrayList<ClubBean> getAllClubs() throws SQLException {
		ArrayList<ClubBean> list = new ArrayList<>();
		
		Connection co = this.daoFactory.getConnection();
		try {
			String sql = "select * from club";
			PreparedStatement requete = co.prepareStatement(sql);
			ResultSet rs = requete.executeQuery();
			while(rs.next()) {
				DirigeantBean dirigeant = daoFactory.getDirigeantDAO().getDirigeantById(rs.getInt(2));
				ClubBean club = new ClubBean(
						rs.getInt(1),
						dirigeant,
						rs.getString(3)
						);
				list.add(club);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		return list;
	}
}
