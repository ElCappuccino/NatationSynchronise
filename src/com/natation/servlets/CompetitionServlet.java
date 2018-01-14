package com.natation.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.natation.beans.CompetitionBean;
import com.natation.beans.UtilisateurBean;
import com.natation.dao.DAOFactory;
import com.natation.metiers.NotationForm;

/**
 * Servlet implementation class CompetitionServlet
 */
public class CompetitionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String REDIRECT = "/connect";
	public static final String VUE = "/WEB-INF/competition.jsp";
	public static final String ATTR_SESSION_USERBEAN = "userBean";
	public static final String CONF_DAOFACTORY = "daofactory";
	public static final String RESP_ERRORS = "erreurs";
	
	private DAOFactory daoFactory;
	
	@Override
	public void init() throws ServletException {
		this.daoFactory = (DAOFactory) getServletContext().getAttribute(CONF_DAOFACTORY);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		/*
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        if ( session.getAttribute( ATTR_SESSION_USERBEAN ) == null ) {
            /* Redirection vers la page publique */
            response.sendRedirect( request.getContextPath() + REDIRECT );
        } else {
        	NotationForm form = new NotationForm(daoFactory);
        	
        	// On vérifie si on a une sélection dans une des listes
        	String selec = request.getParameter("selection");
        	if(selec != null) {
        		form.sendFields(request, response, session, selec);
        		return;
        	} else {
        		// On récupère toutes les compétitions pour la liste
            	ArrayList<CompetitionBean>listCompet = form.getCompetitionsByUser(((UtilisateurBean)session.getAttribute("userBean")).getId());
            	request.setAttribute("listeCompetitions", listCompet);
        	}
        	
        	request.setAttribute(RESP_ERRORS, form.getErreurs());
            /* Affichage de la page restreinte */
        	this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
        }
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		/*
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        if ( session.getAttribute( ATTR_SESSION_USERBEAN ) == null ) {
            /* Redirection vers la page publique */
            response.sendRedirect( request.getContextPath() + REDIRECT );
        } else {
        	// On récupère la liste des noms d'attribut, 
//    		Enumeration<String> attributs =request.getAttributeNames();
//        	while(attributs.hasMoreElements()) {
//        		String s = attributs.nextElement();
//        		System.out.println(s);
//        	}
        	this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
        }
	}

}
