package util;

import java.util.Scanner;

public class Util {
	
	private Util() {
		// TODO Auto-generated constructor stub
	}
	
	private static Util instance;
	Scanner scan = new Scanner(System.in);
	
	public void printTab(String str) {
		System.out.println("\t"+str);
	}
	
	public void printNormal(String str) {
		System.out.print("\t"+str);
	}
	
	public static Util getInstance() {
		if(instance == null) {
			instance = new Util();
		}
		return instance;
	}
	
	public String nextLine() {
		return scan.nextLine();
	}
	
	public Integer nextInt() {
		return scan.nextInt();
	}
	
	public void cls() {
		for (int i = 0; i < 30; i++) {
			System.out.println("\n\n");
		}
	}

}
