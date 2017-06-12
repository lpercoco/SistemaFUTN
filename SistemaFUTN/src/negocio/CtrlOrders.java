package negocio;

import java.util.ArrayList;

import data.OrderData;
import entidades.Order;
import entidades.OrderDetail;
import entidades.User;
import utils.ApplicationException;

public class CtrlOrders {
	private OrderData data;
	
	public CtrlOrders() {
		data=new OrderData();
	}
	
	public void addOrder(Order o) {
		data.add(o);
	}

	public Order cancelItem(Order order, OrderDetail od) {

		for (int i = 0; i < order.getDetails().size(); i++) {
			if(order.getDetails().get(i).equals(od)){
				order.totalAmountUpdateCancel(order.getDetails().get(i));
				order.getStudentOrder().creditUpdateCancel(od);
				order.getDetails().remove(i);
			}
			order.updateOrderDetailsNumbers();
		}
		return order;
	}

	
	public Order setOrderDetail(Order order, OrderDetail od) throws ApplicationException {

		double aux=order.getTotalAmount() + od.getParcialAmount();
		
		if(order.getStudentOrder().getCredit()>=aux){
			order.setDetail(od);
			return order;
		}else{
			throw new ApplicationException("Insufficient credit for add items from this search");
		}		
	}

	public OrderDetail getOrderDetail(Order o, int odNumber) {

		ArrayList<OrderDetail> details = o.getDetails();
		OrderDetail od=null;
		
		for (int i=0; i < details.size() ; i++) {	
			if(details.get(i).getOrderDetailNumber()==odNumber){
			  od=details.get(i);
			  break;
			}
		}
		return od;
	}
		
}
