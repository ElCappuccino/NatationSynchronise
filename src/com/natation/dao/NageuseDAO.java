package com.natation.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.natation.beans.NageuseBean;

public class NageuseDAO {
	private DAOFactory daoFactory;

	public NageuseDAO(DAOFactory factory) {
		this.daoFactory = factory;
	}

	/**
	 * Recupere une nageuse selon son ID
	 * 
	 * @param idNageuse
	 * @return la nageuse, null si non trouvée
	 * @throws Exception
	 */
	public NageuseBean getNageuseById(int idNageuse) throws Exception {
		NageuseBean nageuse = null;
		Connection co = this.daoFactory.getConnection();

		try {
			String sql = "select idNageuse, nomNageuse, prenomNageuse, dateNaissanceNageuse "
					+ "from Nageuse where idNageuse = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idNageuse);
			ResultSet rs = requete.executeQuery();

			if (rs.next()) {
				nageuse = new NageuseBean(idNageuse, rs.getString(2), rs.getString(3),
						LocalDate.parse(rs.getString(4)));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		return nageuse;
	}

	/**
	 * Recupere les nageuse d'un equipe dont l'id est specifie en parametre
	 * 
	 * @param idEquipe
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<NageuseBean> getNageusesByIdEquipe(int idEquipe) throws SQLException {
		ArrayList<NageuseBean> listNageuses = new ArrayList<>();
		Connection co = this.daoFactory.getConnection();
		try {
			String sql = "select N.idNageuse, N.nomNageuse, N.prenomNageuse, N.dateNaissanceNageuse, NE.isTitulaire from Nageuse N "
					+ "inner join nageuseequipe NE on N.idNageuse = NE.idNageuse " + "where NE.idequipe = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idEquipe);

			ResultSet rs = requete.executeQuery();
			while (rs.next()) {
				NageuseBean nageuse = new NageuseBean(rs.getInt(1), rs.getString(2), rs.getString(3),
						LocalDate.parse(rs.getString(4)));
				nageuse.setIsTitulaire(rs.getBoolean(5));
				listNageuses.add(nageuse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		return listNageuses;
	}

	/**
	 * Créé la nageuse spécifiée en paramètre dans la base de données
	 * 
	 * @param nageuse
	 * @return id de la nageuse inserée si OK, -1 sinon.
	 * @throws SQLException
	 */
	public int createNageuse(NageuseBean nageuse) throws SQLException {
		int insertedId = -1;

		if (nageuse != null) {
			Connection co = this.daoFactory.getConnection();
			try {
				String sql = "insert into Nageuse (nomNageuse, prenomNageuse, dateNaissanceNageuse) "
						+ "values(?,?,?) returning idNageuse";
				PreparedStatement requete = co.prepareStatement(sql);
				requete.setString(1, nageuse.getNom());
				requete.setString(2, nageuse.getPrenom());
				requete.setDate(3, Date.valueOf(nageuse.getDateNaissance()));
				ResultSet rs = requete.executeQuery();

				if (rs.next()) {
					insertedId = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
			} finally {
				co.close();
			}
		}
		return insertedId;
	}
}
