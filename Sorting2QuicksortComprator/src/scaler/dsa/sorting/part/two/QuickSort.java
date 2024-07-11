package scaler.dsa.sorting.part.two;

import java.util.Random;

/*
QuickSort
*/

public class QuickSort {

	public static void main(String[] args) {
		Random r = new Random();
		int nextInt = r.nextInt(1, 10);
		int[] arr = {54,26,93,17,77,31,44,55,20};
		quickSort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + " ");
		}

	}
	
	public static void quickSort(int[] arr, int start, int end) {
		// BaseCase
		if (start >= end) {
			return;
		}
		int pivot = PivotPartioning.solve(arr, start, end);
		quickSort(arr, start, pivot -1);
		quickSort(arr, pivot + 1, end);
	}

}
