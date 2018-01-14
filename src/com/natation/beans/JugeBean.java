package com.natation.beans;

public class JugeBean {
	private String idUser;
	private TypeJugeBean typeJuge;
	
	public JugeBean(String idUser, TypeJugeBean typeJuge) {
		this.idUser = idUser;
		this.typeJuge = typeJuge;
	}

	/**
	 * @return the idUser
	 */
	public String getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the typeJuge
	 */
	public TypeJugeBean getTypeJuge() {
		return typeJuge;
	}

	/**
	 * @param typeJuge the typeJuge to set
	 */
	public void setTypeJuge(TypeJugeBean typeJuge) {
		this.typeJuge = typeJuge;
	}
}
