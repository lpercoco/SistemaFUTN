package data;


import java.sql.*;

import entidades.*;
import utils.ApplicationException;


public class UserData {

	static final String ADD_STUDENT_QUERRY="INSERT INTO users (legajo,firstName,lastName,adress,phone1,phone2,mail,credit,password,scholar) VALUES (?,?,?,?,?,?,?,?,?,0)";
    static final String GET_STUDENT_BY_LEGAJO_QUERRY="SELECT legajo,firstName,lastName,adress,phone1,phone2,mail,credit,scholar,password FROM users WHERE legajo=?";
	static final String UPDATE_STUDENT_QUERRY="UPDATE users SET adress=?,phone1=?,phone2=?,mail=? ,credit=?, password=? WHERE legajo=?";
    
	static final int REPEATED_PK_ERROR_CODE=1062;

	public void add(User u)throws ApplicationException{
		ResultSet rs=null;
		PreparedStatement stmt=null;

		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(ADD_STUDENT_QUERRY);

			stmt.setInt(1,u.getLegajo());
			stmt.setString(2,u.getFirstName());
			stmt.setString(3,u.getLastName());
			stmt.setString(4,u.getAdress());
			stmt.setString(5,u.getPhone1());
			stmt.setString(6,u.getPhone2());
			stmt.setString(7,u.getMail());
			stmt.setDouble(8,u.getCredit());
			stmt.setString(9, u.getPassword());
			stmt.execute();

		} catch (SQLException e) {
			if(e.getErrorCode() == 1062 ){
					throw new ApplicationException("There is already a user with that Legajo");
			}
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

	public User getByLegajo(int legajo) throws ApplicationException{
		User user= new User();

		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(GET_STUDENT_BY_LEGAJO_QUERRY);
			stmt.setInt(1, legajo);
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				user.setLegajo(rs.getInt("legajo"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setAdress(rs.getString("adress"));
				user.setPhone1(rs.getString("phone1"));
				user.setPhone2(rs.getString("phone2"));
				user.setMail(rs.getString("mail"));	
				user.setCredit(rs.getDouble("credit"));
				user.setScholar(rs.getBoolean("scholar"));
				user.setPassword(rs.getString("password")); 
			}else{
				throw new ApplicationException("There isnt a user with that Legajo");
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
			}catch (ApplicationException e2) {
				e2.printStackTrace();
			}
		}
		return user;
	}


	public void update(User u) { 
		PreparedStatement stmt=null;	
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(UPDATE_STUDENT_QUERRY);

			stmt.setString(1,u.getAdress());
			stmt.setString(2,u.getPhone1());
			stmt.setString(3,u.getPhone2());
			stmt.setString(4,u.getMail());
			stmt.setDouble(5,u.getCredit());
			stmt.setString(6,u.getPassword());
			stmt.setInt(7,u.getLegajo());
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
