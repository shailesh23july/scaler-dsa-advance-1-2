package scaler.dsa.searching.part.one;
/*
Given an array where every element occurs twice except for one unique element, find that unique element.
Note: duplicate are adjacent to each other.
arr = {3,3,1,1,8,8,10,10,19,6,6,2,2};
*/

public class FindUniqueElement {

	public static void main(String[] args) {
		int[] arr = { 3, 3, 1, 1, 8, 8, 10, 10, 19, 6, 6, 2, 2 };
		int ans = solve(arr);
		System.out.println(ans);
	}

	public static int solve(int[] arr) {
		int ans = -1;
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + ((high - low) / 2);
			// isUnique
			if ((mid > 0 && arr[mid] != arr[mid - 1]) && (mid < arr.length - 1 && arr[mid] != arr[mid + 1])) {
				ans = mid;
				// Go to first Occurence
			} else if (mid > 0 && arr[mid] == arr[mid - 1]) {
				mid = mid - 1;

			}
			// check if index is even or odd
			if (mid % 2 == 0) { // even Go Right
				low = mid + 2;
			} else {
				high = mid - 1;
			}
		}
		if (arr.length > 1 && arr[0] != arr[1]) {
			ans = 0;
		}
		if (arr.length > 1 && arr[arr.length - 1] != arr[arr.length - 2]) {
			ans = arr.length - 1;
		}
		if (arr.length == 1) {
			ans = 0;
		}
		return ans;
	}

}
