package com.natation.metiers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.natation.beans.BalletBean;
import com.natation.beans.CompetitionBean;
import com.natation.beans.EpreuveBean;
import com.natation.beans.EquipeBean;
import com.natation.beans.EquipeCompetitionBean;
import com.natation.beans.NageuseBean;
import com.natation.beans.TourBean;
import com.natation.dao.BalletDAO;
import com.natation.dao.CompetitionDAO;
import com.natation.dao.EpreuveDAO;
import com.natation.dao.EquipeCompetitionDAO;
import com.natation.dao.EquipeDAO;
import com.natation.dao.ExecutionFigureDAO;
import com.natation.dao.TourDAO;

public class NotationForm {
	private CompetitionDAO competitionDAO;
	private TourDAO tourDAO;
	private EpreuveDAO epreuveDAO;
	private BalletDAO balletDAO;
	private ExecutionFigureDAO executionFigureDAO;
	private EquipeDAO equipeDAO;
	private EquipeCompetitionDAO equipeCompetitionDAO;
	private Map<String, String> erreurs = new HashMap<>();
	
	/**
	 * Constructeur
	 */
	public NotationForm(CompetitionDAO competitionDAO, TourDAO tourDAO, EpreuveDAO epreuveDAO, BalletDAO balletDAO,
			ExecutionFigureDAO executionFigureDAO, EquipeDAO equipeDAO, EquipeCompetitionDAO equipeCompetitionDAO) {
		this.competitionDAO = competitionDAO;
		this.tourDAO = tourDAO;
		this.epreuveDAO = epreuveDAO;
		this.balletDAO = balletDAO;
		this.executionFigureDAO = executionFigureDAO;
		this.equipeDAO = equipeDAO;
		this.equipeCompetitionDAO = equipeCompetitionDAO;
	}
	
	/**
	 * Récupère une liste des compétitions associé à un utilisateur
	 * @param idUser
	 * @return Liste des compétitions
	 */
	public ArrayList<CompetitionBean> getCompetitionsByUser(String idUser) {
		ArrayList<CompetitionBean> list = null;
		try {
			list = competitionDAO.getCompetitionByUtilisateur(idUser);
		} catch (SQLException e) {
			erreurs.put("getCompetitionsByUser", e.getMessage());
		}
		return list;
	}
	
	/**
	 * Récupère une liste de tour associé à une compétition
	 * @param idCompetition
	 * @return Liste de tour
	 */
	public ArrayList<TourBean> getTourByIdCompetition(String idCompetition) {
		ArrayList<TourBean> list = null;
		try {
			int val = Integer.parseInt(idCompetition);
			list = tourDAO.getTourByIdCompetition(val);
		} catch(Exception e) {
			erreurs.put("getTourByIdCompetition", e.getMessage());
		}
		return list;
	}
	
	/**
	 * Récupère une liste d'epreuve associé à un tour
	 * @param idTour
	 * @return Liste d'epreuve
	 */
	public ArrayList<EpreuveBean> getEpreuveByIdTour(String idTour) {
		ArrayList<EpreuveBean> list = null;
		try {
			int val = Integer.parseInt(idTour);
			list = epreuveDAO.getEpreuveByIdTour(val);
		} catch(Exception e) {
			erreurs.put("getEpreuveByIdTour", e.getMessage());
		}
		return list;
	}
	
	public ArrayList<BalletBean> getBalletByIdEpreuve(String idEpreuve) {
		ArrayList<BalletBean> list = null;
		try {
			int val = Integer.parseInt(idEpreuve);
			list = balletDAO.getBalletByIdEpreuve(val);
		} catch(Exception e) {
			erreurs.put("getBalletByIdEpreuve", e.getMessage());
		}
		return list;
	}
	
	public ArrayList<EquipeBean> getEquipeByIdCompetition(String idJuge, String idCompet, String idBallet) {
		ArrayList<EquipeBean> list = new ArrayList<>();
		try {
			int valCompet = Integer.parseInt(idCompet);
			int valBallet = Integer.parseInt(idBallet);
			
			// On récupere les équipe liées à la compétition
			ArrayList<EquipeCompetitionBean> equipeCompet = equipeCompetitionDAO.getEquipeCompetionByIdCompetition(valCompet);
			
			for(EquipeCompetitionBean ec : equipeCompet) { // On récupère la liste de nageuse de chaque équipes
				Boolean verif = false;
				ArrayList<NageuseBean> nageuses = equipeDAO.getNageusesByIdEquipe(ec.getEquipe().getId());
				for(NageuseBean n : nageuses) { // Pour chaque nageuse on test son existence dans ExecutionFigure quand le ballet vaut idBallet et le juge idJuge
					if(executionFigureDAO.checkExecutionFigureExist(idJuge, valBallet, n.getId())) {
						verif = true;
						break;
					}
				}
				// Si une nageuse est présente on ajoute pas l'équipe dans list (on considère qu'elle a déjà recu une note sur ce ballet)
				if(!verif)
					list.add(ec.getEquipe());
			}	
			
		} catch (Exception e) {
			erreurs.put("getEquipeByIdCompetition", e.getMessage());
		}
		return list;
	}
	
	public Map<String, String> getErreurs(){
		return erreurs;
	}
}