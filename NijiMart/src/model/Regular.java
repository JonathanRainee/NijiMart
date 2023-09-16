package model;

import java.util.ArrayList;

import main.Engine;

public class Regular extends User{

	private int loyaltyPoint;

	public int getLoyaltyPoint() {
		return loyaltyPoint;
	}

	public void setLoyaltyPoint(int loyaltyPoint) {
		this.loyaltyPoint = loyaltyPoint;
	}
	
	public Regular() {}
	
	public Regular(String username, String password, int point, ArrayList<Product> cart, int loyaltyPoint) {
		super(username, password, point, cart);
		this.loyaltyPoint = loyaltyPoint;
		// TODO Auto-generated constructor stub
	}
	
	public Regular(String username, String password, int point, int loyaltyPoint) {
		super(username, password, point);
		this.loyaltyPoint = loyaltyPoint;
		// TODO Auto-generated constructor stub
	}

	public Regular(String username, String password, int point, ArrayList<Product> cart,
			ArrayList<Integer> productQuantity, int loyaltyPoint) {
		super(username, password, point, cart, productQuantity);
		this.loyaltyPoint = loyaltyPoint;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getProdPoint() {
		// TODO Auto-generated method stub
		int point = 0;
		for (Product p : Engine.currUser.getCart()) {
			point += p.getPrice() * 0.01;
		}
		return point;
	}
	
	public int genLoyaltyPoint() {
		int point = 0;
		for (Product p : Engine.currUser.getCart()) {
			point += p.getPrice() * 0.02;
		}
		return point;
	}

}
