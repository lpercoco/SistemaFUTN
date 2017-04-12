package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.*;
import java.util.Date;

public class Order{ 
	private int orderNumber;
	private Date orderDate;
	private Date estimatedDeliveryDate;
	private Date deliveryDate;
	private Date finishDate;// date en que se imprimieron todo los MDE del encargue
	private double totalAmount;
	private boolean orderState;
	private ArrayList<OrderDetail> details;
	
	
	public boolean isOrderState() {
		return orderState;
	}
	
	//cambiar nombre por actualizar?
	public void setOrderState() {
		for (int i = 0; i < details.size(); i++) {
			if(!details.get(i).isState()){
				this.orderState=false;
				break;
			}
		}
		
	}

	private Student studentOrder;
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	
	public Date getEstimatedDeliveryDate() {
		return estimatedDeliveryDate;
	}
	
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}
	
	public void setFinishDate() {
		this.finishDate=Calendar.getInstance().getTime();

	}
	
	public double getTotalAmount() {
		return totalAmount;
	}
	
	public void setTotalAmount() {
		double aux=0;
		for (int i = 0; i<this.details.size(); i++) {
			aux=aux+this.details.get(i).getParcialAmount();
		}
		this.totalAmount=aux;
	}
	
	public Student getStudentOrder() {
		return studentOrder;
	}
	
	public void setStudentOrder(Student studentOrder) {
		this.studentOrder = studentOrder;
	}
	
	public ArrayList<OrderDetail> getDetails() {
		return details;
	}
	
	public void setDetails(ArrayList<OrderDetail> details) {
		this.details = details;
	}

	public void setOrderState(boolean b) {
		this.orderState=b;
	}
	
}
