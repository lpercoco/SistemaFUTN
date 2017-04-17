package data;


import java.sql.*;
import entidades.*;
import utils.ApplicationException;


public class UserData {
	
	//ver que onda con el password
	
	
	public void add(User u){
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into users (legajo,firstName,lastName,adress,phone1,phone2,mail,credit,password,scholar)"+
					" values(?,?,?,?,?,?,?,?,?,0)");
						
			stmt.setString(1,u.getLegajo());
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
	
	
	
	public void delete(User u){
		PreparedStatement stmt=null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from users where legajo=?");
			stmt.setString(1, u.getLegajo());
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

	
	public User getByLegajo(User u){
		User user= new User();
		
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select legajo,firstName,lastName,adress,phone1,phone2,mail,credit,scholar,password from users where legajo=?");
			stmt.setString(1, u.getLegajo());
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				user.setLegajo(rs.getString("legajo"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setAdress(rs.getString("adress"));
				user.setPhone1(rs.getString("phone1"));
				user.setPhone2(rs.getString("phone2"));
				user.setMail(rs.getString("mail"));	
				user.setCredit(rs.getDouble("credit"));
				user.setScholar(rs.getBoolean("scholar"));
				user.setPassword(rs.getString("password")); //es necesario?
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
		return user;
	}
	
	
	//hacer un metodo para agregar credito aparte?
	public void update(User u){ 
		PreparedStatement stmt=null;
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(
					"update users set adress=?,phone1=?,phone2=?,mail=?,credit=,password=?"+
					" where legajo=?");
			stmt.setString(1,u.getAdress());
			stmt.setString(2,u.getPhone1());
			stmt.setString(3,u.getPhone2());
			stmt.setString(4,u.getMail());
			stmt.setDouble(5,u.getCredit());
			stmt.setString(6,u.getLegajo());
			stmt.setString(7,u.getPassword());
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
