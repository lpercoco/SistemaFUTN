package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import entidades.Subject;
import entidades.TeachingMaterial;
import negocio.CtrlSubjects;
import utils.ApplicationException;

public class TeachingMaterialData {
	
	static final String QUERRY_GET_TM_BY_SUBJECT_CODE="SELECT teachingMaterialCode,numberOfPages,title,edition,description,author from teachingMaterials where subjectCode=?";

	static final String QUERRY_GET_TM_BY_SUBJECT_CODE_AND_TITLE="SELECT teachingMaterialCode,numberOfPages,title,edition,description,author from teachingMaterials where subjectCode=? and title like ?";

	static final String QUERRY_GET_TM_BY_CODE="SELECT teachingMaterialCode,numberOfPages,title,edition,description,author,subjectCode from teachingMaterials where teachingMaterialCode=? ";

	static final String QUERRY_ADD_TM="INSERT INTO teachingMaterials (title,numberOfPages,edition,author,description,subjectCode)  VALUES(?,?,?,?,?,?) ";
	
	public void add(TeachingMaterial tm) {
		ResultSet rs = null;
		PreparedStatement stmt = null;

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(QUERRY_ADD_TM);

			stmt.setString(1, tm.getTitle());
			stmt.setInt(2, tm.getNumberOfPages());
			stmt.setString(3, tm.getEdition());
			stmt.setString(4, tm.getAuthor());
			stmt.setString(5, tm.getDescription());
			stmt.setInt(6, tm.getMaterialSubject().getCode());

			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (ApplicationException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<TeachingMaterial> getTeachingMaterials(TeachingMaterial tmSearch) throws ApplicationException {

		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<TeachingMaterial> tmArray = new ArrayList<TeachingMaterial>();

		SubjectData subjectData = new SubjectData();

		Subject subject = new Subject();

		//get subject of tm

		subject=subjectData.getByName(tmSearch.getMaterialSubject().getName());

		try{

			if(tmSearch.getTitle()==""){
				stmt = FactoryConexion.getInstancia().getConn().prepareStatement(QUERRY_GET_TM_BY_SUBJECT_CODE);
			}else{
				stmt = FactoryConexion.getInstancia().getConn().prepareStatement(QUERRY_GET_TM_BY_SUBJECT_CODE_AND_TITLE);
				stmt.setString(2, "%" + tmSearch.getTitle() + "%");
			}
			stmt.setInt(1, subject.getCode());

			rs = stmt.executeQuery();

			while (rs != null && rs.next()) {
				TeachingMaterial tm = new TeachingMaterial();

				tm.setCode(rs.getInt("teachingMaterialCode"));
				tm.setAuthor(rs.getString("author"));
				tm.setDescription(rs.getString("description"));
				tm.setEdition(rs.getString("edition"));
				tm.setNumberOfPages(rs.getInt("numberOfPages"));
				tm.setTitle(rs.getString("title"));

				tm.setMaterialSubject(subject);

				tmArray.add(tm);
			}

			if(tmArray.isEmpty()){
				throw new ApplicationException("No results were found for your search");
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
		}
		return tmArray;
	}




	public TeachingMaterial getTeachingMaterial(TeachingMaterial tmSearch) {

		SubjectData subjectData = new SubjectData();
		
		TeachingMaterial tm = new TeachingMaterial();
		Subject s = new Subject();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(QUERRY_GET_TM_BY_CODE);
			stmt.setInt(1, tmSearch.getCode());

			rs = stmt.executeQuery();

			while (rs != null && rs.next()) {		
				
				tm.setCode(rs.getInt("TeachingMaterialCode"));
				tm.setAuthor(rs.getString("author"));
				tm.setDescription(rs.getString("description"));
				tm.setEdition(rs.getString("edition"));
				tm.setNumberOfPages(rs.getInt("numberOfPages"));
				tm.setTitle(rs.getString("title"));
				
				s.setCode(rs.getInt("subjectCode"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
		}
		
		s=subjectData.getbyCode(s);
		
		tm.setMaterialSubject(s);
		
		return tm;
	}

}
