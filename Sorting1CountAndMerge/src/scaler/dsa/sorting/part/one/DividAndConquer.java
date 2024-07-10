package scaler.dsa.sorting.part.one;
/*
Merge Sort
 */

public class DividAndConquer {
	
	public static void main(String[] args) {
		int[] A = {2,17,6,3,10,1,15,5,18};
		int[] divideConquer = divideConquer(A);
	}
	
	public static int[] divideConquer(int[] arr) {
		//Base Case
		if (arr.length == 1) {
		  return arr;
		}
       
		int[] A = new int[arr.length/2];
		int[] B = new int[arr.length - A.length];
		for (int i = 0; i < A.length; i++) {
			A[i] = arr[i];
		}
		int k = 0;
		for (int i = A.length; i < arr.length; i++) {
			B[k++] = arr[i];
		}
		 A = divideConquer(A);
		 B =divideConquer(B);
		 return MergeSort.mergeSort(A, B);
	}
}
