package com.scaler.resursion2;

import java.util.ArrayList;

public class FindIndicesOfArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,3,3};
		int B = 3;
		System.out.println(ArrayIndices(arr, arr.length - 1, B));

	}
	
	public static ArrayList<Integer> ArrayIndices(int[] arr, int N, int B) {
		//BaseCase
		if (N < 0) {
			return new ArrayList<Integer>();
		}
		
		//Recurrence Relation
		ArrayList<Integer> indices = ArrayIndices(arr, N - 1, B);
		if (arr[N] == B) {
			indices.add(N);
		}
		return indices;
	}

}
