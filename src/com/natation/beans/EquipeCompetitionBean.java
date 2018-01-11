package com.natation.beans;

public class EquipeCompetitionBean {
	private EquipeBean equipe;
	private int idCompetition;
	
	public EquipeCompetitionBean(EquipeBean equipe, int idCompetition) {
		this.equipe = equipe;
		this.idCompetition = idCompetition;
	}

	/**
	 * @return the idCompetition
	 */
	public int getIdCompetition() {
		return idCompetition;
	}

	/**
	 * @param idCompetition the idCompetition to set
	 */
	public void setIdCompetition(int idCompetition) {
		this.idCompetition = idCompetition;
	}

	/**
	 * @return the idEquipe
	 */
	public EquipeBean getEquipe() {
		return equipe;
	}

	/**
	 * @param idEquipe the idEquipe to set
	 */
	public void setEquipe(EquipeBean equipe) {
		this.equipe = equipe;
	}
}
