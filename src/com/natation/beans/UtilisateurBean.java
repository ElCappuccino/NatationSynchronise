package com.natation.beans;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UtilisateurBean {

	private String id;
	private String nom;
	private String prenom;
	private String mdp;
	private Boolean admin;
	
	/**
	 * Constructeur complet bean utilisateur
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param mdp
	 * @param admin
	 */
	public UtilisateurBean(String id, String nom, String prenom, String mdp, Boolean admin) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mdp = mdp;
		this.admin = admin;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return true si mdp valide, false sinon
	 * @throws NoSuchAlgorithmException 
	 * @throws UnsupportedEncodingException 
	 */
	public Boolean verifyPassword(String unMdp) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// Hasher le mdp en SHA-512
		MessageDigest hasher = MessageDigest.getInstance("SHA-512");
		byte[] hashMdpBytes = hasher.digest(unMdp.getBytes("UTF-8"));
		
		// Reconstituer une chaine de caractères pour comparer avec données en base
		StringBuilder sb = new StringBuilder();
        for(int i=0; i< hashMdpBytes.length ;i++){
           sb.append(Integer.toString((hashMdpBytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        String hashMdpString = sb.toString();
		
        // Comparaison hash passé en param et hash généré
		return ( this.mdp.equals(hashMdpString) );
	}

	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * @return the admin
	 */
	public Boolean getAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
}
