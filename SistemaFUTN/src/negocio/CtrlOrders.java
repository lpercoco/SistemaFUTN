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

	public void newOrder(ArrayList<OrderDetail> orderDetails, User student) throws ApplicationException{       
		Order order=new Order();
		
		if(student!=null && student.isScholar()==false){
			//user  is validate and is a student
			
			if(orderDetails!=null){
				//array have orderdetails
			
				order.setDetails(orderDetails);
				order.setTotalAmount();
				order.setOrderState(false);
				order.setStudentOrder(student);
				
			}else{
				throw new ApplicationException("New order without teaching materials added");
			}
		}else{
			throw new ApplicationException("Student is not logged in");
		}
		
		this.addOrder(order);
	}

}
