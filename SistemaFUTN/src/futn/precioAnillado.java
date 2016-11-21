package futn;

import java.util.Date; // o .sql?

public class precioAnillado {
	private int nroAnillado;
	private Date fechaDesde;
	private Date fechaHasta;
	private double monto;
	
	
	
	public int getNroAnillado() {
		return nroAnillado;
	}
	public void setNroAnillado(int nroAnillado) {
		this.nroAnillado = nroAnillado;
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
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
}
