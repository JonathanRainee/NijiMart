package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import main.Engine;
import model.Admin;
import model.Product;
import model.Regular;
import model.User;
import util.Util;

public class UserController {
	
	private int userCount = 0;
	private String fileName = "users.csv";
	private static UserController instance;
	private Util u = Util.getInstance();

	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

	private UserController() {
		// TODO Auto-generated constructor stub
	}
	
	public static UserController getInstance() {
		if(instance == null) {
			instance = new UserController();
		}
		return instance;
	}
	
	public User searchUser(String username, String password) {
		for (User u : Engine.users) {
			if(username.equals(u.getUsername()) && password.equals(u.getPassword())) {
				return u;
			}
		}
		return null;
	}
	
	public boolean isUnique(String username) {
		for (User u : Engine.users) {
			if(username.equals(u.getUsername())) {
				return true;
			}
		}
		return false;
	}
	
	public void writeFile(User user) {
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
	
	public void logout() {
		Engine.currUser = null;
	}

}
