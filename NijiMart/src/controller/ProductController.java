package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import main.Engine;
import model.Admin;
import model.Laptop;
import model.Novel;
import model.Product;
import model.Regular;
import model.Shirt;
import util.Util;

public class ProductController {
	
	Util util = Util.getInstance();
	private String fileName = "products.csv";
	private static ProductController instance;
	public static int productID = 1;
	
	private ProductController() {
		// TODO Auto-generated constructor stub
	}
	
	public static ProductController getInstance() {
		if(instance == null) {
			instance = new ProductController();
		}
		return instance;
	}
	
	public void addProduct(Product product) {
		Engine.producst.add(product);
		writeFile(product);
	}
	
	public void writeFile(Product product) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
			if(product instanceof Laptop) {
				writer.write(product.getProductID()+" ,"+product.getName()+" ,"+product.getPrice()+" ,"+product.getDescription()+" ,"+((Laptop)product).getScreenSize()+" ,"+((Laptop)product).getRAM()+" ,"+((Laptop)product).getProcessor()+" ,"+((Laptop)product).getWarrantyPeriod()+" ,"+((Laptop)product).getOperatingSystem()+" ,"+"\n");
			}else if(product instanceof Shirt) {
				writer.write(product.getProductID()+" ,"+product.getName()+" ,"+product.getPrice()+" ,"+product.getDescription()+" ,"+((Shirt)product).getSize()+" ,"+((Shirt)product).getColor()+" ,"+((Shirt)product).getMaterial()+" ,"+((Shirt)product).getSleeveLength()+" ,"+((Shirt)product).getCollarType()+" ,"+((Shirt)product).getFabricPattern()+"\n");
			}else if(product instanceof Novel) {
				writer.write(product.getProductID()+" ,"+product.getName()+" ,"+product.getPrice()+" ,"+product.getDescription()+" ,"+((Novel)product).getAuthor()+" ,"+((Novel)product).getGenre()+" ,"+((Novel)product).getPublicationYear()+" ,"+((Novel)product).getCrimeType()+" ,"+((Novel)product).getDetective()+" ,"+((Novel)product).getSuspenseLevel()+"\n");
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public String generateID(String type) {
		String productID = "";
		if(util.equalTo(type, "laptop")) {
			productID = "L"+productID;
		}else if(util.equalTo(type, "shirt")) {
			productID = "S"+productID;
		}else if(util.equalTo(type, "novel")) {
			productID = "N"+productID;
		}
		return productID;
	}
	
	

}
