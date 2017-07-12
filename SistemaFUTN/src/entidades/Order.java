package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.*;
import java.util.Date;

public class Order{

	static final int ESTIMATED_DAYS_TO_PRINT=3;


	private int orderNumber;
	private Date orderDate;
	private Date estimatedDeliveryDate;
	private Date deliveryDate;
	private Date finishDate;// date en que se imprimieron todo los MDE del encargue
	private double totalAmount;
	private boolean orderState; //true if all details are printed
	private User studentOrder;
	private ArrayList<OrderDetail> details;


	static public int getEstimatedDays(){
		return ESTIMATED_DAYS_TO_PRINT;
	}

	public Order(User student) {
		this.setStudentOrder(student);
		this.setOrderState(false);
		this.setTotalAmount(0);
		this.details = new ArrayList<OrderDetail>();
	}

	public Order() {
	}

	public boolean equals(int orderNumber) {
		return (this.orderNumber==orderNumber);
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
		this.estimatedDeliveryDate = estimatedDeliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getDetailsQuantity(){
		return this.getDetails().size();
	}

	public boolean isOrderState() {
		return orderState;
	}

	public void updateOrderState() {

		int counter=0;

		for (int i = 0; i < details.size(); i++) {
			if(details.get(i).isState()){
				counter++;
			}else{
				break;
			}
		}

		if(counter==details.size()){
			this.orderState=true;
		}
	}

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

	public User getStudentOrder() {
		return studentOrder;
	}

	public void setStudentOrder(User studentOrder) {
		this.studentOrder = studentOrder;
	}

	public ArrayList<OrderDetail> getDetails() {
		return details;
	}
	
	public void setDetail(OrderDetail od){
		int newOrderDetailNumber=this.getDetailsQuantity()+1;

		od.setOrderDetailNumber(newOrderDetailNumber);
		this.details.add(od);
		this.totalAmountUpdateAdd(od);
		this.studentOrder.creditUpdateAdd(od);
	}

	public void totalAmountUpdateAdd(OrderDetail od) {
		this.totalAmount=this.getTotalAmount()+od.getParcialAmount();
	}

	public void totalAmountUpdateCancel(OrderDetail od){
		this.totalAmount=this.getTotalAmount()-od.getParcialAmount();
	}

	public void setDetails(ArrayList<OrderDetail> details) {
		this.details = details;
	}

	public void setOrderState(boolean b) {
		this.orderState=b;
	}

	public void updateOrderDetailsNumbers() {
		int aux=1;

		ArrayList<OrderDetail> d = new ArrayList<OrderDetail>();

		for (int i = 0; i < this.getDetails().size() ; i++) {

			OrderDetail od = this.getDetails().get(i);

			od.setOrderDetailNumber(aux);

			d.add(od);

			aux++;
		}
		this.setDetails(d);
	}

	public OrderDetail getOrderDetail(int odNumber) {
		OrderDetail od=null;

		for (int i=0; i < this.details.size() ; i++) {	
			if(details.get(i).getOrderDetailNumber()==odNumber){
				od=details.get(i);
				break;
			}
		}
		return od;
	}

	public Order markAsPrinted(int orderDetailNumber) {

		for (int i=0; i < this.details.size() ; i++) {	
			if(details.get(i).getOrderDetailNumber()==orderDetailNumber){
				details.get(i).setState(true);
				break;
			}
		}		
		return this;
	}
}
