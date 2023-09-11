package main;

import java.util.ArrayList;

import controller.ProductController;
import controller.UserController;
import model.Product;
import model.User;
import util.Util;
import view.UserView;

public class Engine {
	
	Util u = Util.getInstance();
	UserController uc = UserController.getInstance();
	ProductController pc = ProductController.getInstance();
	UserView uv = UserView.getInstance();
	public static User currUser = null;
	public static ArrayList<User> users = new ArrayList<>();
	public static ArrayList<Product> producst = new ArrayList<>();

	public Engine() {
		int opt = -9;
		uc.initUser();
		pc.initProduct();
		do {
			System.out.println(pc.getLastID());
			u.cls();
			u.printTab("NijiMart");
			u.printTab("========");
			u.printTab("1. Login");
			u.printTab("2. Register");
			u.printTab("3. Exit");
			u.printNormal(">> ");
			opt = u.nextInt();
			u.nextLine();
			
			switch (opt) {
			case 1:
				u.cls();
				uv.login();
				break;
			case 2:
				u.cls();
				uv.register();
				break;
			case 3:
	
				break;
			}
		} while (opt != 3);
	}

}
