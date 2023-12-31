package view;

import java.util.ArrayList;

import javax.swing.text.html.CSS;

import controller.ProductController;
import controller.UserController;
import main.Engine;
import model.Laptop;
import model.Novel;
import model.Product;
import model.Shirt;
import util.Util;

public class ProductView {

	private static ProductView instance;
	private Util u = Util.getInstance();
	private ProductController pc = ProductController.getInstance();
	private UserController uc = UserController.getInstance();
	
	private String name;
	private int price;
	private String description;
	private String id = "";
	private String idToCart = "";
	
	private ProductView() {
	}
	
	public static ProductView getInstance() {
		if(instance == null) {
			instance = new ProductView();
		}
		return instance;
	}
	
	public void addProduct() {
		int opt = -9;
		String menuOpt;
		do {
			u.cls();
			u.printTab("Add Product");
			u.printTab("===========");
			u.printTab("1. Laptop");
			u.printTab("2. Shirt");
			u.printTab("3. Novel");
			u.printTab("4. Cancel");			
			u.printNormal(">> ");
			menuOpt = u.nextLine();
			if(u.isInteger(menuOpt)) {
				opt = Integer.parseInt(menuOpt);
				switch (opt) {
					case 1:
						addLaptop();
						break;
					case 2:
						addShirt();
						break;
					case 3:
						addNovel();
						break;
					}
			} else {
				u.printTab("Please input an integer!");
				u.nextLine();
			}
		} while (opt != 4);
	}
	
	public void viewPDetail(Product p) {
		u.cls();
		u.printTab("Product ID: "+p.getProductID());
		u.printTab("Product name: "+p.getName());
		u.printTab("Product price: $"+p.getPrice());
		u.printTab("Product description: "+p.getDescription());
	}
	
	public void addToCart(Product p) {
		uc.addProductToCart(Engine.currUser, p);
		u.pressEnter();
	}
	
	public void viewProdDetail(Product p) {
		viewPDetail(p);
		if(p instanceof Laptop) {
			viewPDetail(p);
			u.printTab("Laptop screensize: "+((Laptop)p).getScreenSize()+"'");
			u.printTab("Laptop RAM: "+((Laptop)p).getRAM()+"GB");
			u.printTab("Laptop processor: "+((Laptop)p).getProcessor());
			u.printTab("Laptop warranty period: "+((Laptop)p).getWarrantyPeriod()+" year");
			u.printTab("Laptop operating system: "+((Laptop)p).getOperatingSystem());
		}else if(p instanceof Shirt) {
			viewPDetail(p);
			u.printTab("Shirt size: "+((Shirt)p).getSize());
			u.printTab("Shirt color: "+((Shirt)p).getColor());
			u.printTab("Shirt material: "+((Shirt)p).getMaterial());
			u.printTab("Shirt sleeve length: "+((Shirt)p).getSleeveLength());
			u.printTab("Shirt collar type: "+((Shirt)p).getCollarType());
			u.printTab("Shirt fabric pattern: "+((Shirt)p).getFabricPattern());
		}else if(p instanceof Novel) {
			viewPDetail(p);
			u.printTab("Novel author: "+((Novel)p).getAuthor());
			u.printTab("Novel genre: "+((Novel)p).getGenre());
			u.printTab("Novel publication year: "+((Novel)p).getPublicationYear());
			u.printTab("Novel crime type: "+((Novel)p).getCrimeType());
			u.printTab("Novel detective: "+((Novel)p).getDetective());
			u.printTab("Novel suspense level: "+((Novel)p).getSuspenseLevel());
		}
	}
	
	public void viewLaptopDetailCart(Product p) {
		String inp;
		int q = -9;
		do {
			viewProdDetail(p);
			u.printNormal("Input the quantity you want to add to your cart (0 to cancel): ");
			inp = u.nextLine();
			if(u.isInteger(inp)) {
				q = Integer.parseInt(inp);
				if(q < 0 || q >= 10) {
					u.printTab("Please input the right amount quantity!");
					u.nextLine();
				}else if(q >= 1) {
					Laptop l = new Laptop(p.getProductID(), p.getName(), p.getPrice(), p.getDescription(), q, ((Laptop)p).getScreenSize(), ((Laptop)p).getRAM(), ((Laptop)p).getProcessor(), ((Laptop)p).getWarrantyPeriod(), ((Laptop)p).getOperatingSystem());
					addToCart(l);
					return;
				}else if(q == 0){
					return;
				}
			}else {
				u.printTab("Please input an integer!");
				u.pressEnter();
			}
		} while (q != 0);
	}
	
	public void viewShirtDetailCart(Product p) {
		String inp;
		int q = -9;
		do {
			viewProdDetail(p);
			u.printNormal("Input the quantity you want to add to your cart (0 to cancel): ");
			inp = u.nextLine();
			if(u.isInteger(inp)) {
				q = Integer.parseInt(inp);
				if(q < 0 || q >= 10) {
					u.printTab("Please input the right amount quantity!");
					u.nextLine();
				}else if(q >= 1) {
					Shirt s = new Shirt(p.getProductID(), p.getName(), p.getPrice(), p.getDescription(), q, ((Shirt)p).getSize(), ((Shirt)p).getColor(), ((Shirt)p).getMaterial(), ((Shirt)p).getSleeveLength(), ((Shirt)p).getCollarType(), ((Shirt)p).getFabricPattern());
					addToCart(s);
					return;
				}else if(q == 0){
					return;
				}			
			} else {
				u.printTab("Please input an integer!");
				u.pressEnter();
			}
		} while (q != 0);
	}
	
	public void viewNovelDetailCart(Product p) {
		String inp;
		int q = -9;
		do {
			viewProdDetail(p);
			u.printNormal("Input the quantity you want to add to your cart (0 to cancel): ");
			inp = u.nextLine();
			if(u.isInteger(inp)) {
				q = Integer.parseInt(inp);
				if(q < 0 || q >= 10) {
					u.printTab("Please input the right amount quantity!");
					u.nextLine();
				}else if(q >= 1) {
					Novel n = new Novel(p.getProductID(), p.getName(), p.getPrice(), p.getDescription(), q, ((Novel)p).getAuthor(), ((Novel)p).getGenre(), ((Novel)p).getPublicationYear(), ((Novel)p).getCrimeType(), ((Novel)p).getDetective(), ((Novel)p).getSuspenseLevel());
					addToCart(n);
					return;
				}else if(q == 0){
					return;
				}
			} else {
				u.printTab("Please input an integer!");
				u.pressEnter();
			}
		} while (q != 0);
	}
	
	public void viewProductDetailCart(Product p) {
		if(p instanceof Laptop) {
			viewLaptopDetailCart(p);
		}else if(p instanceof Shirt) {
			viewShirtDetailCart(p);
		}else if(p instanceof Novel) {
			viewNovelDetailCart(p);
		}
	}
	
	public void productDetailPromptCart(String type) {
		Product p = null;
		do {
			if(type.equals("laptop")) {
				viewLaptopCart();				
			}else if(type.equals("shirt")) {
				viewShirtCart();
			}else if(type.equals("novel")) {
				viewNovelCart();
			}
			
			u.printNormal("To see the "+type+" detail please input the "+"type"+" ID (0 to cancel): ");
			id = u.nextLine();
			if(id.equals("0")) {
				return;
			}else {
				p = pc.searchProduct(id);
			}
			if(p != null) {
				if(uc.productIsInCart(id)) {
//					here
					u.printTab("The product is already in your cart!");
					u.pressEnter();
				}else {
					viewProductDetailCart(p);					
				}
			}else {
				u.printTab("Please input the right "+type+" ID!");
				u.pressEnter();
			}
		} while (p == null);
	}
	
	public void productDetail(String type) {
		
		Product prod;
		do {
			do {
				if(type.equals("laptop")) {
					
					u.cls();
					if(pc.laptopExist()) {
						u.printTab("+===============================================================+");
						u.printTab("|                            NijiMart                           |");
						u.printTab("+======+================+===========+============+==============+");
						u.printTab("|  ID  |      Name      |   Price   |  Warranty  |   Processor  |");
						u.printTab("+======+================+===========+============+==============+");
						for (Product p: Engine.products) {
							if(p instanceof Laptop) {
								System.out.printf("\t|  %-3s |  %-13s |  $%-7d |%6dY     |     %-9s|\n", p.getProductID(), p.getName(), p.getPrice(), ((Laptop) p).getWarrantyPeriod(), ((Laptop) p).getProcessor());
							}else{
								continue;
							}
						}
						u.printTab("+======+================+===========+============+==============+");				
					}else {
						noProduct("laptop");
						return;
					}

				}else if(type.equals("shirt")) {
					u.cls();
					if(pc.shirtExist()) {
						u.printTab("+=============================================================+");
						u.printTab("|                           NijiMart                          |");
						u.printTab("+======+================+===========+==========+==============+");
						u.printTab("|  ID  |      Name      |   Price   |   Size   |   Material   |");
						u.printTab("+======+================+===========+==========+==============+");
						for (Product p: Engine.products) {
							if(p instanceof Shirt) {
								System.out.printf("\t|  %-3s |  %-13s |  $%-7d |%6s    |    %-9s |\n", p.getProductID(), p.getName(), p.getPrice(), ((Shirt) p).getSize(), ((Shirt) p).getMaterial());
							}else{
								continue;
							}
						}
						u.printTab("+======+================+===========+==========+==============+");	
					}else {
						noProduct("shirt");
						return;
					}
				}else if(type.equals("novel")) {
					u.cls();
					if(pc.novelExist()) {
						u.printTab("+=====================================================================+");
						u.printTab("|                               NijiMart                               |");
						u.printTab("+======+================+===========+=====================+============+");
						u.printTab("|  ID  |      Name      |   Price   |       Author        |    Genre   |");
						u.printTab("+======+================+===========+=====================+============+");
						for (Product p: Engine.products) {
							if(p instanceof Novel) {
								System.out.printf("\t|  %-3s |  %-13s |  $%-7d |  %15s    |  %-9s |\n", p.getProductID(), p.getName(), p.getPrice(), ((Novel) p).getAuthor(), ((Novel) p).getGenre());
							}else{
								continue;
							}
						}
						u.printTab("+======+================+===========+=====================+============+");		
					}else {
						noProduct("novel");
						return;
					}
				}
				u.printNormal("To see the "+type+" detail please input the "+"type"+" ID (0 to cancel): ");
				id = u.nextLine();
				prod = pc.searchProduct(id);
				if(id.equals("0")) {
					return;
				}
				if(prod == null) {
					u.printNormal("Please input the right "+type+" ID!");
					u.nextLine();
				} else if(prod != null){
					viewProdDetail(prod);
					u.pressEnter();
				}				
			} while (prod == null);
			
		} while (prod == null);
	}

	public void noProduct(String type) {
		u.printTab("There are currently no "+type);
		u.pressEnter();
	}
	
	public void viewLaptopCart() {
		u.cls();
		if(pc.laptopExist()) {
			u.printTab("+===============================================================+");
			u.printTab("|                            NijiMart                           |");
			u.printTab("+======+================+===========+============+==============+");
			u.printTab("|  ID  |      Name      |   Price   |  Warranty  |   Processor  |");
			u.printTab("+======+================+===========+============+==============+");
			for (Product p: Engine.products) {
				if(p instanceof Laptop) {
					System.out.printf("\t|  %-3s |  %-13s |  $%-7d |%6dY     |     %-9s|\n", p.getProductID(), p.getName(), p.getPrice(), ((Laptop) p).getWarrantyPeriod(), ((Laptop) p).getProcessor());
				}else{
					continue;
				}
			}
			u.printTab("+======+================+===========+============+==============+");	
		}else {
			noProduct("laptop");
			
		}
	}
	
	public void viewShirtCart() {
		u.cls();
		u.printTab("+=============================================================+");
		u.printTab("|                           NijiMart                          |");
		u.printTab("+======+================+===========+==========+==============+");
		u.printTab("|  ID  |      Name      |   Price   |   Size   |   Material   |");
		u.printTab("+======+================+===========+==========+==============+");
		for (Product p: Engine.products) {
			if(p instanceof Shirt) {
				System.out.printf("\t|  %-3s |  %-13s |  $%-7d |%6s    |    %-9s |\n", p.getProductID(), p.getName(), p.getPrice(), ((Shirt) p).getSize(), ((Shirt) p).getMaterial());
			}else{
				continue;
			}
		}
		u.printTab("+======+================+===========+==========+==============+");
	}
	
	public void viewNovelCart() {
		u.cls();
		u.printTab("+======================================================================+");
		u.printTab("|                               NijiMart                               |");
		u.printTab("+======+================+===========+=====================+============+");
		u.printTab("|  ID  |      Name      |   Price   |       Author        |    Genre   |");
		u.printTab("+======+================+===========+=====================+============+");
		for (Product p: Engine.products) {
			if(p instanceof Novel) {
				System.out.printf("\t|  %-3s |  %-13s |  $%-7d |  %15s    |  %-9s |\n", p.getProductID(), p.getName(), p.getPrice(), ((Novel) p).getAuthor(), ((Novel) p).getGenre());
			}else{
				continue;
			}
		}
		u.printTab("+======+================+===========+=====================+============+");
	}
	
	public void viewLaptop() {
		u.cls();
		if(pc.laptopExist()) {
			u.printTab("+===============================================================+");
			u.printTab("|                            NijiMart                           |");
			u.printTab("+======+================+===========+============+==============+");
			u.printTab("|  ID  |      Name      |   Price   |  Warranty  |   Processor  |");
			u.printTab("+======+================+===========+============+==============+");
			for (Product p: Engine.products) {
				if(p instanceof Laptop) {
					System.out.printf("\t|  %-3s |  %-13s |  $%-7d |%6dY     |     %-9s|\n", p.getProductID(), p.getName(), p.getPrice(), ((Laptop) p).getWarrantyPeriod(), ((Laptop) p).getProcessor());
				}else{
					continue;
				}
			}
			u.printTab("+======+================+===========+============+==============+");
			productDetail("laptop");
		}else {
			noProduct("laptop");
		}
	}
	
	public void viewShirt() {
		u.cls();
		u.printTab("+=============================================================+");
		u.printTab("|                           NijiMart                          |");
		u.printTab("+======+================+===========+==========+==============+");
		u.printTab("|  ID  |      Name      |   Price   |   Size   |   Material   |");
		u.printTab("+======+================+===========+==========+==============+");
		for (Product p: Engine.products) {
			if(p instanceof Shirt) {
				System.out.printf("\t|  %-3s |  %-13s |  $%-7d |%6s    |    %-9s |\n", p.getProductID(), p.getName(), p.getPrice(), ((Shirt) p).getSize(), ((Shirt) p).getMaterial());
			}else{
				continue;
			}
		}
		u.printTab("+======+================+===========+==========+==============+");
		
		productDetail("shirt");
	}
	
	public void viewNovel() {
		u.cls();
		u.printTab("+======================================================================+");
		u.printTab("|                               NijiMart                               |");
		u.printTab("+======+================+===========+=====================+============+");
		u.printTab("|  ID  |      Name      |   Price   |       Author        |    Genre   |");
		u.printTab("+======+================+===========+=====================+============+");
		for (Product p: Engine.products) {
			if(p instanceof Novel) {
				System.out.printf("\t|  %-3s |  %-13s |  $%-7d |  %15s    |  %-9s |\n", p.getProductID(), p.getName(), p.getPrice(), ((Novel) p).getAuthor(), ((Novel) p).getGenre());
			}else{
				continue;
			}
		}
		u.printTab("+======+================+===========+=====================+============+");
		productDetail("novel");
	}
	
	public void viewLptp() {
		u.cls();
		if(pc.laptopExist()) {
			u.printTab("+===============================================================+");
			u.printTab("|                            NijiMart                           |");
			u.printTab("+======+================+===========+============+==============+");
			u.printTab("|  ID  |      Name      |   Price   |  Warranty  |   Processor  |");
			u.printTab("+======+================+===========+============+==============+");
			for (Product p: Engine.products) {
				if(p instanceof Laptop) {
					System.out.printf("\t|  %-3s |  %-13s |  $%-7d |%6dY     |     %-9s|\n", p.getProductID(), p.getName(), p.getPrice(), ((Laptop) p).getWarrantyPeriod(), ((Laptop) p).getProcessor());
				}else{
					continue;
				}
			}
			u.printTab("+======+================+===========+============+==============+");	
		}else {
			noProduct("laptop");
			return;
		}
	}
	
	public void viewShrt() {
		u.cls();
		u.printTab("+=============================================================+");
		u.printTab("|                           NijiMart                          |");
		u.printTab("+======+================+===========+==========+==============+");
		u.printTab("|  ID  |      Name      |   Price   |   Size   |   Material   |");
		u.printTab("+======+================+===========+==========+==============+");
		for (Product p: Engine.products) {
			if(p instanceof Shirt) {
				System.out.printf("\t|  %-3s |  %-13s |  $%-7d |%6s    |    %-9s |\n", p.getProductID(), p.getName(), p.getPrice(), ((Shirt) p).getSize(), ((Shirt) p).getMaterial());
			}else{
				continue;
			}
		}
		u.printTab("+======+================+===========+==========+==============+");
		
	}
	
	public void viewNvl() {
		u.cls();
		u.printTab("+======================================================================+");
		u.printTab("|                               NijiMart                               |");
		u.printTab("+======+================+===========+=====================+============+");
		u.printTab("|  ID  |      Name      |   Price   |       Author        |    Genre   |");
		u.printTab("+======+================+===========+=====================+============+");
		for (Product p: Engine.products) {
			if(p instanceof Novel) {
				System.out.printf("\t|  %-3s |  %-13s |  $%-7d |  %15s    |  %-9s |\n", p.getProductID(), p.getName(), p.getPrice(), ((Novel) p).getAuthor(), ((Novel) p).getGenre());
			}else{
				continue;
			}
		}
		u.printTab("+======+================+===========+=====================+============+");
	}
	
	public void addLaptopToCartView() {
		u.cls();
		if(!pc.laptopExist()) {
			noProduct("laptop");
			return;
		}else {
			do {
				u.cls();
				productDetailPromptCart("laptop");	
			} while (!id.equals("0"));			
		}
	}
	
	public void addShirtToCartView() {
		u.cls();
		if(!pc.shirtExist()) {
			noProduct("shirt");
			return;
		}else {
			do {
				viewShirtCart();
				productDetailPromptCart("shirt");
				
			} while (!id.equals("0"));			
		}
	}
	
	public void addNovelToCartView() {
		u.cls();
		if(!pc.novelExist()) {
			noProduct("novel");
			return;
		}else {
			do {
				viewNovelCart();
				productDetailPromptCart("novel");
			} while (!id.equals("0"));			
		}
	}
	
	public String updatePrompt(String type) {
		String id = "0";
		u.printNormal("Insert the "+type+" ID you want to update (0 to cancel): ");
		id = u.nextLine();
		return id;
	}
	
	public String deletePrompt(String type) {
		String id = "0";
		u.printNormal("Insert the "+type+" ID you want to delete (0 to cancel): ");
		id = u.nextLine();
		return id;
	}
	
	public void updateLaptopView() {
		String opt = "";
		Product destination = null;
		Product source = null;
		u.cls();
		
		if(!pc.laptopExist()) {
			noProduct("laptop");
			return;
		}else {
			do {
				do {
					viewLptp();
					opt = updatePrompt("laptop");
					destination = pc.searchProduct(opt);
					if(opt.equals("0")) {
						break;
					}
					if(destination == null) {
						u.printNormal("Please input the right laptop ID!");
						u.nextLine();
					}
				} while (destination == null);
				if(opt.equals("0")) {
					break;
				}
				source = updateLaptopPrompt();
				pc.updateProduct(destination, source);
				pc.rewriteProductFile(Engine.products);
			} while (!opt.equals("0") || destination == null);			
		}
	}
	
	public void updateShirtView() {
		String opt = "";
		Product destination = null;
		Product source = null;
		u.cls();
		if(!pc.shirtExist()) {
			noProduct("shirt");
			return;
		}else {
			do {
				do {
					viewShrt();
					opt = updatePrompt("shirt");
					destination = pc.searchProduct(opt);	
					if(opt.equals("0")) {
						break;
					}
					if(destination == null) {
						u.printNormal("Please input the right shirt ID!");
						u.nextLine();
					}
				} while (destination == null);
				if(opt.equals("0")) {
					break;
				}
				source = updateShirtPrompt();
				pc.updateProduct(destination, source);
				pc.rewriteProductFile(Engine.products);
			} while (!opt.equals("0") || destination == null);			
		}
	}
	
	public void updateNovelView() {
		String opt = "";
		Product destination = null;
		Product source = null;
		u.cls();
		if(!pc.novelExist()) {
			noProduct("novel");
			return;
		}else {
			do {
				do {
					viewNvl();
					opt = updatePrompt("novel");
					destination = pc.searchProduct(opt);
					if(opt.equals("0")) {
						break;
					}
					if(destination == null) {
						u.printNormal("Please input the right novel ID!");
						u.nextLine();
					}
				} while (destination == null);
				if(opt.equals("0")) {
					break;
				}
				source = updateNovelPrompt();
				pc.updateProduct(destination, source);
				pc.rewriteProductFile(Engine.products);
			} while (!opt.equals("0") || destination == null);			
		}
	}
	
	public void addProductToCart() {
		int opt = -9;
		String menuOpt;
		do {
			u.cls();
			u.printTab("NijiMart");
			u.printTab("========");
			u.printTab("1. Laptop");
			u.printTab("2. Shirt");
			u.printTab("3. Novel");
			u.printTab("4. Cancel");
			u.printNormal(">> ");
			menuOpt = u.nextLine();
			if(u.isInteger(menuOpt)) {
				opt = Integer.parseInt(menuOpt);
				switch (opt) {
					case 1:
						addLaptopToCartView();
						break;
					case 2:
						addShirtToCartView();
						break;
					case 3:
						addNovelToCartView();
						break;
					case 4:
						return;
				}
			}else {
				u.printTab("Please input an integer!");
				u.nextLine();
			}
		} while (opt != 4);
	}

	public void viewProduct() {
		String menuOpt;
		int opt = -9;
		do {
			u.cls();
			u.printTab("NijiMart");
			u.printTab("========");
			u.printTab("1. Laptop");
			u.printTab("2. Shirt");
			u.printTab("3. Novel");
			u.printTab("4. Cancel");
			u.printNormal(">> ");
			menuOpt = u.nextLine();
			if(u.isInteger(menuOpt)) {
				opt = Integer.parseInt(menuOpt);
				switch (opt) {
					case 1:
						productDetail("laptop");
						break;
					case 2:
						productDetail("shirt");
						break;
					case 3:
						productDetail("novel");
						break;
					case 4:
						return;
				}
			} else {
				u.printTab("Please input an integer!");
				u.nextLine();
			}
		} while (opt != 4);
	}
	
	public void viewP() {
		for (Product p : Engine.products) {
			System.out.println(p.getName()+" "+p.getPrice()+" "+p.getDescription());
		}
	}
	
	public void updateProduct() {
		String menuOpt;
		int opt = -9;
		do {
			u.cls();
			u.printTab("NijiMart");
			u.printTab("========");
			u.printTab("1. Laptop");
			u.printTab("2. Shirt");
			u.printTab("3. Novel");
			u.printTab("4. Cancel");
			u.printNormal(">> ");
			menuOpt = u.nextLine();
			if(u.isInteger(menuOpt)) {		
				opt = Integer.parseInt(menuOpt);
				switch (opt) {
					case 1:
						updateLaptopView();
						break;
					case 2:
						updateShirtView();
						break;
					case 3:
						updateNovelView();
						break;
					case 4:
						return;
				}
			} else {
				u.printTab("Please input an integer!");
				u.nextLine();
			}
		} while (opt != 4);
	}
	
	public void deleteLaptopView() {
		String opt = "";
		Product toDel = null;
		String conf = "a";
		u.cls();
		if(!pc.laptopExist()) {
			noProduct("laptop");
			return;
		}else {
			do {
				viewLptp();
				opt = deletePrompt("laptop");
				toDel = pc.searchProduct(opt);
				if(opt.equals("0")) {
					break;
				}
				if(toDel == null) {
					u.printNormal("Please input the right laptop ID!");
					u.nextLine();
				}else {
					do {
						u.printNormal("Are you sure you want to delete this laptop? (\"Y\" to proceed \"N\" to cancel | case sensitive): ");
						conf = u.nextLine();
						if(conf.equals("Y")) {
							u.printTab("Laptop deleted succesfully!");
							u.pressEnter();
							pc.deleteProduct(opt);
							uc.rewriteFile(Engine.users);
							return;
						}else if(conf.equals("N")) {
							return;
						}
					} while (!conf.equals("Y") && !conf.equals("N"));
				}
			} while (!opt.equals("0")|| toDel == null || conf.equals("N"));			
		}
	}
	
	public void deleteShirtView() {
		String opt = "";
		Product toDel = null;
		String conf = "a";
		u.cls();
		if(!pc.shirtExist()) {
			noProduct("shirt");
			return;
		}else {
			do {
				viewShrt();
				opt = deletePrompt("shirt");
				toDel = pc.searchProduct(opt);
				if(opt.equals("0")) {
					break;
				}
				if(toDel == null) {
					u.printNormal("Please input the right shirt ID!");
					u.nextLine();
				}else {
					do {
						u.printNormal("Are you sure you want to delete this shirt? (\"Y\" to proceed \"N\" to cancel | case sensitive): ");
						conf = u.nextLine();
						if(conf.equals("Y")) {
							u.printTab("Shirt deleted succesfully!");
							u.pressEnter();
							pc.deleteProduct(opt);
							uc.rewriteFile(Engine.users);
							return;
						}else if(conf.equals("N")) {
							return;
						}
					} while (!conf.equals("Y") && !conf.equals("N"));
				}
			} while (!opt.equals("0")|| toDel == null || conf.equals("N"));			
		}
	}
	
	public void deleteNovelView() {
		String opt = "";
		Product toDel = null;
		String conf = "a";
		u.cls();
		if(!pc.novelExist()) {
			noProduct("novel");
			return;
		}else {
			do {
				viewNvl();
				opt = deletePrompt("novel");
				toDel = pc.searchProduct(opt);
				if(opt.equals("0")) {
					break;
				}
				if(toDel == null) {
					u.printNormal("Please input the right novel ID!");
					u.nextLine();
				}else {
					do {
						u.printNormal("Are you sure you want to delete this novel? (\"Y\" to proceed \"N\" to cancel | case sensitive): ");
						conf = u.nextLine();
						if(conf.equals("Y")) {
							u.printTab("Novel deleted succesfully!");
							u.pressEnter();
							pc.deleteProduct(opt);
							uc.rewriteFile(Engine.users);
							return;
						}else if(conf.equals("N")) {
							return;
						}
					} while (!conf.equals("Y") && !conf.equals("N"));
				}
			} while (!opt.equals("0")|| toDel == null || conf.equals("N"));			
		}
	}
	
	public void deleteProduct() {
		int opt = -9;
		String menuOpt;
		do {
			u.cls();
			u.printTab("NijiMart");
			u.printTab("========");
			u.printTab("1. Laptop");
			u.printTab("2. Shirt");
			u.printTab("3. Novel");
			u.printTab("4. Cancel");
			u.printNormal(">> ");
			menuOpt = u.nextLine();
			if(u.isInteger(menuOpt)) {
				opt = Integer.parseInt(menuOpt);
				switch (opt) {
					case 1:
						deleteLaptopView();
						break;
					case 2:
						deleteShirtView();
						break;
					case 3:
						deleteNovelView();
						break;
					case 4:
						return;
					}
				
			} else {
				u.printTab("Please input an integer!");
				u.nextLine();
			}
		} while (opt != 4);
	}
	
	public void productAdded() {
		u.printTab("Product added sucessfully!");
		u.printTab("Press enter to continue...");
		ProductController.productID++;
		u.nextLine();
	}
	
	public void addProducts() {
		u.cls();
		do {
			u.printNormal("Input product name (product name 5-25 characters): ");
			name = u.nextLine();
			if(!u.gtAndlt(5, 25, name.length())) {
				u.printTab("Product name length has to be greater than 5 and less than 25 characters!");
			}
		} while (!u.gtAndlt(5, 25, name.length()));
		
		do {
			u.printNormal("Input product price (product price 10000-120000): ");
			price = u.nextInt();
			u.nextLine();
			if(!u.gtAndlt(10000, 120000, price)) {
				u.printTab("Product price has to be greater than 10000 and less than 120000!");
			}
		} while (!u.gtAndlt(10000, 120000, price));
		
		do {
			u.printNormal("Input product description (product description 10-30 characters): ");
			description = u.nextLine();
			if(!u.gtAndlt(10, 25, description.length())) {
				u.printTab("Product description length has to be greater than 10 and less than 30 characters!");
			}
		} while (!u.gtAndlt(10, 25, description.length()));
	}
	
	public void addLaptop() {
		float screenSize;
		int RAM;
		String processor;
		int warrantyPeriod  = -9;
		String operatingSystem;
		String wp;
		
		addProducts();
		
		do {
			u.printNormal("Input laptop screen size (laptop screen size 12.5-18.5): ");
			screenSize = u.nextFloat();
			u.nextLine();
			if(!u.gtAndlt(12.5f, 18.5f, screenSize)) {
				u.printTab("Laptop screen size has to be greater than 12.5 and less than 18.5!");
			}
		} while (!u.gtAndlt(12.5f, 18.5f, screenSize));
		
		do {
			u.printNormal("Input laptop RAM (laptop RAM 4-64): ");
			RAM = u.nextInt();
			u.nextLine();
			if(!u.gtAndlt(4, 64, RAM)) {
				u.printTab("Laptop RAM has to be greater than or equal to 4 and less than or equal to 64!");
			}
		} while (!u.gtAndlt(4, 64, RAM));
		
		do {
			u.printNormal("Input laptop processor (\"ontel\" / \"SLC\" (case sensitive)): ");
			processor = u.nextLine();
			if(!u.equalTo("ontel", "SLC", processor)) {
				u.printTab("Laptop RAM has to be \"ontel\" or \"SLC\"! (case sensitive)");
			}
		} while (!u.equalTo("ontel", "SLC", processor));
		
		do {
			u.printNormal("Input laptop warranty period (laptop warranty period 1-5): ");
			wp = u.nextLine();
			if(u.isInteger(wp)) {
				warrantyPeriod = Integer.parseInt(wp);
				if(!u.gtAndlt(1, 5, warrantyPeriod)) {
					u.printTab("Laptop warranty period has to be greater than or equal to 1 and less than or equal to 5!");
				}
			}else {
				u.printTab("Please input an integer!");
			}
		} while (!u.gtAndlt(1, 5, warrantyPeriod));
		
		do {
			u.printNormal("Input laptop operating system (\"penguin\" / \"jendela\" (case insensitive)): ");
			operatingSystem = u.nextLine();
			if(!u.equalToIgnoreCase("penguin", "jendela", operatingSystem)) {
				u.printTab("Laptop operating system has to be \"penguin\" or \"jendela\"! (case insensitive)");
			}
		} while (!u.equalToIgnoreCase("penguin", "jendela", operatingSystem));
		
		pc.refreshID();
		Laptop laptop = new Laptop("L"+pc.productID, name, price, description, screenSize, RAM, processor, warrantyPeriod, operatingSystem);
		pc.addProduct(laptop);
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
			u.printNormal("Input shirt color (\"black\" / \"white\" / \"pink\" (case sensitive)): ");
			color = u.nextLine();
			if(!u.equalTo("black", "white", "pink", color)) {
				u.printTab("Shirt color has to be \"black\" / \"white\" / \"pink\"! (case sensitive)");
			}
		} while (!u.equalTo("black", "white", "pink", color));
		
		do {
			u.printNormal("Input shirt size (\"s\" / \"m\" / \"l\" (case insensitive)): ");
			size = u.nextLine();
			if(!u.equalToIgnoreCase("s", "m", "l", size)) { 
				u.printTab("Shirt color has to be \"s\" / \"m\" / \"l\"! (case insensitive)");
			}
		} while (!u.equalToIgnoreCase("s", "m", "l", size));
		
		do {
			u.printNormal("Input shirt material (\"cotton\" / \"fleece\" (case sensitive)): ");
			material = u.nextLine();
			if(!u.equalTo("cotton", "fleece", material)) {
				u.printTab("Shirt material has to be \"cotton\" / \"fleece\"! (case sensitive)");
			}
		} while (!u.equalTo("cotton", "fleece", material));
		
		do {
			u.printNormal("Input shirt sleeve length (\"short\" / \"long\" (case insensitive)): ");
			sleeveLength = u.nextLine();
			if(!u.equalToIgnoreCase("short", "long", sleeveLength)) {
				u.printTab("Shirt color has to be \"short\" / \"long\"! (case insensitive)");
			}
		} while (!u.equalToIgnoreCase("short", "long", sleeveLength));
		
		do {
			u.printNormal("Input shirt collar type (\"turtle neck\" / \"crew neck\" (case sensitive)): ");
			collarType = u.nextLine();
			if(!u.equalTo("turtle neck", "crew neck", collarType)) {
				u.printTab("Shirt collar type has to be \"turtle neck\" / \"crew neck\"! (case sensitive)");
			}
		} while (!u.equalTo("turtle neck", "crew neck", collarType));
		
		do {
			u.printNormal("Input shirt fabric pattern (\"polka dot\" / \"checkered\" / \"strip\" (case insensitive)): ");
			fabricPattern = u.nextLine();
			if(!u.equalToIgnoreCase("polka dot", "checkered", "strip", fabricPattern)) {
				u.printTab("Shirt fabric pattern  has to be \"polka dot\" / \"checkered\" / \"strip\"! (case insensitive)");
			}
		} while (!u.equalToIgnoreCase("polka dot", "checkered", "strip", fabricPattern));
		
		pc.refreshID();
		Shirt shirt = new Shirt("S"+pc.productID, name, price, description, size, color, material, sleeveLength, collarType, fabricPattern);
		pc.addProduct(shirt);
		productAdded();
	}
	
	public void addNovel() {
		String author;
		String genre;
		String publicationYear;
		int py =  -9;
		String crimeType;
		String detective;
		int suspenseLevel = -9;
		
		addProducts();
		
		do {
			u.printNormal("Input author name (starts with \"Mr. \" / \"Mrs. \" (case sensitive)): ");
			author = u.nextLine();
			if(!u.StartsWith("Mr. ", "Mrs. ", author)) {
				u.printTab("Author name must starts with \"Mr. \" / \"Mrs. \" (case sensitive)!");
			}
		} while (!u.StartsWith("Mr. ", "Mrs. ", author));
		
		do {
			u.printNormal("Input novel genre (\"horror\" / \"thriller\" / \"mystery\" (case insensitive)): ");
			genre = u.nextLine();
			if(!u.equalToIgnoreCase("horror", "thriller", "mystery", genre)) {
				u.printTab("Genre name must be \"horror\" / \"thriller\" / \"mystery\" (case insensitive)");
			}
		} while (!u.equalToIgnoreCase("horror", "thriller", "mystery", genre));
		
		do {
			u.printNormal("Input novel publication year (novel publication year 2005-2020): ");
			publicationYear = u.nextLine();
			if(u.isInteger(publicationYear)) {
				py = Integer.parseInt(publicationYear);
				if(!u.gtAndlt(2005, 2020, py)) {
					u.printTab("Novel publication year has to be greater than 2005 and less than 2020!");
				}
			}else {
				u.printTab("Please input an integer!");
			}
		} while (!u.gtAndlt(2005, 2020, py));
		
		do {
			u.printNormal("Input novel crime type (\"murder\" / \"heist\" / \"genocide\" (case insensitive)): ");
			crimeType = u.nextLine();
			if(!u.equalToIgnoreCase("murder", "heist", "genocide", crimeType)) {
				u.printTab("Novel crime type must be \"murder\" / \"heist\" / \"genocide\"");
			}
		} while (!u.equalToIgnoreCase("murder", "heist", "genocide", crimeType));
		
		do {
			u.printNormal("Input detective name (starts with \"Mr. \" / \"Mrs. \" (case insensitive)): ");
			detective = u.nextLine();
			if(!u.StartsWithIgnoreCase("Mr. ", "Mrs. ", detective)) {
				u.printTab("Detective name must starts with \"Mr. \" / \"Mrs. \" (case sensitive)!");
			}
		} while (!u.StartsWithIgnoreCase("Mr. ", "Mrs. ", detective));
		do {
			u.printNormal("Input suspense level (Suspense level 5-10): ");
			String tst = Integer.toString(u.nextInt());
			Integer tst2 = Integer.parseInt(tst);
			u.nextLine();
			if(!u.gtAndlt(5, 10, tst2)) {
				u.printTab("Suspense level has to be greater than 5 and less than or equal to 10!");
			}
			if(u.gtAndlt(5, 10, tst2) && u.isInteger(tst)) {
				suspenseLevel = tst2;
				break;
			}
			
		} while (true);
		
		pc.refreshID();
		Novel novel = new Novel("N"+pc.productID, name, price, description, author, genre, py, crimeType, detective, suspenseLevel);
		pc.addProduct(novel);
		productAdded();
		
	}

	public Laptop updateLaptopPrompt() {
		
		float screenSize;
		int RAM;
		String processor;
		int warrantyPeriod = -9;
		String wp;
		String operatingSystem;
		
		addProducts();
		do {
			u.printNormal("Input laptop screen size (laptop screen size 12.5-18.5): ");
			screenSize = u.nextFloat();
			u.nextLine();
			if(!u.gtAndlt(12.5f, 18.5f, screenSize)) {
				u.printTab("Laptop screen size has to be greater than or equal to 12.5 and less than or equal to 18.5!");
			}
		} while (!u.gtAndlt(12.5f, 18.5f, screenSize));
		
		do {
			u.printNormal("Input laptop RAM (laptop RAM 4-64): ");
			RAM = u.nextInt();
			u.nextLine();
			if(!u.gtAndlt(4, 64, RAM)) {
				u.printTab("Laptop RAM has to be greater than or equal to 4 and less than or equal to 64!");
			}
		} while (!u.gtAndlt(4, 64, RAM));
		
		do {
			u.printNormal("Input laptop processor (\"ontel\" or \"SLC\" (case sensitive)): ");
			processor = u.nextLine();
			if(!u.equalTo("ontel", "SLC", processor)) {
				u.printTab("Laptop RAM has to be \"ontel\" or \"SLC\"! (case sensitive)");
			}
		} while (!u.equalTo("ontel", "SLC", processor));
		
		do {
			u.printNormal("Input laptop warranty period (laptop warranty period 1-5): ");
			wp =  u.nextLine();
			if(u.isInteger(wp)) {
				warrantyPeriod = Integer.parseInt(wp);
				if(!u.gtAndlt(1, 5, warrantyPeriod)) {
					u.printTab("Laptop warranty period has to be greater than or equal to 1 and less than or equal to 5!");
				}
			}else {
				u.printTab("Please input an integer!");
			}
		} while (!u.gtAndlt(1, 5, warrantyPeriod));
		
		do {
			u.printNormal("Input laptop operating system (\"penguin\" / \"jendela\" (case insensitive)): ");
			operatingSystem = u.nextLine();
			if(!u.equalToIgnoreCase("penguin", "jendela", operatingSystem)) {
				u.printTab("Laptop operating system has to be \"penguin\" or \"jendela\"! (case insensitive)");
			}
		} while (!u.equalToIgnoreCase("penguin", "jendela", operatingSystem));
		
		Laptop laptop = new Laptop("0", name, price, description, screenSize, RAM, processor, warrantyPeriod, operatingSystem);
	
		return laptop;
	}
	
	public Shirt updateShirtPrompt() {
		String color;
		String size;
		String material;
		String sleeveLength;
		String collarType;
		String fabricPattern;
		
		addProducts(); 
		
		do {
			u.printNormal("Input shirt color (\"black\" / \"white\" / \"pink\" (case sensitive)): ");
			color = u.nextLine();
			if(!u.equalTo("black", "white", "pink", color)) {
				u.printTab("Shirt color has to be \"black\" / \"white\" / \"pink\"! (case sensitive)");
			}
		} while (!u.equalTo("black", "white", "pink", color));
		
		do {
			u.printNormal("Input shirt size (\"s\" / \"m\" / \"l\" (case insensitive)): ");
			size = u.nextLine();
			if(!u.equalToIgnoreCase("s", "m", "l", size)) { 
				u.printTab("Shirt color has to be \"s\" / \"m\" / \"l\"! (case insensitive)");
			}
		} while (!u.equalToIgnoreCase("s", "m", "l", size));
		
		do {
			u.printNormal("Input shirt material (\"cotton\" / \"fleece\" (case sensitive)): ");
			material = u.nextLine();
			if(!u.equalTo("cotton", "fleece", material)) {
				u.printTab("Shirt material has to be \"cotton\" / \"fleece\"! (case sensitive)");
			}
		} while (!u.equalTo("cotton", "fleece", material));
		
		do {
			u.printNormal("Input shirt sleeve length (\"short\" / \"long\" (case insensitive)): ");
			sleeveLength = u.nextLine();
			if(!u.equalToIgnoreCase("short", "long", sleeveLength)) {
				u.printTab("Shirt color has to be \"short\" / \"long\"! (case insensitive)");
			}
		} while (!u.equalToIgnoreCase("short", "long", sleeveLength));
		
		do {
			//bug crew neck
			u.printNormal("Input shirt collar type (\"turtle neck\" / \"crew neck\" (case sensitive)): ");
			collarType = u.nextLine();
			if(!u.equalTo("turtle neck", "crew neck", collarType)) {
				u.printTab("Shirt collar type has to be \"turtle neck\" / \"crew neck\"! (case sensitive)");
			}
		} while (!u.equalTo("turtle neck", "crew neck", collarType));
		
		do {
			u.printNormal("Input shirt fabric pattern (\"polka dot\" / \"checkered\" / \"strip\" (case insensitive)): ");
			fabricPattern = u.nextLine();
			if(!u.equalToIgnoreCase("polka dot", "checkered", "strip", fabricPattern)) {
				u.printTab("Shirt fabric pattern has to be \"polka dot\" / \"checkered\" / \"strip\"! (case insensitive)");
			}
		} while (!u.equalToIgnoreCase("polka dot", "checkered", "strip", fabricPattern));
		
		Shirt shirt = new Shirt("0", name, price, description, size, color, material, sleeveLength, collarType, fabricPattern);
		return shirt;
	}
	
	public Novel updateNovelPrompt() {
		String author;
		String genre;
		String publicationYear;
		String crimeType;
		String detective;
		int suspenseLevel = -9;
		String sp;
		int py =  -9;
		String tst;
		
		addProducts();
		
		do {
			u.printNormal("Input author name (starts with \"Mr. \" / \"Mrs. \" (case sensitive)): ");
			author = u.nextLine();
			if(!u.StartsWith("Mr. ", "Mrs. ", author)) {
				u.printTab("Author name must starts with \"Mr. \" / \"Mrs. \" (case sensitive)!");
			}
		} while (!u.StartsWith("Mr. ", "Mrs. ", author));
		
		do {
			u.printNormal("Input novel genre (\"horror\" / \"thriller\" / \"mystery\" (case insensitive)): ");
			genre = u.nextLine();
			if(!u.equalToIgnoreCase("horror", "thriller", "mystery", genre)) {
				u.printTab("Genre name must be \"horror\" / \"thriller\" / \"mystery\" (case insensitive)");
			}
		} while (!u.equalToIgnoreCase("horror", "thriller", "mystery", genre));
		
		do {
			u.printNormal("Input novel publication year (novel publication year 2005-2020): ");
			publicationYear = u.nextLine();
			if(u.isInteger(publicationYear)) {
				py = Integer.parseInt(publicationYear);
				if(!u.gtAndlt(2005, 2020, py)) {
					u.printTab("Novel publication year has to be greater than 2005 and less than 2020!");
				}
			}else {
				u.printTab("Please input an integer!");
			}
		} while (!u.gtAndlt(2005, 2020, py));
		
		do {
			u.printNormal("Input novel crime type (\"murder\" / \"heist\" / \"genocide\" (case insensitive)): ");
			crimeType = u.nextLine();
			if(!u.equalToIgnoreCase("murder", "heist", "genocide", crimeType)) {
				u.printTab("Novel crime type must be \"murder\" / \"heist\" / \"genocide\"");
			}
		} while (!u.equalToIgnoreCase("murder", "heist", "genocide", crimeType));
		
		do {
			u.printNormal("Input detective name (starts with \"Mr. \" / \"Mrs. \" (case insensitive)): ");
			detective = u.nextLine();
			if(!u.StartsWithIgnoreCase("Mr. ", "Mrs. ", detective)) {
				u.printTab("Detective name must starts with \"Mr. \" / \"Mrs. \" (case sensitive)!");
			}
		} while (!u.StartsWithIgnoreCase("Mr. ", "Mrs. ", detective));
		
		do {
			u.printNormal("Input suspense level (Suspense level 5-10): ");
			tst = Integer.toString(u.nextInt());
			Integer tst2 = Integer.parseInt(tst);
			u.nextLine();
			if(!u.gtAndlt(5, 10, tst2)) {
				u.printTab("Suspense level has to be greater than 5 and less than or equal to 10!");
			}
			if(u.gtAndlt(5, 10, tst2) && u.isInteger(tst)) {
				suspenseLevel = tst2;
				break;
			}
			
		} while (true);
		
		Novel novel = new Novel("0", name, price, description, author, genre, py, crimeType, detective, suspenseLevel);
		return novel;
	}
	
	public void checkOut() {
		String opt = "z";
		while(true) {
			int total = 0;
			u.cls();
			if(Engine.currUser.getCart().isEmpty()) {
				u.printTab("Your cart is currently empty");
				u.pressEnter();
				return;
			}else {
				u.printTab("============================================================+");
				u.printTab("|                          NijiMart                         |");
				u.printTab("+================+===============+===========+==============+");
				u.printTab("|      Name      |    Quantity   |   Price   |     Total    |");
				u.printTab("+================+===============+===========+==============+");
				for (Product p : Engine.currUser.getCart()) {
					int i = 0;
					int q = Engine.currUser.getProductQuantity().get(i++);
					System.out.printf("\t|    %-11s |       %-7d |   %-7d |     $%-8d|\n",p.getName(), q, p.getPrice(), (q*p.getPrice()));
					total += p.getPrice()*q;
				}
				u.printTab("+================+===============+===========+==============+");
				u.printTab("Your total is: "+total+"$");
				u.printNormal("Input \"Y\" to procees and \"N\" to cancel (case insensitive): ");
				opt = u.nextLine();
				if(u.equalToIgnoreCase("y", opt)) {
					uc.checkout();
					uc.rewriteFile(Engine.users);
					u.pressEnter();	
					break;
				}else if(u.equalToIgnoreCase("n", opt)){
					u.pressEnter();		
					break;
//					return;
				}else {
					u.printTab("Please input either \'y\' or \'n\'  (case insensitive)!");
					u.pressEnter();
				}
//				return;
			}
		}
//		do {
//			int total = 0;
//			u.cls();
//			if(Engine.currUser.getCart().isEmpty()) {
//				u.printTab("Your cart is currently empty");
//				u.pressEnter();
//				return;
//			}else {
//				u.printTab("============================================================+");
//				u.printTab("|                          NijiMart                         |");
//				u.printTab("+================+===============+===========+==============+");
//				u.printTab("|      Name      |    Quantity   |   Price   |     Total    |");
//				u.printTab("+================+===============+===========+==============+");
//				for (Product p : Engine.currUser.getCart()) {
//					int i = 0;
//					int q = Engine.currUser.getProductQuantity().get(i++);
//					System.out.printf("\t|    %-11s |       %-7d |   %-7d |     $%-8d|\n",p.getName(), q, p.getPrice(), (q*p.getPrice()));
//					total += p.getPrice()*q;
//				}
//				u.printTab("+================+===============+===========+==============+");
//				u.printTab("Your total is: "+total+"$");
//				u.printNormal("Input \"Y\" to procees and \"N\" to cancel (case insensitive): ");
//				opt = u.nextLine();
//				if(u.equalToIgnoreCase("y", opt)) {
//					uc.checkout();
//					uc.rewriteFile(Engine.users);
//					u.pressEnter();					
//				}else {
//					u.pressEnter();					
//					return;
//				}
//				return;
//			}
//			
//		} while (!opt.equalsIgnoreCase("y") || !opt.equalsIgnoreCase("n"));
	}
	
	public void viewCart() {
		String opt = "z";
		int total = 0;
		u.cls();
		if(Engine.currUser.getCart().isEmpty()) {
			u.printTab("Your cart is currently empty");
			u.pressEnter();
			return;
		}else {
			int i = 0;
			u.printTab("============================================================+");
			u.printTab("|                          NijiMart                         |");
			u.printTab("+================+===============+===========+==============+");
			u.printTab("|      Name      |    Quantity   |   Price   |     Total    |");
			u.printTab("+================+===============+===========+==============+");
			for (Product p : Engine.currUser.getCart()) {
				int q = Engine.currUser.getProductQuantity().get(i++);
				System.out.printf("\t|    %-11s |       %-7d |   %-7d |     $%-8d|\n",p.getName(), q, p.getPrice(), (q*p.getPrice()));
				total += p.getPrice()*q;
			}
			u.printTab("+================+===============+===========+==============+");
			u.printTab("Your total is: "+total+"$");
			u.pressEnter();
			return;
		}
	}

}