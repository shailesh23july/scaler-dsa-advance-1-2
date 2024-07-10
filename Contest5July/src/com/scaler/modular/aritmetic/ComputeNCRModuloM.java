package com.scaler.modular.aritmetic;

import java.math.BigDecimal;

public class ComputeNCRModuloM {

	public static void main(String[] args) {
	BigDecimal num1 = BigDecimal.ONE;
	BigDecimal num2 = null;
	System.out.println(num1.compareTo(num2));

	}
	
	public static int solve (int A, int B, int C) {
		int numerator = factorial(A) % C;
		int denomenator = ((factorial(B) % C) * (factorial(A - B) % C)) % C;
		return  (numerator / denomenator) % C;
		
	}
	
	public static int factorial(int num) {
		//Base condition
		if(num == 1) {
			return 1;
		}
		//recurrence relation
		return num * factorial(num - 1);
	}

}
