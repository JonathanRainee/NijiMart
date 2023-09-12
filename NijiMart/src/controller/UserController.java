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
	private ProductController pc = ProductController.getInstance();;
	private Util u = Util.getInstance();
	
	private UserController() {
		// TODO Auto-generated constructor stub
	}

	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
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
				String productQuantity = "-";
				if(!user.getCart().isEmpty()) {
					for (Product p : user.getCart()) {
						itemIDS += p.getProductID();
					}
				}
				if(!user.getProductQuantity().isEmpty()) {
					for (Integer i : user.getProductQuantity()) {
						productQuantity += i;
					}
				}
				writer.write(user.getUsername()+","+user.getPassword()+","+user.getPoint()+","+itemIDS+","+productQuantity+"\n");
			}else if(user instanceof Regular) {
				String itemIDS = "-";
				String productQuantity = "-";
				if(!user.getCart().isEmpty()) {
					for (Product p : user.getCart()) {
						itemIDS += p.getProductID();
					}
				}
				if(!user.getProductQuantity().isEmpty()) {
					for (Integer i : user.getProductQuantity()) {
						productQuantity += i;
					}
				}
				writer.write(user.getUsername()+","+user.getPassword()+","+user.getPoint()+","+itemIDS+","+productQuantity+","+((Regular)user).getLoyaltyPoint()+"\n");
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void writeFile(ArrayList<User> users) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
			for (User u : users) {
				if(u instanceof Admin) {
					String itemIDS = "-";
					String productQuantity = "-";
					if(!u.getCart().isEmpty()) {
						itemIDS = "";
						for (Product p : u.getCart()) {
							itemIDS += p.getProductID();
						}
					}
					if(!u.getProductQuantity().isEmpty()) {
						productQuantity = "";
						for (Integer i : u.getProductQuantity()) {
							productQuantity += i;
						}
					}
					writer.write(u.getUsername()+","+u.getPassword()+","+u.getPoint()+","+itemIDS+","+productQuantity+"\n");
				}else if(u instanceof Regular) {
					String itemIDS = "-";
					String productQuantity = "-";
					if(!u.getCart().isEmpty()) {
						itemIDS = "";
						for (Product p : u.getCart()) {
							itemIDS += p.getProductID();
						}
					}
					if(!u.getProductQuantity().isEmpty()) {
						productQuantity = "";
						for (Integer i : u.getProductQuantity()) {
							productQuantity += i;
						}
					}
					writer.write(u.getUsername()+","+u.getPassword()+","+u.getPoint()+","+itemIDS+","+productQuantity+","+((Regular)u).getLoyaltyPoint()+"\n");
				}
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void writeAllUser(ArrayList<User> users) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
			for (User user : Engine.users) {
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
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void rewriteFile(ArrayList<User> users) {
		for (Integer i : Engine.currUser.getProductQuantity()) {
		}
        
        try {
            // Create a FileWriter with append mode set to false (this will overwrite the file)
            FileWriter writer = new FileWriter(new File(fileName), false);  
            writer.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
			for (User u : users) {
				if(u instanceof Admin) {
					String itemIDS = "-";
					String productQuantity = "-";
					if(!u.getCart().isEmpty()) {
						itemIDS = "";
						for (Product p : u.getCart()) {
							itemIDS += p.getProductID();
						}
					}
					if(!u.getProductQuantity().isEmpty()) {
						productQuantity = "";
						for (Integer i : u.getProductQuantity()) {
							productQuantity += i.toString();
						}
					};
					writer.write(u.getUsername()+","+u.getPassword()+","+u.getPoint()+","+itemIDS+","+productQuantity+"\n");
				}else if(u instanceof Regular) {
					String itemIDS = "-";
					String productQuantity = "-";
					if(!u.getCart().isEmpty()) {
						itemIDS = "";
						for (Product p : u.getCart()) {
							itemIDS += p.getProductID();
						}
					}
					if(!u.getProductQuantity().isEmpty()) {
						productQuantity = "";
						for (Integer i : u.getProductQuantity()) {
							productQuantity += i;
						}
					}
					writer.write(u.getUsername()+","+u.getPassword()+","+u.getPoint()+","+itemIDS+","+productQuantity+","+((Regular)u).getLoyaltyPoint()+"\n");
				}
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void updateFile(ArrayList<User> users) {
		rewriteFile(users);
	}
	
	public void initUser() {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            
            while ((line = br.readLine()) != null) {
            	if (!line.trim().isEmpty()) {
            		ArrayList<Product> p = new ArrayList<>();
            		ArrayList<Integer> q = new ArrayList<>();
            		String[] data = line.split(",");
            		int fieldCount = data.length;
            		String username = data[0].trim();
            		String password = data[1].trim();
            		int point = Integer.parseInt(data[2].trim());
            		String cart = data[3].trim();
            		String productQuantity = data[4].trim();
            		
            		if(fieldCount > 5) {
            			int loyaltyPoint = Integer.parseInt(data[5].trim());
            			if(cart.equals("-")) {
            				Engine.users.add(new Regular(username, password, point, p, q, loyaltyPoint));
                		}else if(!cart.equals("-")){
                			for(int i = 0; i < productQuantity.length(); i++) {
                				q.add((int) productQuantity.charAt(i));
                			}
                			
                			for (int i = 0; i < cart.length(); i += 2) {
                				String id = cart.charAt(i)+cart.charAt(i+1)+"";
								Product prod = pc.searchProduct(id);
								p.add(prod);
							}
                			Engine.users.add(new Regular(username, password, point, p, q, loyaltyPoint));
                		}
            		}else {
            			if(cart.equals("-")) {
            				Engine.users.add(new Admin(username, password, point, p, q));          	
            			}else if(!cart.equals("-")){
            				for (int i = 0; i < cart.length(); i += 2) {
            					String a = Character.toString(cart.charAt(i));
            					String b = Character.toString(cart.charAt(i+1));
            					String id = a+b;
								Product prod = pc.searchProduct(id);
								p.add(prod);
							}
            				
            				for(int i = 0; i < productQuantity.length(); i++) {
                				q.add(Integer.parseInt(Character.toString(productQuantity.charAt(i))));
                			}
            				
            				
            				Engine.users.add(new Admin(username, password, point, p, q)); 
            			}
            		}            		
            	}
            	userCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void logout() {
		Engine.currUser = null;
	}
	
	public void addProductToCart(User u, Product p) {
		Engine.currUser.getCart().add(p) ;
		Engine.currUser.getProductQuantity().add(p.getQuantity());
		rewriteFile(Engine.users);
	}

}
