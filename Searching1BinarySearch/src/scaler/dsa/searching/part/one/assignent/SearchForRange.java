package scaler.dsa.searching.part.one.assignent;
/*
Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.

Return an array of size 2, such that 
          First element = Left most index of B in A
          Second element = Right most index of B in A.
If B is not found in A, return [-1, -1].

Note : Your algorithm's runtime complexity must be in the order of O(log n).


Problem Constraints
1 <= N <= 106
1 <= A[i], B <= 109


Input Format
The first argument given is the integer array A.
The second argument given is the integer B.


Output Format
Return the left most and right most index (0-based) of B in A as a 2-element array. If B is not found in A, return [-1, -1].


Example Input
Input 1:

 A = [5, 7, 7, 8, 8, 10]
 B = 8
Input 2:

 A = [5, 17, 100, 111]
 B = 3


Example Output
Output 1:

 [3, 4]
Output 2:

 [-1, -1]


Example Explanation
Explanation 1:

 The first occurrence of 8 in A is at index 3.
 The last occurrence of 8 in A is at index 4.
 ans = [3, 4]
Explanation 2:

 There is no occurrence of 3 in the array.
*/

public class SearchForRange {

	public static void main(String[] args) {
		//int[] arr = {-5,-5,-3,0,0,1,1,5,5,5,5,5,8,10,10};
		int[] arr = {5, 7, 7, 8, 8, 10};
		int k = 8;
		int ans0 = firstOccurence(arr, k);
		int ans1 = lastOccurence(arr, k);
		System.out.println(ans0+ " "+ans1);

	}
	
	public static int firstOccurence(int[] arr, int k) {
		int ans = -1;
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + ((high-low)/2);
			if (arr[mid] == k) {
				ans = mid;
				high = mid - 1;
			}else if (arr[mid] > k) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}
	
	public static int lastOccurence(int[] arr, int k) {
		int ans = -1;
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + ((high-low)/2);
			if (arr[mid] == k) {
				ans = mid;
				low = mid + 1;
			}else if (arr[mid] > k) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}


}
