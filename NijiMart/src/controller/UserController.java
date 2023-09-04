package controller;

import util.Util;

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
			u.cls();
			u.printNormal("Input your username (username length has to be greater than 5 and less than 20 characters || press 0 to cancel): ");
			username = u.nextLine();
			if (username.equals("0")) {
				break;
			}
		} while (username.length() < 5 || username.length() > 20);
			
	}
	
	public void login() {
		
	}

}
