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
	
	public static int userCount = 0;
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
	
	public void rewriteFile(ArrayList<User> users) {
		try {
			FileWriter writer = new FileWriter(new File(fileName), false);  
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
        	writer.write("username,password,point,cart,quantity,loyaltypoint\n");
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
					writer.append(u.getUsername()+","+u.getPassword()+","+u.getPoint()+","+itemIDS+","+productQuantity+","+((Regular)u).getLoyaltyPoint()+"\n");
				}
			}
			writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void initUser() {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean skipFirstLine = true;
            
            while ((line = br.readLine()) != null) {
            	if (skipFirstLine) {
                    skipFirstLine = false;
                    continue;
                }
            	
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
//								System.out.println("ini id: "+prod.getProductID());
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
            					System.out.println("ini id hhehe: "+id+"hhh");
								Product prod = pc.searchProduct(id);
								if(prod == null) {
									System.out.println("prod null");
								}else {
									System.out.println("prod g null");									
								}

//								System.out.println("ini id: "+prod.getProductID());
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
	
	public void checkout() {
		int point = 0;
		int loyaltyPoint;
		if(Engine.currUser instanceof Admin) {
			Admin adm = new Admin();
			point = adm.getProdPoint();
		}else if(Engine.currUser instanceof Regular) {
			Regular reg = new Regular();
			point = reg.getProdPoint();
			loyaltyPoint = reg.genLoyaltyPoint();
			System.out.println(loyaltyPoint);
			((Regular)Engine.currUser).setLoyaltyPoint(loyaltyPoint);
		}
		Engine.currUser.setPoint(point);
		Engine.currUser.getCart().clear();
		Engine.currUser.getProductQuantity().clear();
	}

}
