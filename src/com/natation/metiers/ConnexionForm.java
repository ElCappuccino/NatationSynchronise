package com.natation.metiers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.natation.beans.UtilisateurBean;

public final class ConnexionForm {

	public static final String FORM_USERNAME = "identifiant";
	public static final String FORM_PASSWORD = "password";

	private Map<String, String> erreurs = new HashMap<>();

	/**
	 * Connecte l'utilisateur avec l'id et le mdp fournit dans la requête POST
	 * @param req
	 * @return l'instance de l'utilisateur si ok, null sinon
	 */
	public UtilisateurBean connecterUser(HttpServletRequest req) {

		// Recuperation et verification du contenu des paramètres
		try {
			verifierValeur(req.getParameter(FORM_USERNAME));
			verifierValeur(req.getParameter(FORM_PASSWORD));
		} catch (Exception e) {
			erreurs.put("errChamps", e.getMessage());
		}

		return null;
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
