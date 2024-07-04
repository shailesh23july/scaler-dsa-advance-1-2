package com.scaler.prime.numbers;

import java.util.ArrayList;

public class PrimeSum {

	public static void main(String[] args) {
		int A = 4;
		int[] primesum = primesum(A);
		System.out.println(primesum[0] + " " + primesum[1]);

	}
	public static int[] primesum(int A) {
	  int[] ans = new int[2];
	  ArrayList<Integer> allPrimes = getAllPrimes(A);
	  for (int i = 0; i < allPrimes.size(); i++) {
		  for (int j = i; j < allPrimes.size(); j++) {
			  if (allPrimes.get(i) + allPrimes.get(j) == A) {
				  ans[0] = allPrimes.get(i);
				  ans[1] = allPrimes.get(j);
				  return ans;
			  }
		  }
	  }
	  return ans;
    }
	
	public static ArrayList<Integer> getAllPrimes(int N) {
		boolean[] primes = new boolean[N + 1];
		ArrayList<Integer> allPrimes = new ArrayList<Integer>();
		for (int i = 0; i <= N; i++) {
			primes[i] = true;
		}
		for (int i = 2; i * i <= N; i++) {
			if (primes[i] == true) {
				for (int j = i; j * i <= N; j++) {
					primes[i * j] = false;
				}
			}
		}
		for (int i = 2; i < primes.length; i++) {
			if (primes[i] == true) {
				allPrimes.add(i);
			}
		}
		return allPrimes;
	}
	

}
