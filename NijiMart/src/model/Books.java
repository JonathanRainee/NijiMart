package model;

public class Books extends Product{

	private String author;
	private String genre;
	private int publicationYear;
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	
	public Books(int productID, String name, int price, String description, String author, String genre,
			int publicationYear) {
		super(productID, name, price, description);
		this.author = author;
		this.genre = genre;
		this.publicationYear = publicationYear;
	}
}
