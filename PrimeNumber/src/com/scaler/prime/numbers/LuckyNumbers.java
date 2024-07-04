package com.scaler.prime.numbers;

import java.util.ArrayList;

public class LuckyNumbers {

	public static void main(String[] args) {
		int A = 12;
		int solve = solve(A);
        System.out.println(solve);
	}
	
	 public static int solve(int A) {
		 int count = 0;
		 ArrayList<Integer> primeNumbers = findAllPrimes(A);
		 for (int i = 1; i <= A; i++) {
			 int cur_count = 0;
			 for (int j = 0; j < primeNumbers.size(); j++) {
				 if (i <  primeNumbers.get(j)) {
					 break;
				 }
				 if (i % primeNumbers.get(j) == 0) {
					 cur_count++; 
				 }
			 }
			 if (cur_count == 2) {
				 count++; 
			 }
		 }
		return count; 
	 }
	
	public static ArrayList<Integer> findAllPrimes(int A) {
		boolean[] allPrimes = new boolean[A + 1];
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 0; i <= A; i++) {
			allPrimes[i] = true;
		}
		for (int i = 2; i * i <= A; i++) {
			if (allPrimes[i] == true) {
				for (int j = i; j * i <= A; j++) {
					allPrimes[i * j] = false;
				}
			}
		}
		for (int i = 2; i <= A; i++) {
			if (allPrimes[i] == true) {
				primes.add(i);
			}
		}
		return primes;
	}

}
