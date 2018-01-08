package com.natation.beans;

public class BalletBean {
	private int id;
	private TypeBalletBean typeBallet;
	private int idEpreuve;
	private double penalite;
	
	public BalletBean(int id, TypeBalletBean typeBallet, int idEpreuve, double penalite) {
		this.id = id;
		this.typeBallet = typeBallet;
		this.idEpreuve = idEpreuve;
		this.penalite = penalite;
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
	 * @return the typeBallet
	 */
	public TypeBalletBean getTypeBallet() {
		return typeBallet;
	}

	/**
	 * @param typeBallet the typeBallet to set
	 */
	public void setTypeBallet(TypeBalletBean typeBallet) {
		this.typeBallet = typeBallet;
	}

	/**
	 * @return the idEpreuve
	 */
	public int getIdEpreuve() {
		return idEpreuve;
	}

	/**
	 * @param idEpreuve the idEpreuve to set
	 */
	public void setIdEpreuve(int idEpreuve) {
		this.idEpreuve = idEpreuve;
	}

	/**
	 * @return the penalite
	 */
	public double getPenalite() {
		return penalite;
	}

	/**
	 * @param penalite the penalite to set
	 */
	public void setPenalite(double penalite) {
		this.penalite = penalite;
	}


}
