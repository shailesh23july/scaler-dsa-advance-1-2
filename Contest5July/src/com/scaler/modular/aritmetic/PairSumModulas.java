package com.scaler.modular.aritmetic;

import java.util.HashMap;

/*
 Given an array A on N elements, count pairs (i, j) such that (arr[i] + arr[j]) % m = 0
 
 Optimized approach
 1. Create frequency map of every element modulus.
 2. Iterate from 0 to M-1 and find occurrence of (0),(1, M-1),(2,M-2), (3,M-3)..(M-1, 1) from frequency map.
 3. Increment count by map(i) * map(M-i).
 4. If M is even and i = 0 above formula will be (map(0) * (map(0) -1))/2 or (map(i) * (map(i) - 1))/2
*/

public class PairSumModulas {

	public static void main(String[] args) {
		int[] A = {5,17,100,11};
		int B = 28;
        int solve = solve(A, B);
        System.out.println(solve);
	}
	
	public static int solve(int[] A, int M) {
		long ans = 0;
		long MOD = (1000 * 1000 * 1000) + 7;
		HashMap<Integer, Integer> frq_map = frequencyMap(A, M);
		for (int i = 0; i <= M/2; i++) {
			if (i == 0 || (M % 2 == 0 && i == M / 2)) {
				ans += (long)(frq_map.getOrDefault(i, 0) * (long)(frq_map.getOrDefault(i, 0) - 1)) / 2;
			} else {
				ans += (long)frq_map.getOrDefault(i, 0) * (long)frq_map.getOrDefault(M-i, 0);
			}
		}
		return (int)(ans % MOD);
	}
	
	public static HashMap<Integer, Integer> frequencyMap(int[] A, int M) {
		HashMap<Integer, Integer> frq_map = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			frq_map.put(A[i] % M, frq_map.getOrDefault(A[i] % M, 0) + 1);
		}
		return frq_map;
	}

}
