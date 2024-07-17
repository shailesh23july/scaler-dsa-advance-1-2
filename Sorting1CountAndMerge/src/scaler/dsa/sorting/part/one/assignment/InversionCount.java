package scaler.dsa.sorting.part.one.assignment;
/*
Problem Description
Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. 
Find the total number of inversions of A modulo (109 + 7).



Problem Constraints
1 <= length of the array <= 105

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the number of inversions of A modulo (109 + 7).



Example Input
Input 1:

A = [1, 3, 2]
Input 2:

A = [3, 4, 1, 2]


Example Output
Output 1:

1
Output 2:

4


Example Explanation
Explanation 1:

The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
Explanation 2:

The pair (0, 2) is an inversion as 0 < 2 and A[0] > A[2]
The pair (0, 3) is an inversion as 0 < 3 and A[0] > A[3]
The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
The pair (1, 3) is an inversion as 1 < 3 and A[1] > A[3] 
*/

import scaler.dsa.sorting.part.one.MergeSort;

public class InversionCount {
    public static int ans = 0;
    
	public static void main(String[] args) {
		int[] A = {3, 4, 1, 2};
		divideConquer(A);
		System.out.println(ans);
	}
	
	public static int[] divideConquer(int[] arr) {
		//Base Case
		if (arr.length == 1) {
		  return arr;
		}
       
		int[] A = new int[arr.length/2];
		int[] B = new int[arr.length - A.length];
		for (int i = 0; i < A.length; i++) {
			A[i] = arr[i];
		}
		int k = 0;
		for (int i = A.length; i < arr.length; i++) {
			B[k++] = arr[i];
		}
		 A = divideConquer(A);
		 B = divideConquer(B);
		 return mergeSort(A, B);
	}
	
	public static int[] mergeSort(int[] A, int[] B) {
		int[] res = new int[A.length + B.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < A.length && j < B.length) {
			if (A[i] <= B[j]) {
				res[k++] = A[i];
				i++;
			} else {
				res[k++] = B[j];
				j++;
				ans += A.length - i;
			}
		}
		while (i < A.length) {
			res[k++] = A[i];
			i++;
		}
		while (j < B.length) {
			res[k++] = B[j];
			j++;
		}
		return res;
	}

}
