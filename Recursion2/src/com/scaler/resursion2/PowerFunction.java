package com.scaler.resursion2;

public class PowerFunction {
/*
 Problem Description
Implement pow(A, B) % C.
In other words, given A, B and C, Find (AB % C).
Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.

Problem Constraints
-109 <= A <= 109
0 <= B <= 109
1 <= C <= 109

Input Format
Given three integers A, B, C.

Output Format
Return an integer.

Example Input
Input 1:
A = 2
B = 3
C = 3
Input 2:
A = 3
B = 3
C = 1

Example Output
Output 1:
2
Output 2:
0

Example Explanation
Explanation 1:
23 % 3 = 8 % 3 = 2
Explanation 2:
33 % 1 = 27 % 1 = 0
 */
	public static void main(String[] args) {
		int A = 2;
		int B = 3;
		int C = 3;
		int ans = pow(A,B,C);
		System.out.println(ans);
	}
	
	public static int pow(int a, int n, int c) {
		if (n == 1) {
			return a;
		}
		int temp = pow(a,n/2,c) % c;
		if (n % 2 == 0) {
			return (temp * temp) % c;
		}
		return (a * temp * temp) % c; 
	}

}
