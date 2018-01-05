package com.natation.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.natation.beans.CompetitionBean;
import com.natation.beans.TourBean;
import com.natation.beans.UtilisateurBean;
import com.natation.dao.CompetitionDAO;
import com.natation.dao.DAOFactory;
import com.natation.dao.TourDAO;
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
	
	private CompetitionDAO competitionDAO;
	private TourDAO tourDAO;
	
	@Override
	public void init() throws ServletException {
        /* Récupération d'une instance de DAOUtilisateur */
        this.competitionDAO = ((DAOFactory)getServletContext().getAttribute(CONF_DAOFACTORY)).getCompetitionDao();
        this.tourDAO = ((DAOFactory)getServletContext().getAttribute(CONF_DAOFACTORY)).getTourDAO();
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
        	NotationForm form = new NotationForm(competitionDAO, tourDAO);
        	
        	// On vérifie si on a une sélection dans une des listes
        	String selec = request.getParameter("selection");
        	if(selec != null) {
        		String value = request.getParameter("valeur");
        		
        		// Selon la liste
            	if(selec.equals("competition")) {
            		// On récupère les tours selon la valeur récupérée
            		ArrayList<TourBean>listTours = form.getTourByIdCompetition(value);
            		final GsonBuilder builder = new GsonBuilder();
            		final Gson gson = builder.create();
            		Map<Integer, String> mapTours = new HashMap<>();
            		for(TourBean t : listTours) {
            			mapTours.put(t.getId(), t.getType().getLibelle());
            		}
            		final String json = gson.toJson(mapTours);
					response.getWriter().write(json);
					return;
            	}
            	// TODO Ballet
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

}
