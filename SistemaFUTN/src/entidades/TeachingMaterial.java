package entidades;

public class TeachingMaterial {
	private int code;
	private int numberOfPages; 
	private String title;
	private String edition;
	private String editorial;
	private String author; 
	private String description; 
	private Subject materialSubject;
	
	
	public int getNumberPages() {
		return numberOfPages;
	}
	public void setNumberPages(int numberPages) {
		this.numberOfPages = numberPages;
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
	public String getAuthors() {
		return author;
	}
	public void setAuthors(String author) {
		this.author = author;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
