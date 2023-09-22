package view;

import controller.UserController;
import model.User;
import util.Util;

public class RegularView {
	
	private UserController uc = UserController.getInstance();
	private Util u = Util.getInstance();
	private ProductView pv = ProductView.getInstance();
	
	private static RegularView instance;
	
	private RegularView() {
		// TODO Auto-generated constructor stub
	}
	
	public static RegularView getInstance() {
		if(instance == null) {
			instance = new RegularView();
		}
		return instance;
	}

	public void regularMenu(User user) {
		String menuOpt;
		int opt = -9;
		do {
			u.cls();
			u.printTab("Hello, "+user.getUsername());
			u.printTab("=====================");
			u.printTab("1. Add Product to Cart");
			u.printTab("2. Product List");
			u.printTab("3. Your Cart");
			u.printTab("4. Checkout");
			u.printTab("5. Logout");
			u.printNormal(">> ");
			menuOpt = u.nextLine();
			if(u.isInteger(menuOpt)) {
				opt = Integer.parseInt(menuOpt);
				switch (opt) {
					case 1:
						pv.addProductToCart();
						break;
					case 2:
						pv.viewProduct();
						break;
					case 3:
						pv.viewCart();
						break;
					case 4:
						pv.checkOut();
						break;
					case 5:
						uc.logout();
						break;
					}				
			}else {
				u.printTab("Please input an integer!");
				u.nextLine();
			}
		} while (opt != 5);
	}
	
}
