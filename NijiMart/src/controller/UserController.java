package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Admin;
import model.Product;
import model.Regular;
import model.User;
import util.Util;
import view.Engine;

public class UserController {
	
	private int userCount = 0;
	private String fileName = "users.csv";
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
		u.printTab("Register");
		u.printTab("========");
		String username;
		String password;
		do {
			u.printNormal("Input your username (username length has to be greater than 5 and less than 20 characters || press 0 to cancel): ");
			username = u.nextLine();
			if (username.equals("0")) {
				break;
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
		
		if(userCount == 0) {
			Admin adm = new Admin(username, password, 0, cart);
			Engine.users.add(adm);
			writeFile(adm);
		}else {
			Regular reg = new Regular(username, password, 0, cart, 0);
			Engine.users.add(reg);					
			writeFile(reg);
		}
		
		
	}
	
	private void writeFile(User user) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
			if(user instanceof Admin) {
				String itemIDS = "-";
				if(!user.getCart().isEmpty()) {
					for (Product p : user.getCart()) {
						itemIDS += p.getProductID();
					}
				}
				writer.write(user.getUsername()+","+user.getPassword()+","+user.getPoint()+","+itemIDS+"\n");
			}else {
				String itemIDS = "-";
				if(!user.getCart().isEmpty()) {
					for (Product p : user.getCart()) {
						itemIDS += p.getProductID();
					}
				}
				writer.write(user.getUsername()+","+user.getPassword()+","+user.getPoint()+","+itemIDS+","+((Regular)user).getLoyaltyPoint()+"\n");
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void login() {
		
	}

}
