package com.natation.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeconnexionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String VUE = "/connect";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Destruction de la session 
		HttpSession session = req.getSession();
		session.invalidate();
		// Redirection a la page de connexion
		resp.sendRedirect( req.getContextPath() + VUE);
	}
}
