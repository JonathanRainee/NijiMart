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
	
	public float nextFloat() {
		return scan.nextFloat();
	}
	
	public void cls() {
		for (int i = 0; i < 30; i++) {
			System.out.println("\n\n");
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
	
	public boolean equalToIgnoreCase(String a, String b, String c, String value) {
		boolean valid;
		if(!value.equalsIgnoreCase(a) && !value.equalsIgnoreCase(b) && !value.equalsIgnoreCase(c)) {
			return false;
		}else if(value.equalsIgnoreCase(a) || value.equalsIgnoreCase(b) || value.equalsIgnoreCase(c)){
			return true;
		}
		return false;
	}
}
