package view;

import util.Util;

public class Engine {
	
	Util u = Util.getInstance();

	public Engine() {
		// TODO Auto-generated constructor stub
		int opt = -9;
		do {
			u.cls();
			u.printTab("NijiMart");
			u.printTab("========");
			u.printTab("1. Login");
			u.printTab("2. Register");
			u.printTab("3. Exit");
			u.printNormal(">> ");
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
		} while (opt < 1 || opt > 3);
	}

}
