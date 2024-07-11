package scaler.dsa.sorting.part.one.assignment;
/*
Problem Description
Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
Return the number of important reverse pairs in the given array A.



Problem Constraints
1 <= length of the array <= 105

-2 * 109 <= A[i] <= 2 * 109



Input Format
The only argument given is the integer array A.



Output Format
Return the number of important reverse pairs in the given array A.



Example Input
Input 1:

 A = [1, 3, 2, 3, 1]
Input 2:

 A = [4, 1, 2]


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 There are two pairs which are important reverse pair 
 i.e  (1, 4) => A[1] > 2 * A[4] => 3 > 2 * 1 => 3 > 2 and
      (3, 4) => A[3] > 2 * A[4] => 3 > 2 * 1 => 3 > 2.
Explanation 2:

 There is only one pair 
 i.e (0, 1) => A[0] > 2 * A[1] => 4 > 2 * 1 => 4 > 1

*/

public class ReversePair {
	public static int ans = 0;
	public static void main(String[] args) {
		int[] A = {14046,57239,78362,99387,27609,55100,65536,62099,40820,33056,88380,78549,57512,33137,81212,32365,42276,65368,52459,
				   74924,25355,76044,78056,45190,94365,58869,20611};
		divideConquer(A);
		System.out.println(ans);
		System.out.println(solve1(A));
		
	}
	
	public static int solve1(int[] A) {
		int count = 0;
		for (int i = 0;i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (i < j && A[i] > 2 *A[j]) {
					count++;
				}
			}
		}
		return count;
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
		 B = divideConquer(B);
		 return mergeSort(A, B);
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
				if (A[i] >= 2 * B[j]) {
					ans += A.length - i;
				}
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
