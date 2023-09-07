package view;

import util.Util;

public class ProductView {

	private static ProductView instance;
	private Util u = Util.getInstance();
	
	private int productID;
	private String name;
	private int price;
	private String description;
	
	
	
	private ProductView() {
		// TODO Auto-generated constructor stub
	}
	
	public static ProductView getInstance() {
		if(instance == null) {
			instance = new ProductView();
		}
		return instance;
	}
	
	public void addProduct() {
		int opt = -9;
		do {
			u.cls();
			u.printTab("Add Product");
			u.printTab("===========");
			u.printTab("1. Laptops");
			u.printTab("2. Shirts");
			u.printTab("3. Books");
			u.printTab("4. Cancel");			
			u.printTab(">> ");
			opt = u.nextInt();
			u.nextLine();
			
			switch (opt) {
			case 1:
				addLaptop();
				break;
			case 2:
				addShirt();
				break;
			case 3:
				addBook();
				break;
			}
		} while (opt != 4);
	}
	
	public void addProducts() {
		do {
			u.printTab("Input product name (product name length has to be greater than 5 and less than 25 characters and must be unique): ");
			name = u.nextLine();
			if(name.length() < 5  || name.length() > 25) {
				u.printTab("Product name length has to be greater than 5 and less than 25 characters!");
			}
		} while (name.length() < 5  || name.length() > 25);
		
		do {
			u.printTab("Input product price (product price has to be greater than 10000 and less than 120000): ");
			price = u.nextInt();
			if(price < 10000  || price > 120000) {
				u.printTab("Product price has to be greater than 10000 and less than 120000 characters!");
			}
		} while (price < 10000  || price > 120000);
		
		do {
			u.printTab("Input product description (product description length has to be greater than 10 and less than 30 characters): ");
			description = u.nextLine();
			if(description.length() < 10 || description.length() > 30) {
				u.printTab("Product description length has to be greater than 10 and less than 30 characters!");
			}
		} while (description.length() < 10 || description.length() > 30);
	}
	
	public void addLaptop() {
		float screenSize;
		int RAM;
		String processor;
		int warrantyPeriod;
		String operatingSystem;
		
		addProducts();
		
		do {
			u.printTab("Input laptop screen size (laptop screen size has to be greater than 12.5 and less than 18.5): ");
			screenSize = u.nextFloat();
			if(screenSize < 12.5  || screenSize < 18.5) {
				u.printTab("Laptop screen size has to be greater than 12.5 and less than 18.5!");
			}
		} while (screenSize < 12.5  || screenSize < 18.5);
		
	}
	
	public void addShirt() {
		
	}
	
	public void addBook() {
		
	}
}
