package com.natation.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.natation.dao.DAOFactory;

public class InitialisationDAOFactory implements ServletContextListener {
	private static final String CONF_DAOFACTORY = "daofactory";
	private DAOFactory daoFactory;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		/* Ajout de l'instance de DAOFactory dans un attribut avec portée globale à l'appli */
        ServletContext servletContext = sce.getServletContext();

        try {
			this.daoFactory = DAOFactory.getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        servletContext.setAttribute( CONF_DAOFACTORY, this.daoFactory );
	}
}
