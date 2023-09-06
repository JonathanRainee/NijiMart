package view;

import java.util.ArrayList;

import controller.UserController;
import model.Product;
import model.User;
import util.Util;

public class Engine {
	
	Util u = Util.getInstance();
	UserController uc = UserController.getInstance();
	UserView uv = UserView.getInstance();
	public static User currUser = null;
	public static ArrayList<User> users = new ArrayList<>();
	public static ArrayList<Product> producst = new ArrayList<>();

	public Engine() {
		// TODO Auto-generated constructor stub
		int opt = -9;
		do {
			uc.initUser();
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
