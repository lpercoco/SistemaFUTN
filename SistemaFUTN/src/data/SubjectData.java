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
					"select subjectCode,subjectName,subjectLevel,subjectArea from subjects");
			rs= stmt.executeQuery();
			while(rs!=null && rs.next()){
				Subject s=new Subject();
				s.setCode(rs.getInt("subjectCode"));
				s.setName(rs.getString("subjectName"));
				s.setLevel(rs.getInt("subjectLevel"));
				s.setArea(rs.getString("subjectArea"));
				
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
					"select subjectCode,subjectName,subjectArea,subjectLevel from subjects where subjectName=?");
			stmt.setString(1, ms.getName());
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				s.setArea(rs.getString("subjectArea"));
				s.setCode(rs.getInt("subjectCode"));
				s.setLevel(rs.getInt("subjectLevel"));
				s.setName(rs.getString("subjectName"));
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

	public Subject getbyCode(Subject ms) {
		Subject s= new Subject();		
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select subjectCode,subjectName,subjectArea,subjectLevel from subjects where subjectCode=?");
			stmt.setInt(1, ms.getCode());
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				s.setArea(rs.getString("subjectArea"));
				s.setCode(rs.getInt("subjectCode"));
				s.setLevel(rs.getInt("subjectLevel"));
				s.setName(rs.getString("subjectName"));
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
