package scaler.dsa.searching.part.one;
/*
Given an increasing decreasing array with distinct elements, find the maximum element.
ex arr = {1,3,5,2}
   arr = {1,3,5,10,15,12,6}
*/

public class MaximumElement {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		int ans = solve(arr);
        System.out.println(ans);
	}
	
	public static int solve(int[] arr) {
		int ans = -1;
		int low = 0;
		int high = arr.length -1;
		while (low <= high) {
			int mid = low + ((high - low)/2);
			if ((mid > 0 && arr[mid] > arr[mid -1]) && (mid < arr.length - 1 && arr[mid] > arr[mid+1])) {
				return mid;
			}else if ( mid < arr.length - 1 && arr[mid] < arr[mid+1]) {
				low = mid + 1;
			}else if (mid > 0 && arr[mid] < arr[mid -1]){
				high = mid - 1;
			}
		}
		if (arr.length == 1) {
			ans = 0;
		}
		return ans;
	}

}
