package model;

public class Product {
	
	private String productID;
	private String name;
	private int price;
	private String description;
//	private String type;
	
	
	public String getName() {
		return name;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
//	public String getType() {
//		return type;
//	}
//	public void setType(String type) {
//		this.type = type;
//	}
	
	public Product(String productID, String name, int price, String description) {
		super();
		this.productID = productID;
		this.name = name;
		this.price = price;
		this.description = description;
//		this.type = type;
	}
}
