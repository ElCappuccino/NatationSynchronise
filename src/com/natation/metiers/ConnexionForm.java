package com.natation.metiers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.natation.beans.UtilisateurBean;
import com.natation.dao.UtilisateurDAO;

public final class ConnexionForm {

	private static final String FORM_USERNAME = "identifiant";
	private static final String FORM_PASSWORD = "password";
	private UtilisateurDAO utilisateurDAO;
	private Map<String, String> erreurs = new HashMap<>();

	public ConnexionForm(UtilisateurDAO u) {
		this.utilisateurDAO = u;
	}

	/**
	 * Connecte l'utilisateur avec l'id et le mdp fournit dans la requête POST
	 * 
	 * @param req
	 * @return l'instance de l'utilisateur si ok, null sinon
	 */
	public UtilisateurBean connecterUser(HttpServletRequest req) {
		String id = req.getParameter(FORM_USERNAME);
		String mdp = req.getParameter(FORM_PASSWORD);
		UtilisateurBean uBean = null;
		UtilisateurBean uBeanResult = null;

		try {
			verifierValeur(id);
			verifierValeur(mdp);
			// Recuperation du l'utilisateur avec l'id renseigné
			uBean = utilisateurDAO.getUtilisateurById(id);
			if (uBean != null) {
				if (uBean.verifyPassword(mdp)) {
					// Si user existe ET mdp ok, il est retourné
					uBeanResult = uBean;
				} else {
					throw new Exception("Indentifiant ou mot de passe erroné");
				}
			} else {
				throw new Exception("Indentifiant ou mot de passe erroné");
			}
		} catch (Exception e) {
			erreurs.put("errLogin", e.getMessage());
		}

		return uBeanResult;
	}

	/**
	 * Verifie si la chaine n'est pas vide ou nulle
	 * 
	 * @param value
	 *            la chaine a verifier
	 * @return la chaine entrée en parametre
	 * @throws Exception
	 */
	private void verifierValeur(String value) throws Exception {
		if (value == null || value.equals(""))
			throw new Exception("Veuillez remplir tous les champs");
	}

	/**
	 * @return les erreurs
	 */
	public Map<String, String> getErreurs() {
		return erreurs;
	}
}
