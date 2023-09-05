package controller;

import java.util.ArrayList;

import model.Product;
import model.Regular;
import model.User;
import util.Util;
import view.Engine;

public class UserController {
	
	private static UserController instance;
	private Util u = Util.getInstance();

	private UserController() {
		// TODO Auto-generated constructor stub
	}
	
	public static UserController getInstance() {
		if(instance == null) {
			instance = new UserController();
		}
		return instance;
	}
	
	public void register() {
		u.printTab("Login");
		String username;
		String password;
		do {
			u.printNormal("Input your username (username length has to be greater than 5 and less than 20 characters || press 0 to cancel): ");
			username = u.nextLine();
			if (username.equals("0")) {
				break;x
			}
		} while (username.length() < 5 || username.length() > 20);
		
		do {
			u.printNormal("Input your password (password length has to be greater than 8 and less than 20 characters and have to be alphanumeric || press 0 to cancel): ");
			password = u.nextLine();
			if (password.equals("0")) {
				break;
			}
		} while (password.length() < 8 || password.length() > 20 || !u.isAlNum(password));
		
		ArrayList<Product> cart = new ArrayList<>();
		Engine.users.add(new Regular(username, password, cart, 0));		
	}
	
	public void login() {
		
	}

}
