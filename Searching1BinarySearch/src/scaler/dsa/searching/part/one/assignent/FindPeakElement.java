package scaler.dsa.searching.part.one.assignent;
/*
Problem Description
Given an array of integers A, find and return the peak element in it.
An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.

NOTE:

It is guaranteed that the array contains only a single peak element.
Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.


Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the peak element.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
Input 2:

A = [5, 17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 100


Example Explanation
Explanation 1:

 5 is the peak.
Explanation 2:

 100 is the peak.
*/

public class FindPeakElement {

	public static void main(String[] args) {
		//int[] arr = {1, 2, 3, 4, 5};
		int[] arr = {5, 17, 100, 11};
		int ans = solve(arr);
		System.out.println(ans);

	}
	
	public static int solve(int[] arr) {
		int ans = -1;
		int l = arr.length;
		int low = 0;
		int high = l - 1;
		while (low <= high) {
			int mid = low + ((high - low)/2);
			if ((mid > 0 && arr[mid] > arr[mid - 1]) && 
				(mid < l - 1 && arr[mid] > arr[mid+1])) {
				return mid;
			}else if (mid < l - 1 && arr[mid] < arr[mid + 1]) {
				low = mid + 1;
			}else if (mid > 0 && arr[mid] < arr[mid - 1]) {
				high = mid - 1;
			}else {
				high = mid - 1;
				ans = mid;
			}
		}
		return ans;
	}

}
