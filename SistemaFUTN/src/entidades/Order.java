package entidades;

import java.util.ArrayList;
import java.util.Date;

public class Order{ 
	private int orderNumber;
	private Date orderDate;
	private Date estimatedDeliveryDate;
	private Date deliveryDate;
	private Date finishDate;// date en que se imprimieron todo los MDE del encargue
	private double totalAmount;
	private Student studentOrder;
	private ArrayList<OrderDetail> details;
	
	
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getEstimatedDeliveryDate() {
		return estimatedDeliveryDate;
	}
	public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
		this.estimatedDeliveryDate = estimatedDeliveryDate;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
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
	
}
