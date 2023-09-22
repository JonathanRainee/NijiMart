package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Util {
	
	private Util() {
		// TODO Auto-generated constructor stub
	}
	
	private static Util instance;
	public static Scanner scan = new Scanner(System.in);
	
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
		try {
			return scan.nextLine();			
		} catch (Exception e) {
			printTab("Please input a string");
			nextLine();
			cls();
			// TODO: handle exception
		}
		return "";
	}
	
	public Integer nextInt() {
		try {
			int i = scan.nextInt();
//			nextLine();
			return i;
		} catch (Exception e) {
			printTab("Please input an interger!");
//			nextLine();
//			cls();
			// TODO: handle exception
		}
		return 1;
	}
	
	public float nextFloat() {
		try {
			return scan.nextFloat();			
		} catch (Exception e) {
			printTab("Please input a float!");
			// TODO: handle exception
		}
		return 1.0f;
	}
	
	public void cls() {
		for (int i = 0; i < 30; i++) {
			System.out.println("\n\n");
		}
	}
	
	public void clearScreen() {
	    try {
	        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	    } catch (IOException | InterruptedException e) {
	        // Handle exceptions if necessary
	    }
	}
	
	public boolean isAlNum(String pass) {
		if (pass == null || pass.isEmpty()) {
            return false;
        }
        
        for (char c : pass.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
	}
	
	public static boolean checkAlNum(String input) {
        boolean containsNumber = input.matches(".*\\d+.*");
        boolean containsCharacter = input.matches(".*[a-zA-Z]+.*");
        return containsNumber && containsCharacter;
    }
	
	public boolean gtAndlt(int gt, int lt, int num) {
		boolean valid;
		if(num < gt || num > lt) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean gtAndlt(float gt, float lt, float num) {
		boolean valid;
		if(num < gt || num > lt) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean gtAndltOrEq(int gt, int lt, int num) {
		boolean valid;
		if(num <= gt || num >= lt) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean equalTo(String a, String value) {
		boolean valid;
		if(!value.equals(a)) {
			return false;
		}else if(value.equals(a)){
			return true;
		}
		return false;
	}
	
	public boolean equalTo(String a, String b, String value) {
		boolean valid;
		if(!value.equals(a) && !value.equals(b)) {
			return false;
		}else if(value.equals(a) || value.equals(b)){
			return true;
		}
		return false;
	}
	
	public boolean equalTo(String a, String b, String c, String value) {
		boolean valid;
		if(!value.equals(a) && !value.equals(b) && !value.equals(c)) {
			return false;
		}else if(value.equals(a) || value.equals(b) || value.equals(c)){
			return true;
		}
		return false;
	}
	
	public boolean equalToIgnoreCase(String a, String b, String value) {
		boolean valid;
		if(!value.equalsIgnoreCase(a) && !value.equalsIgnoreCase(b)) {
			return false;
		}else if(value.equalsIgnoreCase(a) || value.equalsIgnoreCase(b)){
			return true;
		}
		return false;
	}
	
	public boolean equalToIgnoreCase(String a, String value) {
		boolean  valid;
		if(!value.equalsIgnoreCase(a)) {
			return false;
		}else{
			return true;
		}
	}
	
	public boolean equalToIgnoreCase(String a, String b, String c, String value) {
		boolean valid;
		if(!value.equalsIgnoreCase(a) && !value.equalsIgnoreCase(b) && !value.equalsIgnoreCase(c)) {
			return false;
		}else if(value.equalsIgnoreCase(a) || value.equalsIgnoreCase(b) || value.equalsIgnoreCase(c)){
			return true;
		}
		return false;
	}
	
	public boolean StartsWith(String a, String b, String value) {
		if(!value.startsWith(a) && !value.startsWith(b)) {
			return false;
		}else if(value.startsWith(a) || value.startsWith(b)){
			return true;
		}
		return false;
	}
	
	public boolean StartsWithIgnoreCase(String a, String b, String value) {
		String aNorm = a.toLowerCase().trim();
		String bNorm = b.toLowerCase().trim();
		String valNorm = value.toLowerCase().trim();
		if(!valNorm.startsWith(aNorm) && !valNorm.startsWith(bNorm)) {
			return false;
		}
		if(valNorm.startsWith(aNorm) || valNorm.startsWith(bNorm)){
			return true;
		}
		return false;
	}
	
	public void pressEnter() {
		printTab("Press enter to continue...");
		nextLine();
	}
	
	
	public void createFile() {
		String prodFileName = "products.csv";
		File prodFile = new File(prodFileName);
		String userFileName = "users.csv";
		File userFile = new File(userFileName);
		
		if (prodFile.exists()) {
			return;
		} else {
			try (FileWriter csvWriter = new FileWriter(prodFile)) {
				
			} catch (IOException e) {
				printTab("Error creating empty CSV file: " + e.getMessage());
			}
		}
		
		if (userFile.exists()) {
			return;
		} else {
			try (FileWriter csvWriter = new FileWriter(userFile)) {
				
			} catch (IOException e) {
				printTab("Error creating empty CSV file: " + e.getMessage());
			}
		}
	}
	
	
	public boolean isInteger(String input) {
        try {
        	Integer i = Integer.parseInt(input);
            if(i instanceof Integer) return true;
        } catch (NumberFormatException e) {
            return false;
        }
		return false;
    }
}
