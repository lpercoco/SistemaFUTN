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

	public void add(TeachingMaterial tm) {
		ResultSet rs = null;
		PreparedStatement stmt = null;

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into teachingMaterials (title,numberOfPages,edition,author,publicationYear,description,subjectCode)"
							+ " values(?,?,?,?,?,?,?,?)");

			stmt.setString(1, tm.getTitle());
			stmt.setInt(2, tm.getNumberOfPages());
			stmt.setString(4, tm.getEdition());
			stmt.setString(5, tm.getAuthor());
			stmt.setString(6, tm.getPublicationYear());
			stmt.setString(7, tm.getDescription());
			stmt.setInt(8, tm.getMaterialSubject().getCode());

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

	public ArrayList<TeachingMaterial> getTeachingMaterials(TeachingMaterial tmSearch) {

		ArrayList<TeachingMaterial> tmArray = new ArrayList();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String querry = "select tm.teachingMaterialCode,tm.numberOfPages,tm.title,tm.edition,tm.subjectCode,tm.publicationYear,tm.description,tm.author,s.subjectName,s.subjectArea,s.subjectLevel"
					+ " from teachingMaterials tm" + " inner join subjects s on s.subjectCode=tm.subjectCode";

			if (tmSearch.getTitle().equals("")) {
				stmt = FactoryConexion.getInstancia().getConn().prepareStatement(querry + " where tm.subjectCode=?");
				stmt.setInt(1, tmSearch.getMaterialSubject().getCode());
			} else {
				stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
						querry + " where (tm.title like ?) or (tm.title like ? and tm.subjectCode=?)");
				stmt.setString(1, "%" + tmSearch.getTitle() + "%");
				stmt.setString(2, "%" + tmSearch.getTitle() + "%");
				stmt.setInt(3, tmSearch.getMaterialSubject().getCode());
			}
			// Es correcto del lado de diseño?

			rs = stmt.executeQuery();

			while (rs != null && rs.next()) {
				TeachingMaterial tm = new TeachingMaterial();
				Subject s = new Subject();

				tm.setCode(rs.getInt("tm.teachingMaterialCode"));
				tm.setAuthor(rs.getString("tm.author"));
				tm.setDescription(rs.getString("tm.description"));
				tm.setEdition(rs.getString("tm.edition"));
				tm.setNumberOfPages(rs.getInt("tm.numberOfPages"));
				tm.setPublicationYear(rs.getString("tm.publicationYear"));
				tm.setTitle(rs.getString("tm.title"));

				s.setCode(rs.getInt("tm.subjectCode"));
				s.setArea(rs.getString("s.subjectArea"));
				s.setLevel(rs.getInt("s.subjectLevel"));
				s.setName(rs.getString("s.subjectName"));

				tm.setMaterialSubject(s);

				tmArray.add(tm);
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
		return tmArray;
	}

	public TeachingMaterial getTeachingMaterial(TeachingMaterial tmSearch) {

		CtrlSubjects ctrlsubject = new CtrlSubjects();

		Subject s = new Subject();
		TeachingMaterial tm = new TeachingMaterial();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select tm.TeachingMaterialCode,tm.numberOfPages,tm.title,tm.edition,tm.subjectCode,s.subjectName,s.subjectLevel,s.subjectArea,tm.publicationYear,tm.description,tm.author"
							+ " from teachingMaterials tm" + " inner join subjects s on s.subjectCode=tm.subjectCode"
							+ " where TeachingMaterialCode=?");
			stmt.setInt(1, tmSearch.getCode());

			rs = stmt.executeQuery();

			while (rs != null && rs.next()) {
				tm.setCode(rs.getInt("TeachingMaterialCode"));
				tm.setAuthor(rs.getString("author"));
				tm.setDescription(rs.getString("description"));
				tm.setEdition(rs.getString("edition"));
				tm.setNumberOfPages(rs.getInt("numberOfPages"));
				tm.setPublicationYear(rs.getString("publicationYear"));
				tm.setTitle(rs.getString("title"));

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
		return tm;
	}

}
