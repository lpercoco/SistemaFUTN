package futn;

import java.util.Date; // o .sql?

public class PrecioCopia{
	private double montoSimpleFaz;
	private double montoDobleFaz;
	private Date fechaDesde;
	private Date fechaHasta;
	
	
	
	public double getMontoSimpleFaz() {
		return montoSimpleFaz;
	}
	public void setMontoSimpleFaz(double montoSimpleFaz) {
		this.montoSimpleFaz = montoSimpleFaz;
	}
	public double getMontoDobleFaz() {
		return montoDobleFaz;
	}
	public void setMontoDobleFaz(double montoDobleFaz) {
		this.montoDobleFaz = montoDobleFaz;
	}
	public Date getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public Date getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
}
