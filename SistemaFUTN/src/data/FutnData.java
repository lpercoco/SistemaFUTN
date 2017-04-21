package data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import futn.CopyPrice;
import utils.ApplicationException;

public class FutnData {
	
	public CopyPrice getActualCopyPrice(){
		CopyPrice cp=new CopyPrice();
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"SELECT beginDate,duplexPrice,simplePrice FROM copyPrices WHERE endDate IS NULL");
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
						
			stmt.setDate(1,(Date) cp.getBeginDate());
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
	
	public void update(CopyPrice cp){ 
		PreparedStatement stmt=null;
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(
					"update copyPrices set endDate=?"+
					" where beginDate=?");
            stmt.setDate(1,(Date) cp.getEndDate());
            stmt.setDate(2,(Date) cp.getBeginDate());

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
