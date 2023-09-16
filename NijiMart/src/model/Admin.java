package model;

import java.util.ArrayList;

import main.Engine;

public class Admin extends User{
	
	public Admin() {}
	
	public Admin(String username, String password, int point, ArrayList<Product> cart) {
		super(username, password, point, cart);
		// TODO Auto-generated constructor stub
	}
	
	public Admin(String username, String password, int point) {
		super(username, password, point);
		// TODO Auto-generated constructor stub
	}

	public Admin(String username, String password, int point, ArrayList<Product> cart,
			ArrayList<Integer> productQuantity) {
		super(username, password, point, cart, productQuantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getProdPoint() {
		// TODO Auto-generated method stub
		int point = 0;
		for (Product p : Engine.currUser.getCart()) {
			point += p.getPrice() * 0.03;
		}
		return point;
	}
}
