package model;

import java.util.ArrayList;

public class User {

	private String username;
	private String password;
	private int point;
	private ArrayList<Product> cart;
	private ArrayList<Integer> productQuantity;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<Product> getCart() {
		return cart;
	}
	public void setCart(ArrayList<Product> cart) {
		this.cart = cart;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	public ArrayList<Integer> getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(ArrayList<Integer> productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	public User() {
		
	}
	
	public User(String username, String password, int point, ArrayList<Product> cart) {
		super();
		this.username = username;
		this.password = password;
		this.point = point;
		this.cart = cart;
	}
	
	public User(String username, String password, int point) {
		super();
		this.username = username;
		this.password = password;
		this.point = point;
	}
	
	public User(String username, String password, int point, ArrayList<Product> cart,
			ArrayList<Integer> productQuantity) {
		super();
		this.username = username;
		this.password = password;
		this.point = point;
		this.cart = cart;
		this.productQuantity = productQuantity;
	}
	public void addProduct() {
		
	}
	
	public void checkout() {
		
	}
	
	public int getProdPoint() {
		return 0;
	}
	
}
