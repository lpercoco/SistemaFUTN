package data;


import java.sql.*;
import entidades.*;
import utils.ApplicationException;


public class UserData {
	
	
	public void add(Student s){
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into users(legajo,firstName,lastName,adress,phone1,phone2,mail,credit)"+
					" values(?,?,?,?,?,?,?,?)");
						
			stmt.setString(1,s.getLegajo());
			stmt.setString(2,s.getFirstName());
			stmt.setString(3,s.getLastName());
			stmt.setString(4,s.getAdress());
			stmt.setString(5,s.getPhone1());
			stmt.setString(6,s.getPhone2());
			stmt.setString(7,s.getMail());
			stmt.setDouble(8,s.getCredit());
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
	
	
	
	public void delete(Student s){
		PreparedStatement stmt=null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from users where legajo=?");
			stmt.setString(1, s.getLegajo());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
		}
	}

	
	public Student getByLegajo(Student s){
		Student stu= new Student();
		
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select legajo,firstName,lastName,adress,phone1,phone2,mail,credit from users where legajo=?");
			stmt.setString(1, s.getLegajo());
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				stu.setLegajo(rs.getString("legajo"));
				stu.setFirstName(rs.getString("firstName"));
				stu.setLastName(rs.getString("lastName"));
				stu.setAdress(rs.getString("adress"));
				stu.setPhone1(rs.getString("phone1"));
				stu.setPhone2(rs.getString("phone2"));
				stu.setMail(rs.getString("mail"));	
				stu.setCredit(rs.getDouble("credit"));
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
		return stu;
	}
	
	
	public void update(Student s){
		PreparedStatement stmt=null;
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(
					"update users set adress=?,phone1=?,phone2=?,mail=?,credit=?"+
					" where legajo=?");

			stmt.setString(1,s.getAdress());
			stmt.setString(2,s.getPhone1());
			stmt.setString(3,s.getPhone2());
			stmt.setString(4,s.getMail());
			stmt.setDouble(5,s.getCredit());
            stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
