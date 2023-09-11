package model;

public class Clothing extends Product{

	private String size;
	private String color;
	private String material;
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public Clothing(String productID, String name, int price, String description, String size, String color,
			String material) {
		super(productID, name, price, description);
		this.size = size;
		this.color = color;
		this.material = material;
	}
	
	public Clothing(String productID, String name, int price, String description, int quantity, String size, String color,
			String material) {
		super(productID, name, price, description, quantity);
		this.size = size;
		this.color = color;
		this.material = material;
	}
	
	
	

}
