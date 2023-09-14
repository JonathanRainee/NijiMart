package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.LongAccumulator;

import main.Engine;
import model.Admin;
import model.Laptop;
import model.Novel;
import model.Product;
import model.Regular;
import model.Shirt;
import model.User;
import util.Util;

public class ProductController {
	
	Util util = Util.getInstance();
	private String fileName = "products.csv";
	private static ProductController instance;
	private UserController uc;
	public static int productID = 1;
	
	private ProductController() {
		
	}
	
	public void refreshID() {
		int temp = getLastID() ;
		productID = temp + 1;
	}
	
	public static ProductController getInstance() {
		if(instance == null) {
			instance = new ProductController();
		}
		return instance;
	}
	
	public void addProduct(Product product) {
		Engine.products.add(product);
		writeFile(product);
	}
	
	public void addProd(Product prod) {
		Engine.products.add(prod);
	}
	
	public void writeFile(Product product) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
			if(product instanceof Laptop) {
				writer.write(product.getProductID()+","+product.getName()+","+product.getPrice()+","+product.getDescription()+","+((Laptop)product).getScreenSize()+","+((Laptop)product).getRAM()+","+((Laptop)product).getProcessor()+","+((Laptop)product).getWarrantyPeriod()+","+((Laptop)product).getOperatingSystem()+","+"\n");
			}else if(product instanceof Shirt) {
				writer.write(product.getProductID()+","+product.getName()+","+product.getPrice()+","+product.getDescription()+","+((Shirt)product).getSize()+","+((Shirt)product).getColor()+","+((Shirt)product).getMaterial()+","+((Shirt)product).getSleeveLength()+","+((Shirt)product).getCollarType()+","+((Shirt)product).getFabricPattern()+"\n");
			}else if(product instanceof Novel) {
				writer.write(product.getProductID()+","+product.getName()+","+product.getPrice()+","+product.getDescription()+","+((Novel)product).getAuthor()+","+((Novel)product).getGenre()+","+((Novel)product).getPublicationYear()+","+((Novel)product).getCrimeType()+","+((Novel)product).getDetective()+","+((Novel)product).getSuspenseLevel()+"\n");
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void rewriteProductFile(ArrayList<Product> products) {
		try {
			FileWriter writer = new FileWriter(new File(fileName), false);  
			writer.close();    
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		for (Product product : products) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
				if(product instanceof Laptop) {
					writer.write(product.getProductID()+","+product.getName()+","+product.getPrice()+","+product.getDescription()+","+((Laptop)product).getScreenSize()+","+((Laptop)product).getRAM()+","+((Laptop)product).getProcessor()+","+((Laptop)product).getWarrantyPeriod()+","+((Laptop)product).getOperatingSystem()+","+"\n");
				}else if(product instanceof Shirt) {
					writer.write(product.getProductID()+","+product.getName()+","+product.getPrice()+","+product.getDescription()+","+((Shirt)product).getSize()+","+((Shirt)product).getColor()+","+((Shirt)product).getMaterial()+","+((Shirt)product).getSleeveLength()+","+((Shirt)product).getCollarType()+","+((Shirt)product).getFabricPattern()+"\n");
				}else if(product instanceof Novel) {
					writer.write(product.getProductID()+","+product.getName()+","+product.getPrice()+","+product.getDescription()+","+((Novel)product).getAuthor()+","+((Novel)product).getGenre()+","+((Novel)product).getPublicationYear()+","+((Novel)product).getCrimeType()+","+((Novel)product).getDetective()+","+((Novel)product).getSuspenseLevel()+"\n");
				}
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
	}
	
	public void initProduct() {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            
            while ((line = br.readLine()) != null) {
            	if (!line.trim().isEmpty()) {
            		String[] data = line.split(",");
            		int fieldCount = data.length;
            		String productID = data[0];
            		String productName = data[1];
            		int productPrice = Integer.parseInt(data[2]);
            		String productDesc = data[3];
            		
            		if(productID.startsWith("L")) {
            			float screenSize = Float.parseFloat(data[4]);
            			int ram = Integer.parseInt(data[5]);
            			String processor = data[6];
            			int warranty = Integer.parseInt(data[7]);
            			String operatingSystem = data[8];
            			Laptop laptop = new Laptop(productID, productName, productPrice, productDesc, screenSize, ram, processor, warranty, operatingSystem);
            			addProd(laptop);
            		}else if(productID.startsWith("S")) {
            			String size = data[4];
            			String color = data[5];
            			String material = data[6];
            			String sleeve = data[7];
            			String collar = data[8];
            			String pattern = data[9];
            			Shirt shirt = new Shirt(productID, productName, productPrice, productDesc, size, color, material, sleeve, collar, pattern);
            			addProd(shirt);
            		}else if(productID.startsWith("N")) {
            			String author = data[4];
            			String genre = data[5];
            			int pubyear = Integer.parseInt(data[6]);
            			String crimeType = data[7];
            			String detective = data[8];
            			int suspenseLvl = Integer.parseInt(data[9]);
            			Novel novel = new Novel(productID, productName, productPrice, productDesc, author, genre, pubyear, crimeType, detective, suspenseLvl);
            			addProd(novel);
            		}
            		
            	}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public int getLastID() {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int ID = 0;
            
            while ((line = br.readLine()) != null) {
            	if (!line.trim().isEmpty()) {
            		String[] data = line.split(",");
            		int fieldCount = data.length;
            		String productID = data[0];
            		ID = Integer.parseInt(productID.charAt(1)+"");
            	}
            }
            return ID;
        } catch (IOException e) {
            e.printStackTrace();
        }
		return 0;
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
	
	public Product searchProduct(String ID) {
		for (Product p : Engine.products) {
			if(p.getProductID().equals(ID)) {
				return p;
			}
		}
		return null;
	}
	
	public void updateProduct(Product destination, Product source) {
		if(destination instanceof Laptop) {
			((Laptop)destination).setName(((Laptop)source).getName());
			((Laptop)destination).setPrice(((Laptop)source).getPrice());
			((Laptop)destination).setDescription(((Laptop)source).getDescription());
			((Laptop)destination).setScreenSize(((Laptop)source).getScreenSize());
			((Laptop)destination).setRAM(((Laptop)source).getRAM());
			((Laptop)destination).setProcessor(((Laptop)source).getProcessor());
			((Laptop)destination).setWarrantyPeriod(((Laptop)source).getWarrantyPeriod());
			((Laptop)destination).setOperatingSystem(((Laptop)source).getOperatingSystem());
		}else if(destination instanceof Shirt) {
			((Shirt)destination).setName(((Shirt)source).getName());
			((Shirt)destination).setPrice(((Shirt)source).getPrice());
			((Shirt)destination).setDescription(((Shirt)source).getDescription());
			((Shirt)destination).setSize(((Shirt)source).getSize());
			((Shirt)destination).setColor(((Shirt)source).getColor());
			((Shirt)destination).setMaterial(((Shirt)source).getMaterial());
			((Shirt)destination).setSleeveLength(((Shirt)source).getSleeveLength());
			((Shirt)destination).setCollarType(((Shirt)source).getCollarType());
			((Shirt)destination).setFabricPattern(((Shirt)source).getFabricPattern());
		}else if(destination instanceof Novel) {
			((Novel)destination).setName(((Novel)source).getName());
			((Novel)destination).setPrice(((Novel)source).getPrice());
			((Novel)destination).setDescription(((Novel)source).getDescription());
			((Novel)destination).setAuthor(((Novel)source).getAuthor());
			((Novel)destination).setGenre(((Novel)source).getGenre());
			((Novel)destination).setPublicationYear(((Novel)source).getPublicationYear());
			((Novel)destination).setCrimeType(((Novel)source).getCrimeType());
			((Novel)destination).setDetective(((Novel)source).getDetective());
			((Novel)destination).setSuspenseLevel(((Novel)source).getSuspenseLevel());
			
		}
	}
	
	public void deleteProduct(String id) {
		Product prod = searchProduct(id);
		int i = 0;
//		for (Product p : Engine.products) {
//			System.out.println(p.getProductID()+"| |"+id+"|");
//			if(p.equals(prod)) {
//				Engine.products.remove(prod);
//			}
//		}
		
		Iterator<Product> iter = Engine.products.iterator();
		while (iter.hasNext()) {
		    Product p = iter.next();
		    if (p.equals(prod)) {
		    	iter.remove(); // Safe removal using the iterator
		        System.out.println("rimuvv");
		    }
		    System.out.println("loll");
		}
		
		if(Engine.currUser.getCart().isEmpty()) {
			System.out.println("kosong");
		}else {
			System.out.println("g kososng");
		}
		
//		for (Product p : Engine.currUser.getCart()) {
//			if(p.getProductID().equals(id)) {
//				Engine.currUser.getCart().remove(i);
//				System.out.println("hehe");
//			}
//			System.out.println("loll");
//			i++;
//		}
		
		Iterator<Product> iterator = Engine.currUser.getCart().iterator();
		while (iterator.hasNext()) {
		    Product p = iterator.next();
		    if (p.getProductID().equals(id)) {
		        iterator.remove(); // Safe removal using the iterator
		        System.out.println("hehe");
		    }
		    System.out.println("loll");
		}
		
		for (Product p : Engine.products) {
			System.out.println(p.getProductID()+" "+p.getName());
			
		}

		rewriteProductFile(Engine.products);
		
	}
	

}
