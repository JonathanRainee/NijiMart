package model;

import java.util.ArrayList;

public class Regular extends User{

	private int loyaltyPoint;

	public int getLoyaltyPoint() {
		return loyaltyPoint;
	}

	public void setLoyaltyPoint(int loyaltyPoint) {
		this.loyaltyPoint = loyaltyPoint;
	}
	
	public Regular(String username, String password, int point, ArrayList<Product> cart, int loyaltyPoint) {
		super(username, password, point, cart);
		this.loyaltyPoint = loyaltyPoint;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getCurrPoint() {
		// TODO Auto-generated method stub
		super.getCurrPoint();
	}

}
