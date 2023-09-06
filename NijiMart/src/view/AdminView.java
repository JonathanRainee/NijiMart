package view;

import util.Util;

public class AdminView {
	
	Util u = Util.getInstance();
	private static AdminView instance;

	private AdminView() {
		// TODO Auto-generated constructor stub
	}
	
	public static AdminView getInstance() {
		if(instance == null) {
			instance = new AdminView();
		}
		return instance;
	}
	
	private void addProduct() {
		int opt;
		do {
			u.cls();
			u.printTab("Add Product");
			u.printTab("===========");
			u.printTab("1. Electronics");
			u.printTab("2. Clothing");
			u.printTab("3. Books");
			u.printTab("4. Cancel");
			u.printTab(">> ");
			opt = u.nextInt();
			u.nextLine();
			switch (opt) {
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;
			}
		} while (opt != 4);
	}
	
	private void addElectronics() {
		u.cls();
	}
	
	private void addClothing() {
		u.cls();
		
	}
	
	private void addBooks() {
		u.cls();
		
	}
}
