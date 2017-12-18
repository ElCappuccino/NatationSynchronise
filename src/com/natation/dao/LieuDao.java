package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.natation.beans.LieuBean;

public class LieuDao {
	private DAOFactory daoFactory;
	
	public LieuDao(DAOFactory factory) {
		this.daoFactory = factory;
	}
	
	public LieuBean getLieuById(int idLieu) throws SQLException {
		Connection co = this.daoFactory.getConnection();

		try {
			String sql = "select idLieu, numeroLieu, rueLieu, codePostalLieu, villeLieu\n"
					+ "from Lieu where idLieu = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idLieu);

			
		} catch (SQLException e) {
			
		} finally {
			co.close();
		}
		return null;
	}
}
