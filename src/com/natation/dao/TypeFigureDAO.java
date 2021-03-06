package com.natation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.natation.beans.TypeFigureBean;

public class TypeFigureDAO {
	private DAOFactory daoFactory;
	
	public TypeFigureDAO(DAOFactory factory) {
		this.daoFactory = factory;
	}
	
	public TypeFigureBean getTypeFigureById(int idTypeFigure) throws SQLException {
		TypeFigureBean typeFigure = null;
		
		Connection co = this.daoFactory.getConnection();
		try {
			String sql = "select * from typefigure where idtypefigure = ?";
			PreparedStatement requete = co.prepareStatement(sql);
			requete.setInt(1, idTypeFigure);

			ResultSet rs = requete.executeQuery();
			if(rs.next()) {
				typeFigure = new TypeFigureBean(
						rs.getInt(1),
						rs.getString(2)
						);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		
		return typeFigure;
	}
	
	public ArrayList<TypeFigureBean> getAllTypeFigure() throws SQLException {
		ArrayList<TypeFigureBean> list = new ArrayList<>();
		
		Connection co = this.daoFactory.getConnection();
		try {
			String sql = "select * from typefigure";
			PreparedStatement requete = co.prepareStatement(sql);
			ResultSet rs = requete.executeQuery();
			while(rs.next()) {
				TypeFigureBean typeFigure = new TypeFigureBean(rs.getInt(1), rs.getString(2));
				list.add(typeFigure);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erreur technique. Veuillez contacter l'administrateur système.");
		} finally {
			co.close();
		}
		return list;
	}
}
