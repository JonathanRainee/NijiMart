package model;

public class Shirt extends Clothing{

	private String sleeveLength;
	private String collarType;
	private String fabricPattern;
	
	public String getSleeveLength() {
		return sleeveLength;
	}
	public void setSleeveLength(String sleeveLength) {
		this.sleeveLength = sleeveLength;
	}
	public String getCollarType() {
		return collarType;
	}
	public void setCollarType(String collarType) {
		this.collarType = collarType;
	}
	public String getFabricPattern() {
		return fabricPattern;
	}
	public void setFabricPattern(String fabricPattern) {
		this.fabricPattern = fabricPattern;
	}
	
	public Shirt(String productID, String name, int price, String description, String size, String color,
			String material, String sleeveLength, String collarType, String fabricPattern) {
		super(productID, name, price, description, size, color, material);
		this.sleeveLength = sleeveLength;
		this.collarType = collarType;
		this.fabricPattern = fabricPattern;
	}
}
