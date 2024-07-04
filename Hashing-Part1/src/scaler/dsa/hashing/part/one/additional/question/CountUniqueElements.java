package scaler.dsa.hashing.part.one.additional.question;

import java.util.HashMap;
import java.util.HashSet;

/*
Problem Description
You are given an array A of N integers. Return the count of elements with frequncy 1 in the given array.


Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109


Input Format
First argument A is an array of integers.


Output Format
Return an integer.


Example Input
Input 1:
A = [3, 4, 3, 6, 6]
Input 2:
A = [3, 3, 3, 9, 0, 1, 0]


Example Output
Output 1:
1
Output 2:
2

 */

public class CountUniqueElements {

	public static void main(String[] args) {
		int[] A = {3, 3, 3, 9, 0, 1, 0};
		System.out.println(solve(A));

	}

	public static int solve(int[] A) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
		}
		for (int i = 0; i < A.length; i++) {
			if (hm.get(A[i]) == 1) {
				count++;
			}
		}
		return count;
	}
}
