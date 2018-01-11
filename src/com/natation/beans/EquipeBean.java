package com.natation.beans;

public class EquipeBean {
	private int id;
	private int idClub;
	private String libelle;
	
	public EquipeBean(int id, int idClub, String libelle) {
		this.id = id;
		this.idClub = idClub;
		this.libelle = libelle;
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
	 * @return the idClub
	 */
	public int getIdClub() {
		return idClub;
	}

	/**
	 * @param idClub the idClub to set
	 */
	public void setIdClub(int idClub) {
		this.idClub = idClub;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
