package futn;

import java.util.Date; // o .sql?

public class AmountRinged {
	private int numberRinged;
	private Date beginDate;
	private Date endDate;
	private double ringedPrice;
	
	
	
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
	public double getRingedPrice() {
		return ringedPrice;
	}
	public void setRingedPrice(double ringedPrice) {
		this.ringedPrice = ringedPrice;
	}
	
}
