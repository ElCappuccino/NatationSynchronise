package com.natation.beans;

public class LieuBean {
	private int id;
	private int numero;
	private String rue;
	private int codePostal;
	private String ville;
	
	/**
	 * Constructeur d'un lieu
	 * @param id
	 * @param numero
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public LieuBean(int id, int numero, String rue, int codePostal, String ville) {
		this.id = id;
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	/**
	 * @return Numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
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
	 * @return rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * @param rue
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * @return codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
}
