package com.natation.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.natation.dao.DAOFactory;
import com.natation.dao.UtilisateurDAO;
import com.natation.metiers.ConnexionForm;

public class ConnexionServlet extends HttpServlet {
	
	public static final String VUE = "/WEB-INF/connexion.jsp";
	public static final String RESP_ERRORS = "erreurs";
	public static final String RESP_CONNECT = "reponse";
	public static final String CONF_DAOFACTORY = "daofactory";
	
	private UtilisateurDAO utilisateurDAO;

	@Override
	public void init() throws ServletException {
        /* Récupération d'une instance de DAOUtilisateur */
        this.utilisateurDAO = ( (DAOFactory) getServletContext().getAttribute( CONF_DAOFACTORY ) ).getUtilisateurDao();
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// transmission request/response à la jsp
		this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Tentative de connexion
		ConnexionForm cf = new ConnexionForm();
		cf.connecterUser(req);
		
		// Stockage des messages d'erreur et transmission à la page JSP
		req.setAttribute("erreurs", cf.getErreurs());
		this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
	}

	
}
