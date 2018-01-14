package com.natation.beans;

public class ClubBean {
	private int id;
	private DirigeantBean dirigeant;
	private String nom;
	
	public ClubBean(int unId, DirigeantBean unDirigeant, String unNom) {
		this.id = unId;
		this.dirigeant = unDirigeant;
		this.nom = unNom;
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
	 * @return the dirigeant
	 */
	public DirigeantBean getDirigeant() {
		return dirigeant;
	}

	/**
	 * @param dirigeant the dirigeant to set
	 */
	public void setDirigeant(DirigeantBean dirigeant) {
		this.dirigeant = dirigeant;
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
}
