package com.scaler.prime.numbers;

import java.util.HashMap;
import java.util.Set;

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
public class CountOfDivisors {

	public static void main(String[] args) {
		int[] A = {8, 9, 10};
		int[] solve = solve(A);
		for (int i = 0; i < solve.length; i++) {
			System.out.println(solve[i]);
		}

	}
	
	public static int[] solve(int[] A) {
		int[] spf = smallestPrimeFactor(A);
		int[] ans = new int[A.length];
	    for (int i = 0; i < A.length; i++) {
	    	int count = 1;
	    	int N = A[i];
	    	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	    	while (N > 1) {
	    		hm.put(spf[N], hm.getOrDefault(spf[N], 0) + 1);
	    		N = N / spf[N];
	    	}
	    	Set<Integer> keySet = hm.keySet();
	    	for (int key : keySet) {
	    		count *= (hm.get(key) + 1);
	    	}
	    	ans[i] = count;
	    }
	    return ans;
    }
	
	public static int[] smallestPrimeFactor(int[] A) {
		int max = findMaxElement(A);
		int[] spf = new int[max + 1];
		for (int i = 0; i < spf.length; i++) {
			spf[i] = i;
		}
		for (int i = 2; i * i <= max; i++) {
			if (spf[i] == i) {
				for (int j = i; j * i <= max; j++) {
					if (spf[i * j] > i) {
						spf[i * j] = i;
					}
				}
			}
		}
		return spf;
	}
	
	public static int findMaxElement(int[] A) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			if (max < A[i]) {
				max = A[i];
			}
		}
		return max;
	}

}
