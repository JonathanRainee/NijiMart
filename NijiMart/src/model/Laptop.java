package model;

public class Laptop extends Electronics{

	private String operatingSystem;

	public String getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	public Laptop(String productID, String name, int price, String description, float screenSize, int RAM,
			String processor, int warrantyPeriod,  String operatingSystem) {
		super(productID, name, price, description, screenSize, RAM, processor, warrantyPeriod);
		// TODO Auto-generated constructor stub
		this.operatingSystem = operatingSystem;
	}
	
	
	
	

}
