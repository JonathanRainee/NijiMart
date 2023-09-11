package view;

import java.util.ArrayList;

import controller.UserController;
import main.Engine;
import model.Admin;
import model.Product;
import model.Regular;
import model.User;
import util.Util;

public class UserView {
	
	private static UserView instance;
	private ProductView pv = ProductView.getInstance();
	private UserController uc = UserController.getInstance();
	private Util u = Util.getInstance();
	
	private UserView() {
		// TODO Auto-generated constructor stub
	}
	
	public static UserView getInstance() {
		if(instance == null) {
			instance = new UserView();
		}
		return instance;
	}
	
	public void login() {
		String username;
		String password;
		do {
			u.cls();
			u.printTab("Login");
			u.printTab("=====");
			u.printNormal("Input your username (input 0 to go back): ");
			username = u.nextLine();
			if(username.equals("0")) {
				break;
			}
			u.printNormal("Input your password (input 0 to go back): ");
			password = u.nextLine();
			if(password.equals("0")) {
				break;
			}
			Engine.currUser = uc.searchUser(username, password);
			if(Engine.currUser == null) {
				u.printTab("Please input the right credential!");
				u.nextLine();
			}else {
				showMenu(Engine.currUser);
			}
		} while (Engine.currUser == null);
	}
	
	public void register() {
		String username;
		String password;
		boolean unique;
		do {
			u.cls();
			u.printTab("Register");
			u.printTab("========");
			u.printNormal("Input your username (username length has to be greater than 5 and less than 20 characters and must be unique|| press 0 to cancel): ");
			username = u.nextLine();
			if (username.equals("0")) {
				break;
			}
			unique = uc.isUnique(username);
			if(username.length() < 5 || username.length() > 20) {
				u.printTab("Username length has to be greater than 5 and less than 20 characters");
			}
			if(unique) {
				u.printTab("Username must be unique");
			}
		} while (username.length() < 5 || username.length() > 20 || unique);
		
		do {
			u.printNormal("Input your password (password length has to be greater than 8 and less than 20 characters and have to be alphanumeric and have to be unique || press 0 to cancel): ");
			password = u.nextLine();
			if (password.equals("0")) {
				break;
			}
		} while (password.length() < 8 || password.length() > 20 || !u.isAlNum(password));
		
		ArrayList<Product> cart = new ArrayList<>();
		ArrayList<Integer> prodQ = new ArrayList<>();
		System.out.println("user count "+uc.getUserCount());
		if(uc.getUserCount() == 1) {
			System.out.println("buat admin");
			Admin adm = new Admin(username, password, 0, cart, prodQ);
			Engine.users.add(adm);
			uc.writeFile(adm);
		}else if(uc.getUserCount() > 1){
			System.out.println("buat reg");
			Regular reg = new Regular(username, password, 0, cart, prodQ, 0);
			Engine.users.add(reg);					
			uc.writeFile(reg);
		}
		int newUserCount = uc.getUserCount() + 1;
		uc.setUserCount(newUserCount);
	}

	public void showMenu(User user) {
		
		int menuOpt = -9;
		if(user instanceof Regular) {
			u.cls();
			u.printTab("Hello, "+user.getUsername());
			u.printTab("=====================");
			u.printTab("1. Buy Product");
			u.printTab("2. Product List");
			u.printTab("3. Your Cart");
			u.printTab("4. Logout");
			u.printNormal(">> ");
			menuOpt = u.nextInt();
			u.nextLine();
			switch (menuOpt) {
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					uc.logout();
					break;
			}
		}else if(user instanceof Admin) {
			do {
				u.cls();
				u.printTab("Hello, "+user.getUsername());
				u.printTab("=====================");
				u.printTab("1. Add Product");
				u.printTab("2. Product List");
				u.printTab("3. Update Product");			
				u.printTab("4. Delete Product");
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
					uc.logout();
					break;
				}
				
			} while (menuOpt != 5);
		}
	}

}
