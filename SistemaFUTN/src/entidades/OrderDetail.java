package entidades;

public class OrderDetail {
	private TeachingMaterial item;
	private int numberOfCopies;
	private boolean state;// print = true not print=false
	private double parcialAmount;
	private boolean duplex; //true-> duplex false-> simple
	
	
	
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
	public void setParcialAmount() {
		double aux=0;
		if(this.duplex){
			aux=this.numberOfCopies*this.item.getNumberOfPages();// * valor precio duplex
		}else{
			aux=this.numberOfCopies*this.item.getNumberOfPages();// * valor precio  simple
		}
		this.parcialAmount=aux;
	}
	public boolean isDuplex() {
		return duplex;
	}
	public void setDuplex(boolean duplex) {
		this.duplex = duplex;
	}
}
