package com.natation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {
	
	private String url;
	private String username;
	private String password;


	/**
	 * Constructeur
	 * @param url
	 * @param username
	 * @param password
	 */
	DAOFactory(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}


	/**
	 * Créé une connexion à la BdD et instancie un DAOFactory en cas de succès
	 * @return instance de DAOFactory
	 * @throws Exception
	 */
	public static DAOFactory getInstance() throws Exception {
		// Recup du driver
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("Le driver SQL est introuvable");
		}

		DAOFactory instance = new DAOFactory("localhost:5432/BaseNatation", "postgres", "password");
		return instance;
	}

	/**
	 * Fournit la connection à la BdD
	 * @return la connection
	 * @throws SQLException
	 */
	Connection getConnection() throws SQLException {
		try {
			return DriverManager.getConnection(("jdbc:postgresql://" + url), username, password);
		} catch (SQLException e) {
			throw new SQLException("Erreur de connection à la base de données. Veuillez contacter l'administrateur système. ");
		}
	}

	/*
	 * Méthodes de récupération de l'implémentation des différents DAO (un seul pour
	 * le moment)
	 */
	public UtilisateurDAO getUtilisateurDao() {
		return new UtilisateurDAO(this);
	}
	
	/**
	 * @return DAO lié à compétition
	 */
	public CompetitionDAO getCompetitionDao() {
		return new CompetitionDAO(this);
	}
	
	/**
	 * @return DAO lié à un lieu
	 */
	public LieuDAO getLieuDAO() {
		return new LieuDAO(this);
	}
	
	/**
	 * @return DAO lié à une catégorie
	 */
	public CategorieDAO getCategorieDAO() {
		return new CategorieDAO(this);
	}
	
	/**
	 * @return DAO lié à un tour
	 */
	public TourDAO getTourDAO() {
		return new TourDAO(this);
	}
	
	/**
	 * @return DAO lié au type de tour
	 */
	public TypeTourDAO getTypeTourDAO() {
		return new TypeTourDAO(this);
	}
	
	/**
	 * @return DAO lié à une épreuve
	 */
	public EpreuveDAO getEpreuveDAO() {
		return new EpreuveDAO(this);
	}
	
	/**
	 * @return DAO lié à un type d'épreuve
	 */
	public TypeEpreuveDAO getTypeEpreuveDAO() {
		return new TypeEpreuveDAO(this);
	}
	
	/**
	 * @return DAO lié à un ballet
	 */
	public BalletDAO getBalletDAO() {
		return new BalletDAO(this);
	}
	
	/**
	 * @return DAO lié à un type de ballet
	 */
	public TypeBalletDAO getTypeBalletDAO() {
		return new TypeBalletDAO(this);
	}
}
