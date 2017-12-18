package com.natation.beans;

public class CategorieBean {
	private int id;
	private String libelle;
	
	/**
	 * Constructeur de Categorie
	 * @param id
	 * @param libelle
	 */
	public CategorieBean(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
