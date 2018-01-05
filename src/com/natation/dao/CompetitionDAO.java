package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import com.natation.beans.CategorieBean;
import com.natation.beans.CompetitionBean;
import com.natation.beans.LieuBean;

public class CompetitionDAO {
	private DAOFactory daoFactory;
	private LieuDAO lieuDAO;
	private CategorieDAO categorieDAO;
	
	public CompetitionDAO(DAOFactory factory) {
		this.daoFactory = factory;
		this.lieuDAO = factory.getLieuDAO();
		this.categorieDAO = factory.getCategorieDAO();
	}
	
	/**
	 * Récupère les compétitions liés à un utilisateur
	 * @param idUtilisateur
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<CompetitionBean> getCompetitionByUtilisateur(String idUtilisateur) throws SQLException {
		ArrayList<CompetitionBean> listCompet = new ArrayList<>();
		Connection co = this.daoFactory.getConnection();
		
		try {
			String sql = "select c.idCompetition, c.idLieu, c.idCategorie, c.idUtilisateur, "
					+ "c.dateDebutCompetition, c.dateFinCompetition, c.libelleCompetition "
					+ "from competition c "
					+ "inner join jugecompetition jc on c.idCompetition = jc.idCompetition "
					+ "where lower(jc.idutilisateur) = lower(?)";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setString(1, idUtilisateur);

			ResultSet rs = requete.executeQuery();
			while(rs.next()) {
				CompetitionBean comp = new CompetitionBean(
						rs.getInt(1),
						null,
						idUtilisateur,
						LocalDate.parse(rs.getString(5)),
						LocalDate.parse(rs.getString(6)),
						rs.getString(7),
						null
						);
				// On récupère le lieu lié à la compétition
				LieuBean lieu = lieuDAO.getLieuById(rs.getInt(2));
				comp.setLieu(lieu);
				// On récupère la catégorie lié à la compétition
				CategorieBean categorie = categorieDAO.getCategorieById(rs.getInt(3));
				comp.setCategorie(categorie);
				listCompet.add(comp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		
		return listCompet;
	}

}
