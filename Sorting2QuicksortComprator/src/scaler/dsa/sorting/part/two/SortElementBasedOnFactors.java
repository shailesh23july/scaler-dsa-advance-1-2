package scaler.dsa.sorting.part.two;

import java.util.Arrays;

/*
Given an array of integers, sort the data in ascending order of count of factors.
If count of factors are equal, then sort on the basis of their magnitude.
arr =     {9,3,10,6,4}
factors = {3,2, 4,4,3}
o/p =     {3,4,9,6,10}   
*/

public class SortElementBasedOnFactors {

	public static void main(String[] args) {
		Integer[] arr = {9,3,10,6,4};
		ComparFactors comparator = new ComparFactors();
		Arrays.sort(arr, comparator);
		for (Integer i : arr) {
			System.out.print(i + " ");
		}

	}	
}
