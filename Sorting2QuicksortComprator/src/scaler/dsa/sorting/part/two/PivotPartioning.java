package scaler.dsa.sorting.part.two;
/*
Given an integer array, consider the first element as pivot, rearrange the element such that the element < pivot should be on the left side,
and element > pivot should be on the right side of the pivot.And finally return the index of the pivote.
arr = {54,26,93,17,77,31,44,55,20}
pivot = 54
o/p = {26,17,31,44,20,54,55,97,93}
return 5
*/

public class PivotPartioning {

	public static void main(String[] args) {
		//int[] arr = {54,26,93,17,77,31,44,55,20};
		int[] arr = {1,2,3,4,5};
		int pivotIndex = solve(arr, 0, arr.length - 1);
        System.out.println("Pivot Index " + pivotIndex );
	}
	
	public static int solve(int[] arr, int start, int end) {
		int pivot = start;
		int current = start + 1;
		int right = end;
		while (current <= right) {
			if (arr[pivot] > arr[current]) {
				swap(pivot, current, arr);
				current++;
				pivot++;
			} else {
				swap(current, right, arr);
				right--;
			}
		}
		return pivot;
	}

	private static void swap(int p, int c, int[] arr) {
		int temp = arr[p];
		arr[p] = arr[c];
		arr[c] = temp;
	}

}
