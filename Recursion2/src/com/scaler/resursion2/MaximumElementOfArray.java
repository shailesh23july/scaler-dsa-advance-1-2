package com.scaler.resursion2;

public class MaximumElementOfArray {

	public static void main(String[] args) {
		int[] arr = {10,2,3,4,};
		int max = Integer.MIN_VALUE;
		int max2 = findMax(arr, arr.length - 1, max);
		System.out.println(max2);

	}
	
	public static int findMax(int[] arr, int N, int max) {
		//Base Case
		if (N == 0) {
			return max > arr[N] ? max : arr[N];
		}
		//Recurrence Relation
		return max(arr[N], findMax(arr, N -1, max));
	}
	
	public static int max(int A, int B) {
		return A > B ? A : B;
	}

}
