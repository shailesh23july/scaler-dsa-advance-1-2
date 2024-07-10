package scaler.dsa.sorting.part.one;

import java.util.Arrays;

/*
Given 2 arrays A and B, find the number of pairs such that A[i] > B[j]
ex. A = {7,3,5} B = {2,0,6}
o/p = {(7,2), (7,0),(7,6), (3,2),(3,0),(5,2),(5,0)}
*/

public class FindPair {

	public static void main(String[] args) {
		int[] A = {7,3,5};
		int[] B = {2,0,6};
		int solve = solve(A, B);
        System.out.println(solve);
	}
	
	public static int solve(int[] A, int[] B) {
		int count = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		int i = 0;
		int j = 0;
		while (i < A.length && j < B.length) {
			if (A[i] > B[j]) {
				count += A.length - i;
				j++;
			} else {
				i++;
			}
		}
		return count;
	}

}
