package entidades;

public class OrderDetail {
	private Subject item;
	private int numberOfCopies;
	private boolean state;// print = true not print=false
	private double parcialAmount;
	private String observation; // observation=coment
	private boolean duplex; //true-> duplex false-> simple
	private int numberRinged;
	
	
	
	public Subject getItem() {
		return item;
	}
	public void setItem(Subject item) {
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
	public void setParcialAmount(double parcialAmount) {
		this.parcialAmount = parcialAmount;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public boolean isDuplex() {
		return duplex;
	}
	public void setDuplex(boolean duplex) {
		this.duplex = duplex;
	}
	public int getNumberRinged() {
		return numberRinged;
	}
	public void setNumberRinged(int numberRinged) {
		this.numberRinged = numberRinged;
	}

}
