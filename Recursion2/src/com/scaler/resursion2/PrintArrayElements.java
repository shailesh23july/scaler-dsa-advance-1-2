package com.scaler.resursion2;

public class PrintArrayElements {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int N = arr.length - 1;
		printArr(arr, N);
	}
	
	public static void printArr(int[] arr, int N) {
		//Base Case
		if (N == 0) {
			System.out.print(arr[N] + " ");
			return;
		}
		//Recurrence Relation 
		printArr(arr, N - 1);
		System.out.print(arr[N] + " ");
	}

}
