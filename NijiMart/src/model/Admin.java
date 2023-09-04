package model;

import java.util.ArrayList;

public class Admin extends User{

	public Admin(String username, String password, ArrayList<Product> cart) {
		super(username, password, cart);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getCurrPoint() {
		// TODO Auto-generated method stub
		super.getCurrPoint();
	}

}
