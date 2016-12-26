package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Student;
import entidades.Subject;
import utils.ApplicationException;

public class SubjectData {
	
	public ArrayList<Subject> getSubjects(){		

		ArrayList<Subject> subjects = new ArrayList<Subject>();
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select code,name,level,area from subjects");
			rs= stmt.executeQuery();
			while(rs!=null && rs.next()){
				Subject s=new Subject();
				s.setCode(rs.getInt("code"));
				s.setName(rs.getString("name"));
				s.setLevel(rs.getInt("level"));
				s.setArea(rs.getString("area"));
				
				subjects.add(s);
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
		}
		return subjects;
	}
	
	public Subject getByName(Subject ms){
		Subject s= new Subject();		
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select code,name,area,level from subjects where name=?");
			stmt.setString(1, ms.getName());
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				s.setArea(rs.getString("area"));
				s.setCode(rs.getInt("code"));
				s.setLevel(rs.getInt("level"));
				s.setName(rs.getString("name"));
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
		}
		return s;
	}

}
