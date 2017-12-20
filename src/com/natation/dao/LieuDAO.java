package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.natation.beans.LieuBean;

public class LieuDAO {
	private DAOFactory daoFactory;
	
	public LieuDAO(DAOFactory factory) {
		this.daoFactory = factory;
	}
	
	public LieuBean getLieuById(int idLieu) throws SQLException {
		LieuBean lieu = null;
		Connection co = this.daoFactory.getConnection();

		try {
			String sql = "select idLieu, numeroLieu, rueLieu, codePostalLieu, villeLieu\n"
					+ "from Lieu where idLieu = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idLieu);
			ResultSet rs = requete.executeQuery();
			
			if(rs.next()) {
				lieu = new LieuBean(
						idLieu,
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
						);
			}
			
		} catch (SQLException e) {
			
		} finally {
			co.close();
		}
		return lieu;
	}
}
