package com.natation.beans;

public class DirigeantBean {
	private int id;
	private LieuBean lieu;
	private String nom;
	private String prenom;
	
	public DirigeantBean (int unId, LieuBean unLieu, String unNom, String unPrenom) {
		this.id = unId;
		this.lieu = unLieu;
		this.nom = unNom;
		this.prenom = unPrenom;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the lieu
	 */
	public LieuBean getLieu() {
		return lieu;
	}

	/**
	 * @param lieu the lieu to set
	 */
	public void setLieu(LieuBean lieu) {
		this.lieu = lieu;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
