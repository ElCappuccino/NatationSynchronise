package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.natation.beans.EquipeBean;
import com.natation.beans.NageuseBean;

public class EquipeDAO {
	private DAOFactory daoFactory;
	
	public EquipeDAO(DAOFactory factory) {
		this.daoFactory = factory;
	}
	
	public EquipeBean getEquipeById(int idEquipe) throws SQLException {
		EquipeBean equipe = null;
		Connection co = this.daoFactory.getConnection();

		try {
			String sql = "select * from equipe where idequipe = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idEquipe);

			ResultSet rs = requete.executeQuery();
			if(rs.next()) {
				equipe = new EquipeBean(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3));
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		return equipe;
	}
	
	public EquipeBean getEquipeByClubId(int idClub) throws SQLException {
		EquipeBean equipe = null;
		Connection co = this.daoFactory.getConnection();

		try {
			String sql = "select * from equipe where idClub = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idClub);

			ResultSet rs = requete.executeQuery();
			if(rs.next()) {
				equipe = new EquipeBean(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3));
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		return equipe;
	}
}
