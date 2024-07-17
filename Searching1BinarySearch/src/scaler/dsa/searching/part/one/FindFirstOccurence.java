package scaler.dsa.searching.part.one;
/*
Given a sorted array of N elements find the first occurence index of given element k; 
arr = {-5,-5,-3,0,0,1,1,5,5,5,5,5,8,10,10}  
*/

public class FindFirstOccurence {

	public static void main(String[] args) {
	int[] arr = {-5,-5,-3,0,0,1,1,5,5,5,5,5,8,10,10};
	int k = 5;
	int ans = solve(arr, k);
	System.out.println(ans);
}
	
	public static int solve(int[] arr, int k) {
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
}
