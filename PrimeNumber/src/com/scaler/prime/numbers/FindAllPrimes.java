package com.scaler.prime.numbers;

import java.util.ArrayList;

public class FindAllPrimes {
/*
Problem Description
Given an integer A. Find the list of all prime numbers in the range [1, A].

Problem Constraints
1 <= A <= 106

Input Format
Only argument A is an integer.

Output Format
Return a sorted array of prime number in the range [1, A].

Example Input
Input 1:
A = 7
Input 2:
A = 12

Example Output
Output 1:
[2, 3, 5, 7]
Output 2:
[2, 3, 5, 7, 11]

Example Explanation
For Input 1:
The prime numbers from 1 to 7 are 2, 3, 5 and 7.
For Input 2:
The prime numbers from 1 to 12 are 2, 3, 5, 7 and 11.
*/

	public static void main(String[] args) {
		int A = 12;
		int[] solve = solve(A);
		for (int i = 0; i < solve.length; i++) {
			System.out.println(solve[i]);
		}
		
	}
	
	public static int[] solve(int A) {
		boolean[] primes = new boolean[A + 1];
		for (int i = 0; i <= A; i++) {
			primes[i] = true;
		}
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 2; i <= Math.sqrt(A); i++) {
			if (primes[i] == true) {
				for (int j = i ; j * i <= A; j++) {
					primes[i * j] = false;
				}
			}
		}
		for (int i = 2; i < primes.length; i++) {
			if (primes[i] == true) {
				temp.add(i);
			}
		}
		
		int[] ans = new int[temp.size()];
		for (int i = 0; i < temp.size(); i++) {
			ans[i] = temp.get(i);
		}
		return ans;
    }

}
