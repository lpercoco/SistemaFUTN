package futn;

import java.sql.Date;

import data.FutnData;

public class CopyPrice{
	private double duplexPrice;
	private double simplePrice;
	private Date beginDate;//eliminar 
	private Date endDate;//eliminar 

	public CopyPrice(){
	}

	public double getDuplexPrice() {
		return duplexPrice;
	}
	public void setDuplexPrice(double duplexPrice) {
		this.duplexPrice = duplexPrice;
	}
	public double getSimplePrice() {
		return simplePrice;
	}
	public void setSimplePrice(double simplePrice) {
		this.simplePrice = simplePrice;
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
	
}
