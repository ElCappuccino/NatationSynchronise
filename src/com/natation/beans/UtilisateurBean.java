package com.natation.beans;

public class UtilisateurBean {

	String id;
	String nom;
	String prenom;
	String mdp;
	Boolean admin;
	
	/**
	 * Constructeur complet bean utilisateur
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param mdp
	 * @param admin
	 */
	public UtilisateurBean(String id, String nom, String prenom, String mdp, Boolean admin) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mdp = mdp;
		this.admin = admin;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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

	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * @return the admin
	 */
	public Boolean getAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
}
