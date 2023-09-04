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

	public Regular(String username, String password, ArrayList<Product> cart, int loyaltyPoint) {
		super(username, password, cart);
		this.loyaltyPoint = loyaltyPoint;
	}
	
	@Override
	public void getCurrPoint() {
		// TODO Auto-generated method stub
		super.getCurrPoint();
	}

}
