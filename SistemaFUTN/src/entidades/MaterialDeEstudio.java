package entidades;

public class MaterialDeEstudio {
	private int codigo;
	private int cantidadPaginas; // cantidad o numero?
	private String titulo;
	private String edicion;
	private String editorial;
	private String añoPublicacion; //sirve?
	private String[] autores;
	private tipoMaterialDeEstudio tipo; //esta bien?
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCantidadPaginas() {
		return cantidadPaginas;
	}
	public void setCantidadPaginas(int cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEdicion() {
		return edicion;
	}
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getAñoPublicacion() {
		return añoPublicacion;
	}
	public void setAñoPublicacion(String añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}
	public String[] getAutores() {
		return autores;
	}
	public void setAutores(String[] autores) {
		this.autores = autores;
	}
	public tipoMaterialDeEstudio getTipo() {
		return tipo;
	}
	public void setTipo(tipoMaterialDeEstudio tipo) {
		this.tipo = tipo;
	}

	
}
