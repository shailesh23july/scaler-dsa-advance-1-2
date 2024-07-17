package scaler.dsa.searching.part.one.assignent;
/*
Problem Description

You are given a sorted array A of size N and a target value B.
Your task is to find the index (0-based indexing) of the target value in the array.

If the target value is present, return its index.
If the target value is not found, return the index of least element greater than equal to B.
If the target value is not found and least number greater than equal to target is also not present, return the length of array (i.e. the position where target can be placed)
Your solution should have a time complexity of O(log(N)).


Problem Constraints

1 <= N <= 105
1 <= A[i] <= 105
1 <= B <= 105



Input Format

The first argument is an integer array A of size N.
The second argument is an integer B.



Output Format

Return an integer denoting the index of target value.



Example Input

Input 1:

A = [1, 3, 5, 6]
B = 5 
Input 2:

A = [1, 4, 9]
B = 3


Example Output

Output 1:

2 
Output 2:

1


Example Explanation

Explanation 1:

The target value is present at index 2. 
Explanation 2:

The target value should be inserted at index 1.
*/

public class SortedInsertPosition {

	public static void main(String[] args) {
		//int[] arr = {1, 4, 9};
		int[] arr = {141, 144, 145, 154, 229, 235, 243, 266, 344, 351, 466, 499, 512, 565, 641, 675, 690, 726, 805, 879, 978, 986 };
		int k = 3;
        System.out.println(solve(arr, k));
	}
	
	public static int solve(int[] arr, int k) {
		int low = 0;
		int high = arr.length - 1;
		int ans = arr.length;
		while (low <= high) {
			int mid = low + ((high - low)/2);
			if (arr[mid] == k) {
				return mid;
			}else if (arr[mid] > k) {
				high = mid - 1;
				ans = mid;
			} else {
				low = mid + 1;
				//ans = low;
			}
		}
		return ans;
	}

}
