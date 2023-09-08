package model;

public class Electronics extends Product{

	private float screenSize;
	private int RAM;
	private String processor;
	private int warrantyPeriod;
	
	public float getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(float screenSize) {
		this.screenSize = screenSize;
	}
	public int getRAM() {
		return RAM;
	}
	public void setRAM(int rAM) {
		RAM = rAM;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}
	public void setWarrantyPeriod(int warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}
	public Electronics(String productID, String name, int price, String description, float screenSize,
			int RAM, String processor, int warrantyPeriod) {
		super(productID, name, price, description);
		this.screenSize = screenSize;
		this.RAM = RAM;
		this.processor = processor;
		this.warrantyPeriod = warrantyPeriod;
	}
	
	
	
	
}
