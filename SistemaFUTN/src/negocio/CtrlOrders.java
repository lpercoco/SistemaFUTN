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
		return o.getOrderDetail(odNumber);
	}

	public ArrayList<Order> getOrders(User user) {
		return data.getOrders(user);
	}

	public Order getOrder(ArrayList<Order> orders, int orderNumber) {
		Order o = null;

		for (int i = 0; i < orders.size(); i++) {
			if(orders.get(i).equals(orderNumber)){
				o=orders.get(i);
				break;
			}
		}
		return o;
	}

	public ArrayList<Order> getUnreadyAndUndeliveryOrders() {	
		return data.getUnreadyAndUndeliveyOrders();
	}

	public Order recordOrderDetailAsPrinted(Order order, int orderDetailNumber) {

		order = order.markAsPrinted(orderDetailNumber);

		order.updateOrderState();

		data.saveOrderDetailAsPrinted(order,orderDetailNumber);

		if(order.isOrderState()){
			data.saveOrderAsReady(order);
		}
		return order;
	}

	public int getNumberOfOrdersToPrint(ArrayList<Order> orders) {

		int aux=0;

		for (int i = 0; i < orders.size(); i++) {

			if(!orders.get(i).isOrderState()){
				aux++;
			}

		}	
		return aux;
	}

	public ArrayList<Order> getOrdersToDeliver(User student) throws ApplicationException {

		ArrayList<Order> orders= data.getOrders(student);

		ArrayList<Order> ordersToDelete = new ArrayList<Order>();

		for (Order order : orders) {

			if((!order.isOrderState()) || (order.getDeliveryDate()!=null) ){
				ordersToDelete.add(order);
			}
		}

		orders.removeAll(ordersToDelete);


		if(orders.size()==0){
			throw new ApplicationException("The student have any order ready");
		}

		return orders;
	}

	public ArrayList<Order> deliverOrder(ArrayList<Order> ordersToDeliver, int orderNumberToDeliver) {

		Order orderToDeliver= getOrder(ordersToDeliver, orderNumberToDeliver);
		
		data.saveOrderAsDelivered(orderToDeliver);
		
		ordersToDeliver.remove(orderToDeliver);
		
		return ordersToDeliver;
		
	}

}
