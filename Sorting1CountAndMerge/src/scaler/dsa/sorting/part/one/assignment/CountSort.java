package scaler.dsa.sorting.part.one.assignment;
/*
Problem Description
Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.


Problem Constraints
1 <= |A| <= 105
1 <= A[i] <= 105


Input Format
The first argument is an integer array A.


Output Format
Return an integer array that is the sorted array A.


Example Input
Input 1:
A = [1, 3, 1]
Input 2:
A = [4, 2, 1, 3]


Example Output
Output 1:
[1, 1, 3]
Output 2:
[1, 2, 3, 4]


Example Explanation
For Input 1:
The array in sorted order is [1, 1, 3].
For Input 2:
The array in sorted order is [1, 2, 3, 4]. 
*/

public class CountSort {

	public static void main(String[] args) {
		//int[] A = {1, 3, 1};
		int[] A = {4, 2, 1, 3};
		int[] ans = solve(A);
		for (int i = 0; i < A.length; i++) {
			System.out.print(ans[i]+ " ");
		}

	}
	
	public static int[] solve(int[] A) {
		int k = 0;
		int max = max(A);
		int[] ans = new int[A.length];
		int[] fre_arr = new int[max+1];
		for (int i = 0; i < A.length; i++) {
			fre_arr[A[i]]++;
		}
		for (int i = 0; i < fre_arr.length; i++) {
			if (fre_arr[i] > 0) {
				while (fre_arr[i] > 0) {
					ans[k++] = i;
					fre_arr[i]--;
				}
			}
		}
		return ans;
    }
	
	public static int max(int[] A) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			max = A[i] > max ? A[i] : max;
		}
		return max;
	}

}
