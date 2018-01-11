package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecutionFigureDAO {
	private DAOFactory daoFactory;
	private TypeFigureDAO daoTypeFigure;

	
	public ExecutionFigureDAO(DAOFactory factory) {
		this.daoFactory = factory;
		this.daoTypeFigure = factory.getTypeFigureDAO();
	}
	
	/**
	 * Vérifie l'existence de la notation d'un juge sur un ballet
	 * @return Vrai dans le cas ou la requête retourne un résultat, Faux dans le cas contraire
	 * @throws SQLException
	 */
	public Boolean checkExecutionFigureExist(String idJuge, int idBallet) throws SQLException {
		Boolean res = false;
		Connection co = this.daoFactory.getConnection();
		try {
			String sql = "select * from executionfigure where idBallet = ? and idUtilisateur = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idBallet);
			requete.setString(2, idJuge);

			ResultSet rs = requete.executeQuery();
			if(rs.next()) {
				res = true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		return res;
	}
}
