package com.natation.beans;

public class ExecutionFigureBean {
	private int id;
	private NageuseBean nageuse;
	private TypeFigureBean typeFigure;
	private int idBallet;
	private String idJuge;
	
	public ExecutionFigureBean(int id, NageuseBean nageuse, TypeFigureBean typeFigure, int idBallet, String idJuge) {
		this.id = id;
		this.nageuse = nageuse;
		this.typeFigure = typeFigure;
		this.idBallet = idBallet;
		this.idJuge = idJuge;
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
	 * @return the nageuse
	 */
	public NageuseBean getNageuse() {
		return nageuse;
	}

	/**
	 * @param nageuse the nageuse to set
	 */
	public void setNageuse(NageuseBean nageuse) {
		this.nageuse = nageuse;
	}

	/**
	 * @return the typeFigure
	 */
	public TypeFigureBean getTypeFigure() {
		return typeFigure;
	}

	/**
	 * @param typeFigure the typeFigure to set
	 */
	public void setTypeFigure(TypeFigureBean typeFigure) {
		this.typeFigure = typeFigure;
	}

	/**
	 * @return the idBallet
	 */
	public int getIdBallet() {
		return idBallet;
	}

	/**
	 * @param idBallet the idBallet to set
	 */
	public void setIdBallet(int idBallet) {
		this.idBallet = idBallet;
	}

	/**
	 * @return the idJuge
	 */
	public String getIdJuge() {
		return idJuge;
	}

	/**
	 * @param idJuge the idJuge to set
	 */
	public void setIdJuge(String idJuge) {
		this.idJuge = idJuge;
	}
}
