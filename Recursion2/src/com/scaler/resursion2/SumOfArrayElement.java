package com.scaler.resursion2;

public class SumOfArrayElement {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int N = arr.length - 1;
		int sum =sumArrayElement(arr, N);
		System.out.println(sum);

	}
	
	public static int sumArrayElement(int[] arr, int N) {
		//Base case
		if (N == 0) {
			return arr[N];
		}
		//Recurrence Relation 
		return arr[N] + sumArrayElement(arr, N - 1);
	}

}
