package view;

import controller.ProductController;
import util.Util;

public class ProductView {

	private static ProductView instance;
	private Util u = Util.getInstance();
	private ProductController pc = ProductController.getInstance();
	
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
			u.printNormal(">> ");
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
	
	public void productAdded() {
		u.printTab("Product added sucessfully!");
		u.printTab("Press enter to continue...");
		u.nextLine();
	}
	
	public void addProducts() {
		u.cls();
		do {
			u.printNormal("Input product name (product name length has to be greater than 5 and less than 25 characters and must be unique): ");
			name = u.nextLine();
			if(!u.gtAndlt(5, 25, name.length())) {
				u.printTab("Product name length has to be greater than 5 and less than 25 characters!");
			}
		} while (!u.gtAndlt(5, 25, name.length()));
		
		do {
			u.printNormal("Input product price (product price has to be greater than 10000 and less than 120000): ");
			price = u.nextInt();
			u.nextLine();
			if(!u.gtAndlt(10000, 120000, price)) {
				u.printTab("Product price has to be greater than 10000 and less than 120000!");
			}
		} while (!u.gtAndlt(10000, 120000, price));
		
		do {
			u.printNormal("Input product description (product description length has to be greater than 10 and less than 30 characters): ");
			description = u.nextLine();
			if(!u.gtAndlt(10, 25, description.length())) {
				u.printTab("Product description length has to be greater than 10 and less than 30 characters!");
			}
		} while (!u.gtAndlt(5, 25, description.length()));
	}
	
	public void addLaptop() {
		float screenSize;
		int RAM;
		String processor;
		int warrantyPeriod;
		String operatingSystem;
		
		addProducts();
		
		do {
			u.printNormal("Input laptop screen size (laptop screen size has to be greater than 12.5 and less than 18.5): ");
			screenSize = u.nextFloat();
			if(!u.gtAndlt(12.5f, 18.5f, screenSize)) {
				u.printTab("Laptop screen size has to be greater than 12.5 and less than 18.5!");
			}
		} while (!u.gtAndlt(12.5f, 18.5f, screenSize));
		
		do {
			u.printNormal("Input laptop RAM (laptop RAM has to be greater than or equal to 4 and less than or equal to 64): ");
			RAM = u.nextInt();
			u.nextLine();
			if(!u.gtAndlt(4, 64, RAM)) {
				u.printTab("Laptop RAM has to be greater than or equal to 4 and less than or equal to 64!");
			}
		} while (!u.gtAndlt(4, 64, RAM));
		
		do {
			u.printNormal("Input laptop processor (laptop processor has to be either \"ontel\" or \"SLC\" (case sensitive)): ");
			processor = u.nextLine();
			if(!u.equalTo("ontel", "SLC", processor)) {
				u.printTab("Laptop RAM has to be either \"ontel\" or \"SLC\"! (case sensitive)");
			}
		} while (!u.equalTo("ontel", "SLC", processor));
		
		do {
			u.printNormal("Input laptop warranty period (laptop warranty period has to be greater than 1 or equal to and less than or equal to 5): ");
			warrantyPeriod = u.nextInt();
			u.nextLine();
			if(!u.gtAndlt(1, 5, warrantyPeriod)) {
				u.printTab("Laptop warranty period has to be greater than or equal to 1 and less than or equal to 5!");
			}
		} while (!u.gtAndlt(1, 5, warrantyPeriod));
		
		do {
			u.printNormal("Input laptop operating system  (laptop operating system has to be \"penguin\" or \"jendela\" (case insensitive)): ");
			operatingSystem = u.nextLine();
			if(!u.equalToIgnoreCase("penguin", "jendela", operatingSystem)) {
				u.printTab("Laptop operating system has to be \"penguin\" or \"jendela\"! (case insensitive)");
			}
		} while (!u.equalToIgnoreCase("penguin", "jendela", operatingSystem));
		productAdded();
	}
	
	public void addShirt() {
		String color;
		String size;
		String material;
		String sleeveLength;
		String collarType;
		String fabricPattern;
		
		addProducts(); 
		
		do {
			u.printNormal("Input shirt color (shirt color has to be either \"black\" / \"white\" / \"pink\" (case sensitive)): ");
			color = u.nextLine();
			if(!u.equalTo("black", "white", "pink", color)) {
				u.printTab("Shirt color has to be either \"black\" / \"white\" / \"pink\"! (case sensitive)");
			}
		} while (!u.equalTo("black", "white", "pink", color));
		
		do {
			u.printNormal("Input shirt size (shirt color has to be either \"s\" / \"m\" / \"l\" (case insensitive)): ");
			size = u.nextLine();
			if(!u.equalToIgnoreCase("s", "m", "l", size)) { 
				u.printTab("Shirt color has to be either \"s\" / \"m\" / \"l\"! (case insensitive)");
			}
		} while (!u.equalToIgnoreCase("s", "m", "l", size));
		
		do {
			u.printNormal("Input shirt material (shirt material has to be either \"cotton\" / \"fleece\" (case sensitive)): ");
			material = u.nextLine();
			if(!u.equalTo("cotton", "fleece", material)) {
				u.printTab("Shirt material has to be either \"cotton\" / \"fleece\"! (case sensitive)");
			}
		} while (!u.equalTo("cotton", "fleece", material));
		
		do {
			u.printNormal("Input shirt sleeve length (shirt sleeve length has to be either \"short\" / \"long\" (case insensitive)): ");
			sleeveLength = u.nextLine();
			if(!u.equalToIgnoreCase("short", "long", sleeveLength)) {
				u.printTab("Shirt color has to be either \"short\" / \"long\"! (case insensitive)");
			}
		} while (!u.equalToIgnoreCase("short", "long", sleeveLength));
		
		do {
			u.printNormal("Input shirt collar type (shirt collar type has to be either \"turtle neck\" / \"crew neck\" (case sensitive)): ");
			collarType = u.nextLine();
			if(!u.equalToIgnoreCase("turtle neck", "crew neck", collarType)) {
				u.printTab("Shirt collar type has to be either \"turtle neck\" / \"crew neck\"! (case sensitive)");
			}
		} while (!u.equalToIgnoreCase("turtle neck", "crew neck", collarType));
		
		do {
			u.printNormal("Input shirt fabric pattern (shirt fabric pattern has to be either \"polka dot\" / \"checkered\" / \"strip\" (case insensitive)): ");
			fabricPattern = u.nextLine();
			if(!u.equalToIgnoreCase("polka dot", "checkered", "strip", fabricPattern)) {
				u.printTab("Shirt fabric pattern  has to be either \"polka dot\" / \"checkered\" / \"strip\"! (case insensitive)");
			}
		} while (!u.equalToIgnoreCase("polka dot", "checkered", "strip", fabricPattern));
		
		productAdded();
	}
	
	public void addBook() {
		String author;
		String genre;
		int publicationYear;
		String crimeType;
		String detective;
		int suspenseLevel;
		
		addProducts();
		
		do {
			u.printNormal("Input author name (author name must starts with either \"Mr. \" / \"Mrs. \" (case sensitive)): ");
			author = u.nextLine();
			if(!u.StartsWith("Mr. ", "Mrs. ", author)) {
				u.printTab("Author name must starts with either \"Mr. \" / \"Mrs. \" (case sensitive)!");
			}
		} while (!u.StartsWith("Mr. ", "Mrs. ", author));
		
		do {
			u.printNormal("Input novel genre (novel genre name must be either \"horror\" / \"thriller\" / \"mystery\" (case insensitive)): ");
			genre = u.nextLine();
			if(!u.equalToIgnoreCase("horror", "thriller", "myustery", genre)) {
				u.printTab("Genre name must be either \"horror\" / \"thriller\" / \"mystery\" (case insensitive)");
			}
		} while (!u.equalToIgnoreCase("horror", "thriller", "myustery", genre));
		
		do {
			u.printNormal("Input novel publication year (novel publication year has to be greater than 2005 and less than 2020): ");
			publicationYear = u.nextInt();
			u.nextLine();
			if(!u.gtAndlt(2005, 2020, publicationYear)) {
				u.printTab("Novel publication year has to be greater than 2005 and less than 2020!");
			}
		} while (!u.gtAndlt(2005, 2020, publicationYear));
		
//		do {
//			u.printNormal("Input novel genre (genre name must be either \"horror\" / \"thriller\" / \"mystery\" (case insensitive)): ");
//			genre = u.nextLine();
//			if(!u.equalToIgnoreCase("horror", "thriller", "mystery", genre)) {
//				u.printTab("Novel genre name must be either \"horror\" / \"thriller\" / \"mystery\" (case insensitive)");
//			}
//		} while (!u.equalToIgnoreCase("horror", "thriller", "mystery", genre));
		
		do {
			u.printNormal("Input novel crime type (novel crime type must be either \"murder\" / \"heist\" / \"genocide\" (case insensitive)): ");
			crimeType = u.nextLine();
			if(!u.equalToIgnoreCase("murder", "heist", "genocide", crimeType)) {
				u.printTab("Novel crime type must be either \"murder\" / \"heist\" / \"genocide\"");
			}
		} while (!u.equalToIgnoreCase("murder", "heist", "genocide", crimeType));
		
		do {
			u.printNormal("Input detective name (detective name must starts with either \"Mr. \" / \"Mrs. \" (case insensitive)): ");
			detective = u.nextLine();
			if(!u.StartsWithIgnoreCase("Mr. ", "Mrs. ", detective)) {
				u.printTab("Detective name must starts with either \"Mr. \" / \"Mrs. \" (case sensitive)!");
			}
		} while (!u.StartsWithIgnoreCase("Mr. ", "Mrs. ", detective));
		
		do {
			u.printNormal("Input suspense level (Suspense level has to be greater than 0 and less than or equal to 5): ");
			suspenseLevel = u.nextInt();
			u.nextLine();
			if(!u.gtAndlt(1, 5, suspenseLevel)) {
				u.printTab("Suspense level has to be greater than 0 and less than or equal to 5!");
			}
		} while (!u.gtAndlt(1, 5, suspenseLevel));
		
		productAdded();
		
	}
}