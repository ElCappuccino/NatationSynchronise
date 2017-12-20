package com.natation.beans;

import java.sql.Date;

public class CompetitionBean {
	private int id;
	private int idCategorie;
	private String idUtilisateur;
	private Date dateDebut;
	private Date dateFin;
	private String libelle;
	private LieuBean lieu;

	/**
	 * Constructeur d'une competition
	 * @param idCompetition id de la compétition
	 * @param idLieu Référence au lieu de la compétition
	 * @param idCategorie Référence à la catégorie de la compétition
	 * @param idUtilisateur Référence au juge arbitre assigné à la compétition
	 */
	public CompetitionBean(int id, int idCategorie, String idUtilisateur, Date dateDebut, Date dateFin, String libelle, LieuBean lieu) {
		this.id = id;
		this.idCategorie = idCategorie;
		this.idUtilisateur = idUtilisateur;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.lieu = lieu;
	}

	/**
	 * @return id de la compétition
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param idCompetition id de la compétition
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return R�f�rence � la cat�gorie
	 */
	public int getIdCategorie() {
		return idCategorie;
	}

	/**
	 * @param idCategorie Référence à la catégorie
	 */
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	/**
	 * @return Référence au juge arbitre
	 */
	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * @param idUtilisateur Référence au juge arbitre
	 */
	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	/**
	 * @return Date du début de la compétition
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut Date du début de la compétition
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return Date de fin de la compétition
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin Date de fin de la compétition
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return Libelle de la compétition
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle Libelle de la compétition
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return Bean du lieu de la compétition
	 */
	public LieuBean getLieu() {
		return lieu;
	}

	/**
	 * @param lieu Bean du lieu de la compétition
	 */
	public void setLieu(LieuBean lieu) {
		this.lieu = lieu;
	}
}
