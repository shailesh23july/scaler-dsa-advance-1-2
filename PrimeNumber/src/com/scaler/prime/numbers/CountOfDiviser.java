package com.scaler.prime.numbers;

import java.util.ArrayList;
import java.util.Arrays;

public class CountOfDiviser {
/*
Problem Description
Given an array of integers A, find and return the count of divisors of each element of the array.
NOTE: The order of the resultant array should be the same as the input array.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 106

Input Format
The only argument given is the integer array A.

Output Format
Return the count of divisors of each element of the array in the form of an array.

Example Input
Input 1:
 A = [2, 3, 4, 5]
Input 2:
A = [8, 9, 10]
Example Output
Output 1:
[2, 2, 3, 2]
Output 1:
[4, 3, 4]
Example Explanation
Explanation 1:
The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
So the count will be [2, 2, 3, 2].
Explanation 2:
The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
So the count will be [4, 3, 4].
*/

	public static void main(String[] args) {
		int[] a = {8, 9, 10};
		int[] solve = solve(a);
		for (int i = 0; i < solve.length; i++) {
			System.out.print(solve[i] + " ");
		}

	}
	
	 public static int[] solve(int[] A) {
		 int[] ans = new int[A.length];
		 int N = max(A);
		 int[] smallestPrimeFactor = smallestPrimeFactor(N);
		 for (int i = 0; i < A.length; i++) {
			 ans[i] = primeFactorization(A[i], smallestPrimeFactor);
		 }
		return ans; 
	 }
	 
		public static int[] smallestPrimeFactor(int N) {
			int spf[] = new int[N + 1];
			for (int i = 0; i <= N; i++) {
				spf[i] = i;
			}
			for (int i = 2; i * i <= N; i++) {
				if (spf[i] == i) {
					for (int j = i; j * i <= N; j++) {
						if (spf[i * j] > i) {
							spf[i * j] = i;
						}
					}
				}
			}
			return spf;
		}
		
		public static int primeFactorization(int A, int[] smallestPrimeFactors) {
			//int count = 1;
			ArrayList<Integer> factor = new ArrayList<Integer>();
			while (A > 1) {
				factor.add(smallestPrimeFactors[A]);
				A = A /smallestPrimeFactors[A];
			}
			return factor.size() + 2;
		}
		
		public static int max(int[] arr) {
			int max = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (max < arr[i]) {
					max = arr[i];
				}
			}
			return max;
		}
}
