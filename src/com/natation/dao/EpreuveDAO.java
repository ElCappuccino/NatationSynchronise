package com.natation.dao;

public class EpreuveDAO {
	private DAOFactory daoFactory;
	private TypeEpreuveDAO daoTypeEpreuve;
	
	public EpreuveDAO(DAOFactory factory) {
		this.daoFactory = factory;
		this.daoTypeEpreuve = factory.getTypeEpreuveDAO();
	}
}
