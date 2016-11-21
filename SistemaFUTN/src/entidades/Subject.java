package entidades;

public class Asignatura {
	private int codigo;
	private String  nombre;
	private int añoCursado;
	private int añoPlan;
	private int codigoArea; //Ver
	
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAñoCursado() {
		return añoCursado;
	}
	public void setAñoCursado(int añoCursado) {
		this.añoCursado = añoCursado;
	}
	public int getAñoPlan() {
		return añoPlan;
	}
	public void setAñoPlan(int añoPlan) {
		this.añoPlan = añoPlan;
	}
	public int getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(int codigoArea) {
		this.codigoArea = codigoArea;
	}
}
