package com.scaler.modular.aritmetic;

public class GCD {

	public static void main(String[] args) {
		int A = 4;
		int B = 2;
		System.out.println(gcd(A, B));

	}
	
	 public static int gcd(int A, int B) {
	        int temp = max(A, B);
	        B = min(A, B);
	        A = temp;
	        if (B == 0) {
	            return A;
	        }
	        return gcd(B, A % B);
	    }

	    public static int max(int a, int b) {
	        return a > b ? a : b;
	    }

	    public static int min(int a, int b) {
	        return a > b ? b : a;
	    }

}
