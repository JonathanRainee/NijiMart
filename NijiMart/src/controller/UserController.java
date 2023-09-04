package controller;

public class UserController {
	
	private static UserController instance;

	private UserController() {
		// TODO Auto-generated constructor stub
	}
	
	public static UserController getInstance() {
		if(instance == null) {
			instance = new UserController();
		}
		return instance;
	}
	
	public void login() {
		
	}
	
	public void register() {
		
	}

}
