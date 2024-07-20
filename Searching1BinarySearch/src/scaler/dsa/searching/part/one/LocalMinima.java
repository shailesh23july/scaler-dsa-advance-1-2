package scaler.dsa.searching.part.one;
/*
Given an array of distinct elements, find any local minima in the array. 
Note: Local minima is a number which is smaller than its adjacent neighbours.
arr = {3,6,1,0,9,15,8}
arr = {21,20, 19,17,15,9,7}
arr=  {5,9,15,16,20,21}
*/

public class LocalMinima {

	public static void main(String[] args) {
		//int[] arr = {3,6,1,0,9,15,8};
		//int[] arr = {5,9,15,16,20,21};
		int[] arr = {21,20, 19,17,15,9,7};
		int ans = solve(arr);
        System.out.println(ans);
	}
	
	public static int solve(int[] arr) {
		int low = 0;
		int high = arr.length -1;
		while (low <= high) {
			int mid = low + ((high-low)/2);
			//case 1
			if ((mid > 0 && arr[mid] < arr[mid -1]) && (mid < arr.length-1 && arr[mid] < arr[mid+1])) {
				return mid;
			}else if ((mid > 0 && arr[mid] < arr[mid -1]) && (mid < arr.length-1 && arr[mid] > arr[mid + 1])) {
				low = mid + 1;
			} else if ((mid > 0 && arr[mid] > arr[mid - 1]) && (mid < arr.length-1 && arr[mid] < arr[mid + 1])){
				high = mid - 1;
			}else {
				high = mid - 1;
			}
		}
		if (arr.length > 1 && arr[0] < arr[1]) {
			return  0;
		}
		if (arr.length > 1 && arr[arr.length - 1] < arr[arr.length - 2]) {
			return  arr.length - 1;
		}
		if (arr.length == 1) {
			return  0;
		}
		return -1;
	}

}
