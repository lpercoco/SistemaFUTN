package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.TeachingMaterial;
import utils.ApplicationException;

public class TeachingMaterialData {
	
	public void add(TeachingMaterial tm){
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into teachingMaterials (title,numberOfPages,editorial,edition,author,publicationYear,description,subjectCode)"+
					" values(?,?,?,?,?,?,?,?)");
						
			stmt.setString(1,tm.getTitle());
			stmt.setInt(2,tm.getNumberOfPages());
			stmt.setString(3,tm.getEditorial());
			stmt.setString(4,tm.getEdition());
			stmt.setString(5,tm.getAuthor());
			stmt.setString(6,tm.getPublicationYear());
			stmt.setString(7,tm.getDescription());
			stmt.setInt(8,tm.getMaterialSubject().getCode());

			stmt.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (ApplicationException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<TeachingMaterial> getTeachingMaterials(){
		
		
		return null;	
	}
	
}
