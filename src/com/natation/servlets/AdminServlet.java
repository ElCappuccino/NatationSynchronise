package com.natation.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.natation.beans.UtilisateurBean;
import com.natation.dao.DAOFactory;
import com.natation.dao.NageuseDAO;
import com.natation.metiers.AdminForm;

/**
 * Servlet implementation class CompetitionServlet
 */
@MultipartConfig
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String REDIRECT = "/connect";
	public static final String VUE = "/WEB-INF/admin.jsp";
	public static final String ATTR_SESSION_USERBEAN = "userBean";
	public static final String CONF_DAOFACTORY = "daofactory";

	private NageuseDAO nageuseDAO;
	
	@Override
	public void init() throws ServletException {
        /* Récupération d'une instance de DAONageuse */
        this.nageuseDAO = ( (DAOFactory) getServletContext().getAttribute( CONF_DAOFACTORY ) ).getNageuseDAO();
    }
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UtilisateurBean u = (UtilisateurBean) session.getAttribute( ATTR_SESSION_USERBEAN );
		AdminForm af = new AdminForm(this.nageuseDAO);
		
        if ( u == null ) {
            /* Redirection vers la page publique */
        	resp.sendRedirect( req.getContextPath() + REDIRECT );
        } else {
            /* Affichage de la page d'admin seulement si l'utilisateur est ADMIN */
        	if( u.getAdmin() ) {
				req.setAttribute("messages", af.getMessages());
				this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
        	}
        	else
        		resp.sendRedirect( req.getContextPath() + REDIRECT );
        }
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UtilisateurBean u = (UtilisateurBean) session.getAttribute( ATTR_SESSION_USERBEAN );
		AdminForm af = new AdminForm(this.nageuseDAO);
		
        if ( u == null ) {
            /* Redirection vers la page publique */
        	resp.sendRedirect( req.getContextPath() + REDIRECT );
        } else {
            /* Affichage de la page d'admin seulement si l'utilisateur est ADMIN */
        	if( u.getAdmin() ) {
				af.uploadCsv(req);
				req.setAttribute("messages", af.getMessages());
				this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
        	}
        	else
        		resp.sendRedirect( req.getContextPath() + REDIRECT );
        }
	}

}
