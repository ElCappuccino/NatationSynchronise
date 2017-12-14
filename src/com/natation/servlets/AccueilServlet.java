package com.natation.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccueilServlet
 */
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VUE = "/WEB-INF/accueil.jsp";
	public static final String NAME = "accueil";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
}
