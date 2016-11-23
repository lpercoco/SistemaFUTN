package entidades;

public class TeachingMaterial {
	private int code;
	private int numberPages; 
	private String title;
	private String edition;
	private String editorial;
	private int publicationYear; //sirve?
	private String[] authors; //max 3 ??
	private String typeMaterial; //convertir tipo en clase si los estudiantes pueden subir material
	private Subject materialSubject;
	
	
	public int getNumberPages() {
		return numberPages;
	}
	public void setNumberPages(int numberPages) {
		this.numberPages = numberPages;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	public String getTypeMaterial() {
		return typeMaterial;
	}
	public void setTypeMaterial(String typeMaterial) {
		this.typeMaterial = typeMaterial;
	}
	public String[] getAuthors() {
		return authors;
	}
	public void setAuthors(String[] authors) {
		this.authors = authors;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Subject getMaterialSubject() {
		return materialSubject;
	}
	public void setMaterialSubject(Subject materialSubject) {
		this.materialSubject = materialSubject;
	}
	
}
