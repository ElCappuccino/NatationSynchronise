package com.natation.beans;

public class EpreuveBean {
	private int id;
	private int idTour;
	private TypeEpreuveBean typeEpreuve;
	
	public EpreuveBean(int id, int idTour, TypeEpreuveBean typeEpreuve) {
		this.id = id;
		this.idTour = idTour;
		this.typeEpreuve = typeEpreuve;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdTour() {
		return idTour;
	}

	public void setIdTour(int idTour) {
		this.idTour = idTour;
	}

	public TypeEpreuveBean getTypeEpreuve() {
		return typeEpreuve;
	}

	public void setTypeEpreuve(TypeEpreuveBean typeEpreuve) {
		this.typeEpreuve = typeEpreuve;
	}
}
