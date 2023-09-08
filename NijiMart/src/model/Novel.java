package model;

public class Novel extends Books{

	private String crimeType;
	private String detective;
	private int suspenseLevel;
	
	public String getCrimeType() {
		return crimeType;
	}
	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	}
	public String getDetective() {
		return detective;
	}
	public void setDetective(String detective) {
		this.detective = detective;
	}
	public int getSuspenseLevel() {
		return suspenseLevel;
	}
	public void setSuspenseLevel(int suspenseLevel) {
		this.suspenseLevel = suspenseLevel;
	}
	
	public Novel(String productID, String name, int price, String description, String author, String genre,
			int publicationYear, String crimeType, String detective, int suspenseLevel) {
		super(productID, name, price, description, author, genre, publicationYear);
		this.crimeType = crimeType;
		this.detective = detective;
		this.suspenseLevel = suspenseLevel;
	}
}
