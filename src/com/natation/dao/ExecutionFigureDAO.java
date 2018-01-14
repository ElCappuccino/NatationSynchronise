package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecutionFigureDAO {
	private DAOFactory daoFactory;
	
	public ExecutionFigureDAO(DAOFactory factory) {
		this.daoFactory = factory;
	}
	
	/**
	 * Vérifie l'existence de la notation d'un juge sur un ballet
	 * @return Vrai dans le cas ou la requête retourne un résultat, Faux dans le cas contraire
	 * @throws SQLException
	 */
	public Boolean checkExecutionFigureExist(String idJuge, int idBallet, int idNageuse) throws SQLException { // TODO PROBLEME FAUT TESTER LE BALLET, LE JUGE ET UNE NAGEUSE
		Boolean res = false;
		Connection co = this.daoFactory.getConnection();
		try {
			String sql = "select * from executionfigure where idBallet = ? and idUtilisateur = ? and idNageuse = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idBallet);
			requete.setString(2, idJuge);
			requete.setInt(3, idNageuse);

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
