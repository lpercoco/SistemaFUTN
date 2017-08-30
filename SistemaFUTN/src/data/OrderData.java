package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import entidades.Order;
import entidades.OrderDetail;
import entidades.TeachingMaterial;
import entidades.User;
import utils.ApplicationException;

public class OrderData {

	private static final String GET_UNPRINTED_ORDERS_QUERRY="SELECT o.orderNumber,o.orderDate, o.deliveryDate,o.finishDate,"
			+"o.estimatedDeliveryDate,o.totalAmount,o.studentLegajo,o.orderState,o.studentLegajo "
			+"FROM orders o "
			+"WHERE finishDate IS NULL";

	private static final String RECORD_ORDERDETAIL_AS_PRINTED="UPDATE orderDetails SET state=TRUE WHERE orderNumber=? AND orderDetailNumber=?";

	private static final String RECORD_ORDER_AS_READY="UPDATE orders SET orderState=TRUE, finishDate=CURRENT_DATE WHERE orderNumber=?";

	private static final String RECORD_ORDER_AS_DELIVER="UPDATE orders SET deliveryDate=CURRENT_DATE where orderNumber=?";

	private static final String RECORD_NEW_ORDER="INSERT INTO orders (totalAmount,orderState,orderDate,estimatedDeliveryDate,studentLegajo) VALUES (?,?,CURRENT_DATE,DATE_ADD(CURRENT_DATE, INTERVAL ? DAY),?) ";

	private static final String RECORD_ORDER_DETAILS="INSERT INTO orderDetails (orderNumber,orderDetailNumber,teachingMaterialCode,numberOfCopies,state,parcialAmount,duplex) VALUES(?,?,?,?,?,?,?)";

	private static final String UNPRINTED_UNDELIVERD_ORDERS_BY_USER="SELECT o.orderNumber,o.orderDate, o.deliveryDate,o.finishDate,o.estimatedDeliveryDate,o.totalAmount,o.studentLegajo,o.orderState "
			+"FROM orders o "
			+"WHERE o.studentLegajo=? AND (o.deliveryDate IS NULL OR o.finishDate IS NULL) ";

	private static final String GET_ORDER_BY_ORDERNUMBER_QUERRY = "SELECT o.orderNumber,o.orderDate, o.deliveryDate,o.finishDate,"
			+"o.estimatedDeliveryDate,o.totalAmount,o.studentLegajo,o.orderState "
			+"FROM orders o "
			+"WHERE o.orderNumber=?";

	public void add(Order o){
		ResultSet rs=null;
		ResultSet primaryKeyOfOrder=null;
		PreparedStatement stmt=null;

		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(RECORD_NEW_ORDER,Statement.RETURN_GENERATED_KEYS);

			stmt.setDouble(1, o.getTotalAmount());
			stmt.setBoolean(2, o.isOrderState());
			stmt.setInt(3, Order.getEstimatedDays()); //fijo
			stmt.setInt(4, o.getStudentOrder().getLegajo());

			stmt.execute();


			primaryKeyOfOrder=stmt.getGeneratedKeys();
			if(primaryKeyOfOrder.next()){
				o.setOrderNumber(primaryKeyOfOrder.getInt(1));
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

		addOrderDetails(o); 

	}


	private void addOrderDetails(Order o) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		ArrayList<OrderDetail> od=o.getDetails();

		try {

			for(int i=0;i<od.size();i++){
				stmt=FactoryConexion.getInstancia().getConn().prepareStatement(RECORD_ORDER_DETAILS);

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

	public ArrayList<Order> getUndeliveredAndUnprintedOrders(User user) {

		ArrayList<Order> orders = new ArrayList<Order>();

		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(UNPRINTED_UNDELIVERD_ORDERS_BY_USER);
			stmt.setInt(1,user.getLegajo());
			rs= stmt.executeQuery();


			while(rs!=null && rs.next()){

				Order o=new Order();

				o.setOrderNumber(rs.getInt("orderNumber"));
				o.setOrderDate(rs.getDate("orderDate"));

				if(rs.getDate("deliveryDate")!=null){
					o.setDeliveryDate(rs.getDate("deliveryDate"));
				}

				if(rs.getDate("finishDate")!=null){
					o.setFinishDate(rs.getDate("finishDate"));
				}

				o.setEstimatedDeliveryDate(rs.getDate("estimatedDeliveryDate"));
				o.setTotalAmount(rs.getDouble("totalAmount"));
				o.setOrderState(rs.getBoolean("orderState"));

				orders.add(o);
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

		//sacar afuera?
		for (int i = 0; i < orders.size(); i++) {
			orders.get(i).setDetails(getDetails(orders.get(i)));
		}

		return orders;
	}

	private ArrayList<OrderDetail> getDetails(Order o) {

		TeachingMaterialData tmData=new TeachingMaterialData(); 

		ArrayList<OrderDetail> ordersDetails = new ArrayList<OrderDetail>();

		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select od.orderDetailNumber,od.teachingMaterialCode,od.numberOfCopies,od.state,od.parcialAmount,od.duplex"+			
							" from orderDetails od"+
					" where od.orderNumber= ?");
			stmt.setInt(1,o.getOrderNumber());
			rs= stmt.executeQuery();

			while(rs!=null && rs.next()){

				OrderDetail od=new OrderDetail();
				TeachingMaterial tmSearch=new TeachingMaterial();

				tmSearch.setCode(rs.getInt("teachingMaterialCode"));

				od.setItem(tmSearch);

				od.setOrderDetailNumber(rs.getInt("orderDetailNumber"));
				od.setParcialAmount(rs.getDouble("parcialAmount"));
				od.setState(rs.getBoolean("state"));
				od.setDuplex(rs.getBoolean("duplex"));
				od.setNumberOfCopies(rs.getInt("numberOfCopies"));

				ordersDetails.add(od);
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

		//MAP
		for (int i = 0; i < ordersDetails.size(); i++) {

			TeachingMaterial tm = new TeachingMaterial();

			tm=ordersDetails.get(i).getItem();

			ordersDetails.get(i).setItem(tmData.getTeachingMaterial(tm));

		}

		return ordersDetails;
	}


	public ArrayList<Order> getUnprintedOrders(){

		ArrayList<Order> orders = new ArrayList<Order>();

		UserData userData = new UserData();        

		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(GET_UNPRINTED_ORDERS_QUERRY);
			rs= stmt.executeQuery();

			while(rs!=null && rs.next()){

				Order o = new Order();
				User u = new User(rs.getInt("StudentLegajo"));

				o.setStudentOrder(u);
				o.setOrderNumber(rs.getInt("orderNumber"));
				o.setOrderDate(rs.getDate("orderDate"));
				o.setDeliveryDate(rs.getDate("deliveryDate"));
				o.setFinishDate(rs.getDate("finishDate"));
				o.setEstimatedDeliveryDate(rs.getDate("estimatedDeliveryDate"));
				o.setTotalAmount(rs.getDouble("totalAmount"));
				o.setOrderState(rs.getBoolean("orderState"));

				orders.add(o);
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

		//hacer un metodo mapear od y usuario
		for (int i = 0; i < orders.size(); i++) {
			orders.get(i).setDetails(getDetails(orders.get(i)));

			User u=orders.get(i).getStudentOrder();
			try {
				orders.get(i).setStudentOrder(userData.getByLegajo(u.getLegajo()));
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return orders;

	}

	public void saveOrderDetailAsPrinted(Order order, int orderDetailNumber) {

		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(RECORD_ORDERDETAIL_AS_PRINTED);
			stmt.setInt(1,order.getOrderNumber());
			stmt.setInt(2, orderDetailNumber);
			stmt.executeUpdate();

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
	}

	public void saveOrderAsReady(Order order) {

		PreparedStatement stmt=null;
		ResultSet rs=null;

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(RECORD_ORDER_AS_READY);
			stmt.setInt(1,order.getOrderNumber());
			stmt.executeUpdate();

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
	}

	public void saveOrderAsDelivered(Order orderToDeliver) {
		PreparedStatement stmt=null;
		ResultSet rs=null;

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(RECORD_ORDER_AS_DELIVER);
			stmt.setInt(1,orderToDeliver.getOrderNumber());
			stmt.executeUpdate();

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
	}


	public Order getOrder(int orderNumber) {


		Order order = new Order();

		UserData userData = new UserData();        

		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(GET_ORDER_BY_ORDERNUMBER_QUERRY);
			stmt.setInt(1,orderNumber);

			rs= stmt.executeQuery();

			while(rs!=null && rs.next()){

				User u = new User(rs.getInt("StudentLegajo"));

				order.setStudentOrder(u);
				order.setOrderNumber(rs.getInt("orderNumber"));
				order.setOrderDate(rs.getDate("orderDate"));
				order.setDeliveryDate(rs.getDate("deliveryDate"));
				order.setFinishDate(rs.getDate("finishDate"));
				order.setEstimatedDeliveryDate(rs.getDate("estimatedDeliveryDate"));
				order.setTotalAmount(rs.getDouble("totalAmount"));
				order.setOrderState(rs.getBoolean("orderState"));

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

		order.setDetails(getDetails(order));

		int legajo=order.getStudentOrder().getLegajo();
		
		try {
			order.setStudentOrder(userData.getByLegajo(legajo));
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		
		return order;

	}
}
