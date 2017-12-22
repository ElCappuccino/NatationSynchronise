package com.natation.beans;

public class TypeTourBean {
	private int id;
	private String libelle;
	
	/**
	 * Constructeur
	 * @param id
	 * @param libelle
	 */
	public TypeTourBean(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	/**
	 * @return Id du type de tour
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id Id du type de tour
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return Libelle du type
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle Libelle du type
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
