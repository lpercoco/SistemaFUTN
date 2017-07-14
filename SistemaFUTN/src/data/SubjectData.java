package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Subject;
import utils.ApplicationException;

public class SubjectData {
	
	static final String GET_SUBJECTS_QUERRY="SELECT subjectCode,subjectName,subjectLevel,subjectArea FROM subjects";
	static final String GET_SUBJECT_BY_NAME_QUERRY="SELECT subjectCode,subjectName,subjectLevel,subjectArea FROM subjects WHERE subjectName=?";
	static final String GET_SUBJECT_BY_CODE="SELECT subjectCode,subjectName,subjectArea,subjectLevel FROM subjects WHERE subjectCode=?";
	
	public ArrayList<Subject> getSubjects(){		

		ArrayList<Subject> subjects = new ArrayList<Subject>();
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(GET_SUBJECTS_QUERRY);
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
	
	public Subject getByName(String subjectName) throws ApplicationException{
		Subject s= new Subject();		
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(GET_SUBJECT_BY_NAME_QUERRY);
			stmt.setString(1,subjectName);
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				s.setArea(rs.getString("subjectArea"));
				s.setCode(rs.getInt("subjectCode"));
				s.setLevel(rs.getInt("subjectLevel"));
				s.setName(rs.getString("subjectName"));
			}else{
				throw new ApplicationException("There isn't a subject with that name");
			}
			 
		} catch (SQLException e) {
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
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(GET_SUBJECT_BY_CODE);
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
