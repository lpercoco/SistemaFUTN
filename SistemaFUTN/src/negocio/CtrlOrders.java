package negocio;

import data.OrderData;
import entidades.Order;

public class CtrlOrders {
	private OrderData data;
	
	public CtrlOrders() {
		data=new OrderData();
	}
	
	public void addOrder(Order o) {
		data.add(o);
	}

}
