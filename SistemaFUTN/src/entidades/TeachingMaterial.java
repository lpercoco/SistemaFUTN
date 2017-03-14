package entidades;

public class TeachingMaterial {
	private int code;
	private int numberOfPages; 
	private String title;
	private String edition;
	private String author; 
	private String description; 
	private Subject materialSubject; // esta bien?
	private String publicationYear;
	
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
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
	public String getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}
	
}
