package com.natation.metiers;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.natation.beans.NageuseBean;
import com.opencsv.CSVReader;



public final class AdminForm {
	
	
	public String getUploadedCsv(HttpServletRequest req) {
		
	    
		try {
			List<NageuseBean> nageusesCSV = new ArrayList<NageuseBean>();
			
			// Récupération csv nageuse <input type="file" name="csvNageuses">
			Part filePart;
			filePart = req.getPart("csvNageuses");
			
			// Création d'un CsvReader à partir du contenu du fichier
		    InputStream fileContent = filePart.getInputStream();
		    CSVReader reader = new CSVReader(
		    		new InputStreamReader(fileContent, "UTF-8")
		    		);
		    
		    // Creation instances NageuseBean à partir des données du csv
		    String[] ligneCSV = null;
		    while ((ligneCSV = reader.readNext()) != null) {
				NageuseBean n = new NageuseBean();
				//emp.setId(record[0]);
				//emp.setName(record[1]);
				// TODO : valoriser nageuse
				nageusesCSV.add(n);
			}
		    
		    reader.close();		    
		} catch (Exception e) {
			
		}

		return null;
	}
}
