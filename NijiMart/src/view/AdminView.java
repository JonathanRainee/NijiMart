package view;

import controller.UserController;
import model.User;
import util.Util;

public class AdminView {
	
	Util u = Util.getInstance();
	private static AdminView instance;
	ProductView pv = ProductView.getInstance();
	private UserController uc = UserController.getInstance();

	private AdminView() {
		// TODO Auto-generated constructor stub
	}
	
	public static AdminView getInstance() {
		if(instance == null) {
			instance = new AdminView();
		}
		return instance;
	}
	
	public void adminMenu(User user) {
		int menuOpt = -9;
		do {
			u.cls();
			u.printTab("Hello, "+user.getUsername());
			u.printTab("=====================");
			u.printTab("1. Add Product");
			u.printTab("2. Product List");
			u.printTab("3. Update Product");			
			u.printTab("4. Delete Product");
			u.printTab("5. Buy Product");
			u.printTab("5. Logout");
			u.printNormal(">> ");
			menuOpt = u.nextInt();
			u.nextLine();
			switch (menuOpt) {
			case 1:
				pv.addProduct();
				break;
			case 2:
				pv.viewProduct();
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				pv.buyProduct();
				break;
			case 6:					
				uc.logout();
				break;
			}
			
		} while (menuOpt != 5);
	}
	
	public void addProduct() {
		int opt;
		do {
			u.cls();
			u.printTab("Add Product");
			u.printTab("===========");
			u.printTab("1. Electronics");
			u.printTab("2. Clothing");
			u.printTab("3. Books");
			u.printTab("4. Cancel");
			u.printTab(">> ");
			opt = u.nextInt();
			u.nextLine();
			switch (opt) {
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;
			}
		} while (opt != 4);
	}
	
	private void addElectronics() {
		u.cls();
	}
	
	private void addClothing() {
		u.cls();
		
	}
	
	private void addBooks() {
		u.cls();
		
	}
}
