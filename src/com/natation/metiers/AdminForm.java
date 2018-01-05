package com.natation.metiers;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.natation.beans.NageuseBean;
import com.opencsv.CSVReader;

public final class AdminForm {

	public String uploadCsv(HttpServletRequest req) {

		if (req.getParameter("csvNageuses") != null) {
			List<NageuseBean> nouvellesNageuses = parseNageuses(req);
			// TODO : insert nageuses en BdD
		}
		return null;
	}
	
	private List<NageuseBean> parseNageuses(HttpServletRequest req) {
		List<NageuseBean> nouvellesNageuses = new ArrayList<NageuseBean>();
		
		try {
			// Récupération csv nageuses
			Part filePart;
			filePart = req.getPart("csvNageuses");

			// Création d'un CsvReader à partir du contenu envoyé
			InputStream fileContent = filePart.getInputStream();
			CSVReader reader = new CSVReader(new InputStreamReader(fileContent, "UTF-8"));

			// Creation instances NageuseBean à partir des données du csv
			// Contenu CSV attendu : nom, prenom, dateNaissance
			String[] ligneCSV = null;
			while ((ligneCSV = reader.readNext()) != null) {
				NageuseBean n = new NageuseBean(
						ligneCSV[0],
						ligneCSV[1],
						LocalDate.parse(ligneCSV[2])
						);
				nouvellesNageuses.add(n);
			}
			reader.close();
		} catch (Exception e) {

		}
		
		return nouvellesNageuses;
	}
}
