package com.natation.beans;

public class TypeJugeBean {
	private int id;
	private double coeff;
	private String libelle;
	
	public TypeJugeBean(int id, double coeff, String libelle) {
		this.id = id;
		this.coeff = coeff;
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
	 * @return the coeff
	 */
	public double getCoeff() {
		return coeff;
	}

	/**
	 * @param coeff the coeff to set
	 */
	public void setCoeff(double coeff) {
		this.coeff = coeff;
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
