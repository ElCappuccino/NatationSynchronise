package com.natation.dao;

public class ExecutionFigureDAO {
	private DAOFactory daoFactory;
	private TypeFigureDAO daoTypeFigure;

	
	public ExecutionFigureDAO(DAOFactory factory) {
		this.daoFactory = factory;
		this.daoTypeFigure = factory.getTypeFigureDAO();
	}
	
	//public 
}
