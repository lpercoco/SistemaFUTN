package entidades;

public class DetalleEncargue {
	private MaterialDeEstudio item;
	private int cantidadCopias;
	private boolean estado;//impreso o no impreso 
	private double montoParcial;
	private String observacion;
	private boolean dobleFaz; //true-> dobleFaz false-> simpleFaz
	private int nroAnillado;
	
	
	
	public MaterialDeEstudio getItem() {
		return item;
	}
	public void setItem(MaterialDeEstudio item) {
		this.item = item;
	}
	public int getCantidadCopias() {
		return cantidadCopias;
	}
	public void setCantidadCopias(int cantidadCopias) {
		this.cantidadCopias = cantidadCopias;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public double getMontoParcial() {
		return montoParcial;
	}
	public void setMontoParcial(double montoParcial) {
		this.montoParcial = montoParcial;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public boolean isDobleFaz() {
		return dobleFaz;
	}
	public void setDobleFaz(boolean dobleFaz) {
		this.dobleFaz = dobleFaz;
	}
	public int getNroAnillado() {
		return nroAnillado;
	}
	public void setNroAnillado(int nroAnillado) {
		this.nroAnillado = nroAnillado;
	}
}
