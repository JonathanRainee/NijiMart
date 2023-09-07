package controller;

public class ProductController {
	
	private static ProductController instance;
	
	private ProductController() {
		// TODO Auto-generated constructor stub
	}
	
	public static ProductController getInstance() {
		if(instance == null) {
			instance = new ProductController();
		}
		return instance;
	}
	
	

}
