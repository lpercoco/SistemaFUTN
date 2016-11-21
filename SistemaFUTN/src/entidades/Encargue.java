package entidades;

import java.util.ArrayList;
import java.util.Date;

public class Encargue { //nombre correcto?
	private int numero;
	private Date fechaEncargue;
	private Date fechaEstimadaEntrega;
	private Date fechaEntrega;
	private Date fechaDisponible;// fecha en que se imprimieron todo los MDE del encargue
	private double montoTotal;
	private Estudiante estudianteSolicitante; //cambiar nombre?
	private ArrayList<DetalleEncargue> detalles;
	
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getFechaEncargue() {
		return fechaEncargue;
	}
	public void setFechaEncargue(Date fechaEncargue) {
		this.fechaEncargue = fechaEncargue;
	}
	public Date getFechaEstimadaEntrega() {
		return fechaEstimadaEntrega;
	}
	public void setFechaEstimadaEntrega(Date fechaEstimadaEntrega) {
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public Date getFechaDisponible() {
		return fechaDisponible;
	}
	public void setFechaDisponible(Date fechaDisponible) {
		this.fechaDisponible = fechaDisponible;
	}
	public double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}
	public Estudiante getEstudianteSolicitante() {
		return estudianteSolicitante;
	}
	public void setEstudianteSolicitante(Estudiante estudianteSolicitante) {
		this.estudianteSolicitante = estudianteSolicitante;
	}
	public ArrayList<DetalleEncargue> getDetalles() {
		return detalles;
	}
	public void setDetalles(ArrayList<DetalleEncargue> detalles) {
		this.detalles = detalles;
	}
}
