package data;


import java.sql.*;

import futn.CopyPrice;
import utils.ApplicationException;

public class FutnData {
	
	public CopyPrice getCurrentCopyPrice(){
		CopyPrice cp=new CopyPrice();
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"SELECT beginDate, duplexPrice, simplePrice "
					+"FROM copyPrices "
					+"WHERE beginDate = (select MAX(beginDate) from copyPrices)");
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				cp.setSimplePrice(rs.getDouble("simplePrice"));
				cp.setDuplexPrice(rs.getDouble("duplexPrice"));
				cp.setBeginDate(rs.getDate("beginDate")); 
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
		return cp;
	}
	


	public void add(CopyPrice cp){
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into copyPrices (beginDate,simplePrice,duplexPrice)"+
					" values(?,?,?)");
			stmt.setDate(1, (java.sql.Date) cp.getBeginDate());
			stmt.setDouble(2,cp.getSimplePrice());
			stmt.setDouble(3,cp.getDuplexPrice());

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

	public Date getCurrentDate(){
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		Date date = null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"SELECT CURRENT_DATE currentDate");
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				date=rs.getDate("currentDate");
			}
			
			
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
	return date;
	}
}
