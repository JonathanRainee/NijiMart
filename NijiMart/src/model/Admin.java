package model;

import java.util.ArrayList;

public class Admin extends User{
	
	public Admin(String username, String password, int point, ArrayList<Product> cart) {
		super(username, password, point, cart);
		// TODO Auto-generated constructor stub
	}
	
	public Admin(String username, String password, int point) {
		super(username, password, point);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getCurrPoint() {
		// TODO Auto-generated method stub
		super.getCurrPoint();
	}

}
