package scaler.dsa.sorting.part.one;
/*
Merge two sorted array.
 */

public class MergeSort {

	public static void main(String[] args) {
		int[] A = {1,5,6,9};
		int[] B = {2,4,8};
		int[] mergeSort = mergeSort(A, B);
		for (int i = 0; i < mergeSort.length; i++) {
			System.out.print(mergeSort[i]);
		}

	}
	
	public static int[] mergeSort(int[] A, int[] B) {
		int[] res = new int[A.length + B.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < A.length && j < B.length) {
			if (A[i] <= B[j]) {
				res[k++] = A[i];
				i++;
			} else {
				res[k++] = B[j];
				j++;
			}
		}
		while (i < A.length) {
			res[k++] = A[i];
			i++;
		}
		while (j < B.length) {
			res[k++] = B[j];
			j++;
		}
		return res;
	}
	

}
