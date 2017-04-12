package negocio;

import java.util.ArrayList;

import data.OrderData;
import entidades.Order;
import entidades.OrderDetail;

public class CtrlOrders {
	private OrderData data;
	
	public CtrlOrders() {
		data=new OrderData();
	}
	
	public void addOrder(Order o) {
		data.add(o);
	}

	public void newOrder(ArrayList<OrderDetail> orderDetails){       
		Order order=new Order();
		
		//considerar excepcion si orderDetails es vacio
		order.setDetails(orderDetails);
		order.setTotalAmount();
		order.setOrderState(false);
		//order.setStudent(); no esta implementado				

		//se setean el resto de los campos en la bd
		this.addOrder(order);
	}

}
