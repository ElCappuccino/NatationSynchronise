package com.natation.beans;

import java.time.LocalDate;

public class CompetitionBean {
	private int id;
	private CategorieBean categorie;
	private String idUtilisateur;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private String libelle;
	private LieuBean lieu;

	/**
	 * Constructeur d'une competition
	 * @param idCompetition id de la compétition
	 * @param idLieu Référence au lieu de la compétition
	 * @param idCategorie Référence à la catégorie de la compétition
	 * @param idUtilisateur Référence au juge arbitre assigné à la compétition
	 */
	public CompetitionBean(int id, CategorieBean categorie, String idUtilisateur, LocalDate dateDebut, LocalDate dateFin, String libelle, LieuBean lieu) {
		this.id = id;
		this.categorie = categorie;
		this.idUtilisateur = idUtilisateur;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.lieu = lieu;
		this.libelle = libelle;
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
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut Date du début de la compétition
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return Date de fin de la compétition
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin Date de fin de la compétition
	 */
	public void setDateFin(LocalDate dateFin) {
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

	/**
	 * @return Bean de la catégorie de la compétition
	 */
	public CategorieBean getCategorie() {
		return categorie;
	}
	
	
	/**
	 * @param categorie Bean de la catégorie de la compétition
	 */
	public void setCategorie(CategorieBean categorie) {
		this.categorie = categorie;
	}
}
