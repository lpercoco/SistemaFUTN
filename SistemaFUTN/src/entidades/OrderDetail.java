package entidades;

import futn.CopyPrice;

public class OrderDetail {
	private TeachingMaterial item;
	private int orderDetailNumber;
	private int numberOfCopies;
	private boolean state;// print = true not print=false
	private double parcialAmount;
	private boolean duplex; //true-> duplex false-> simple
	
	
	
	public OrderDetail(TeachingMaterial tm, int quantity, boolean duplex2, CopyPrice copyPrice, int odNumber) {
		this.setItem(tm);
		this.setNumberOfCopies(quantity);
		this.setDuplex(duplex2);
		this.setState(false);
		this.setParcialAmount(copyPrice);
		this.setOrderDetailNumber(odNumber);
	}
	
	
	public TeachingMaterial getItem() {
		return item;
	}
	public void setItem(TeachingMaterial item) {
		this.item = item;
	}
	public int getNumberOfCopies() {
		return numberOfCopies;
	}
	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public double getParcialAmount() {
		return parcialAmount;
	}
	public void setParcialAmount(CopyPrice copyPrice) {
		double aux=0;
				
		if(this.duplex){
			aux=this.numberOfCopies*this.item.getNumberOfPages()*copyPrice.getDuplexPrice(); 
		}else{
			aux=this.numberOfCopies*this.item.getNumberOfPages()*copyPrice.getSimplePrice(); 
		}
		this.parcialAmount=aux;
	}
	public boolean isDuplex() {
		return duplex;
	}
	public void setDuplex(boolean duplex) {
		this.duplex = duplex;
	}


	public int getOrderDetailNumber() {
		return orderDetailNumber;
	}


	public void setOrderDetailNumber(int orderDetailNumber) {
		this.orderDetailNumber = orderDetailNumber;
	}
}
