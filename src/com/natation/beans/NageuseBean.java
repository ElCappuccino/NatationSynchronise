package com.natation.beans;

import java.time.LocalDate;

public class NageuseBean {
	private int id;
	private String nom; 
	private String prenom;
	private LocalDate dateNaissance;
	
	/**
	 * Constructeur complet
	 * @param unId
	 * @param unNom
	 * @param unPrenom
	 * @param uneDate
	 */
	public NageuseBean (int unId, String unNom, String unPrenom, LocalDate uneDate) {
		this.id = unId;
		this.nom = unNom;
		this.prenom = unPrenom;
		this.dateNaissance = uneDate;
	}
	
	/**
	 * Constructeur partiel sans id de nageuse
	 * @param unNom
	 * @param unPrenom
	 * @param uneDate
	 */
	public NageuseBean (String unNom, String unPrenom, LocalDate uneDate) {
		this.nom = unNom;
		this.prenom = unPrenom;
		this.dateNaissance = uneDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
}
