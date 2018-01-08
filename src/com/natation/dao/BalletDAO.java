package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.natation.beans.BalletBean;

public class BalletDAO {
	private DAOFactory daoFactory;
	private TypeBalletDAO daoTypeBallet;
	
	public BalletDAO(DAOFactory factory) {
		this.daoFactory = factory;
		this.daoTypeBallet = factory.getTypeBalletDAO();
	}
	
	public ArrayList<BalletBean> getBalletByIdEpreuve(int idEpreuve) throws SQLException {
		ArrayList<BalletBean> listeBallet = new ArrayList<>();
		Connection co = this.daoFactory.getConnection();

		try {
			String sql = "";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idEpreuve);
			ResultSet rs = requete.executeQuery();
			while(rs.next()) {
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		return listeBallet;
	}
}
