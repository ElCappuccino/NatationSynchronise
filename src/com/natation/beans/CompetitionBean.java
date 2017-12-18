package com.natation.beans;

import java.sql.Date;

public class CompetitionBean {
	private int id;
	private int idLieu;
	private int idCategorie;
	private String idUtilisateur;
	private Date dateDebut;
	private Date dateFin;
	private String libelle;

	/**
	 * Constructeur d'une competition
	 * @param idCompetition id de la comp�tition
	 * @param idLieu R�f�rence au lieu de la comp�tition
	 * @param idCategorie R�f�rence � la cat�gorie de la comp�tition
	 * @param idUtilisateur R�f�rence au juge arbitre assign� � la comp�tition
	 */
	public CompetitionBean(int id, int idLieu, int idCategorie, String idUtilisateur, Date dateDebut, Date dateFin, String libelle) {
		this.id = id;
		this.idLieu = idLieu;
		this.idCategorie = idCategorie;
		this.idUtilisateur = idUtilisateur;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	/**
	 * @return id de la comp�tition
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param idCompetition id de la comp�tition
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
	 * @param idCategorie R�f�rence � la cat�gorie
	 */
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	/**
	 * @return R�f�rence au lieu
	 */
	public int getIdLieu() {
		return idLieu;
	}

	/**
	 * @param idLieu R�f�rence au lieu
	 */
	public void setIdLieu(int idLieu) {
		this.idLieu = idLieu;
	}

	/**
	 * @return R�f�rence au juge arbitre
	 */
	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * @param idUtilisateur R�f�rence au juge arbitre
	 */
	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	/**
	 * @return Date du d�but de la comp�tition
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut Date du d�but de la comp�tition
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return Date de fin de la comp�tition
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin Date de fin de la comp�tition
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return Libelle de la comp�tition
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle Libelle de la comp�tition
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
