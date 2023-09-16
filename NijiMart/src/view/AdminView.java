package view;

import controller.UserController;
import main.Engine;
import model.Product;
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
			u.printTab("5. Add Product to Cart");
			u.printTab("6. Your Cart");
			u.printTab("7. Checkout");
			u.printTab("8. Logout");
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
					pv.updateProduct();
					break;
				case 4:
					pv.deleteProduct();
					break;
				case 5:
					pv.addProductToCart();
					break;
				case 6:
					pv.checkOut();
					break;
				case 7:
					pv.viewCart();
					break;
				case 8:					
					uc.logout();
					break;
				}
		} while (menuOpt != 8);
	}
}
