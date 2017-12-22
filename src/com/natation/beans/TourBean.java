package com.natation.beans;

public class TourBean {
	private int id;
	private TypeTourBean type;
	private int idCompetition;
	
	public TourBean(int id, TypeTourBean type, int idCompetition) {
		this.id = id;
		this.type = type;
		this.idCompetition = idCompetition;
	}

	/**
	 * @return Id du tour
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id Id du tour
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return Type du tour
	 */
	public TypeTourBean getType() {
		return type;
	}

	/**
	 * @param type Type du tour
	 */
	public void setType(TypeTourBean type) {
		this.type = type;
	}

	/**
	 * @return Id de la compétition associée
	 */
	public int getIdCompetition() {
		return idCompetition;
	}

	/**
	 * @param idCompetition Id de la compétition associée
	 */
	public void setIdCompetition(int idCompetition) {
		this.idCompetition = idCompetition;
	}
}
