package futn;

import java.util.Date; // o .sql?

public class amountRinged {
	private int numberRinged;
	private Date beginDate;
	private Date endDate;
	private double price;
	
	
	
	public int getNumberRinged() {
		return numberRinged;
	}
	public void setNumberRinged(int numberRinged) {
		this.numberRinged = numberRinged;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
