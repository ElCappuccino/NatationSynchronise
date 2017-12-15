package com.natation.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.natation.beans.UtilisateurBean;
import com.natation.dao.DAOFactory;
import com.natation.dao.UtilisateurDAO;
import com.natation.metiers.ConnexionForm;

public class ConnexionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String VUE_CONNEXION = "/WEB-INF/connexion.jsp";
	public static final String VUE_ACCUEIL = "/WEB-INF/accueil.jsp";
	public static final String RESP_ERRORS = "erreurs";
	public static final String RESP_CONNECT = "reponse";
	public static final String CONF_DAOFACTORY = "daofactory";
	public static final String ATTR_SESSION_USERBEAN = "userBean";
	
	private UtilisateurDAO utilisateurDAO;

	@Override
	public void init() throws ServletException {
        /* Récupération d'une instance de DAOUtilisateur */
        this.utilisateurDAO = ( (DAOFactory) getServletContext().getAttribute( CONF_DAOFACTORY ) ).getUtilisateurDao();
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// transmission request/response à la jsp
		this.getServletContext().getRequestDispatcher(VUE_CONNEXION).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Tentative de connexion
		ConnexionForm cf = new ConnexionForm();
		UtilisateurBean utilisateurBean = cf.connecterUser(req);
		
		if(utilisateurBean != null) {
			// Redirection vers l'accueil
			HttpSession session = req.getSession();
			session.setAttribute(ATTR_SESSION_USERBEAN, utilisateurBean);
			this.getServletContext().getRequestDispatcher(VUE_ACCUEIL).forward(req, resp);
		} else {
			// Stockage des messages d'erreur et transmission à la page JSP
			req.setAttribute("erreurs", cf.getErreurs());
			this.getServletContext().getRequestDispatcher(VUE_CONNEXION).forward(req, resp);
		}
	}

	
}
