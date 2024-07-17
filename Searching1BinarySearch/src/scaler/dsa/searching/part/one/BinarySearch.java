package scaler.dsa.searching.part.one;
/*
Given a sorted array with distinct elements, return the index of an element k. If k is not present return -1.
arr = {3,6,9,12,14,19,2023,25,27}
*/

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr =  {3,6,9,12,14,19,20,23,25,27};
		int k = 99;
		int ans = solve(arr, k);
        System.out.println(ans);
	}
	
	public static int solve(int[] arr, int k) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + ((high - low)/2);
			if (arr[mid] == k) {
				return mid;
			}else if (arr[mid] > k) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
}
