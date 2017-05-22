package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import entidades.Order;
import entidades.OrderDetail;
import utils.ApplicationException;

public class OrderData {
	

	public void add(Order o){
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into orders (totalAmount,orderState,orderDate,estimatedDeliveryDate,studentLegajo)"+
					" values(?,?,CURRENT_DATE,DATE_ADD(CURRENT_DATE, INTERVAL ? DAY),?)",Statement.RETURN_GENERATED_KEYS);
									
			stmt.setDouble(1, o.getTotalAmount());
			stmt.setBoolean(2, o.isOrderState());
			stmt.setInt(3, 3); //  fijo o calculable?
			stmt.setString(4, o.getStudentOrder().getLegajo());

			stmt.execute();
			
			//donde ubicarlo? considerar excepcion
			ResultSet gk=stmt.getGeneratedKeys();
			
			if(gk.next()){
			o.setOrderNumber(gk.getInt(1));
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
				addOrderDetails(o); //esta bien ubicado?  hacer loop aca?
			} catch (ApplicationException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
	}

	private void addOrderDetails(Order o) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		ArrayList<OrderDetail> od=o.getDetails();
		
		try {

			for(int i=0;i<o.getDetails().size();i++){
				stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"insert into orderDetails (orderNumber,orderDetailNumber,teachingMaterialCode,numberOfCopies,state,parcialAmount,duplex)"+
						" values(?,?,?,?,?,?,?)");
							
				stmt.setInt(1,o.getOrderNumber());
				stmt.setInt(2, od.get(i).getOrderDetailNumber());
				stmt.setInt(3, od.get(i).getItem().getCode());
				stmt.setInt(4, od.get(i).getNumberOfCopies());
				stmt.setBoolean(5, od.get(i).isState());
				stmt.setDouble(6,od.get(i).getParcialAmount());
				stmt.setBoolean(7, od.get(i).isDuplex());
				stmt.execute();	
			};
			
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

}
