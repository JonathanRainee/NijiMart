package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
		boolean unique;
		do {
			u.printNormal("Input your username (username length has to be greater than 5 and less than 20 characters || press 0 to cancel): ");
			username = u.nextLine();
			if (username.equals("0")) {
				break;
			}
			unique = isUnique(username);
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
		
		if(userCount == 0) {
			Admin adm = new Admin(username, password, 0, cart);
			Engine.users.add(adm);
			writeFile(adm);
		}else {
			Regular reg = new Regular(username, password, 0, cart, 0);
			Engine.users.add(reg);					
			writeFile(reg);
		}
		userCount++;
	}
	
	public void login() {
		u.printTab("Login");
		u.printTab("========");
		String username;
		String password;
		boolean found = false;
		do {
			u.printNormal("Input your username: ");
			username = u.nextLine();
			u.printNormal("Input your password: ");
			password = u.nextLine();
			found = searchUser(username, password);
			if(!found) {
				u.printTab("Please input the right credential!");
			}
		} while (!found);
	}
	
	private boolean searchUser(String username, String password) {
		for (User u : Engine.users) {
			if(username.equals(u.getUsername()) && password.equals(u.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isUnique(String username) {
		for (User u : Engine.users) {
			if(username.equals(u.getUsername())) {
				return true;
			}
		}
		return false;
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
			}else if(user instanceof Regular) {
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
	
	public void initUser() {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            
            while ((line = br.readLine()) != null) {
            	if (!line.trim().isEmpty()) {
            		String[] data = line.split(",");
            		int fieldCount = data.length;
            		String username = data[0].trim();
            		String password = data[1].trim();
            		int point = Integer.parseInt(data[2].trim());
            		String cart = data[3].trim();
            		if(fieldCount > 4) {
            			int loyaltyPoint = Integer.parseInt(data[4].trim());
            			Engine.users.add(new Regular(username, password, point, loyaltyPoint));
            		}else {
            			Engine.users.add(new Admin(username, password, point));          	
            		}            		
            	}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
