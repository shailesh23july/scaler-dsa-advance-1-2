package scaler.dsa.searching.part.three;
/*
Problem Description
Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.



Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the maximum value of K (sub array length).



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = 10
Input 2:

A = [5, 17, 100, 11]
B = 130


Example Output
Output 1:

 2
Output 2:

 3


Example Explanation
Explanation 1:

For K = 5, There are subarrays [1, 2, 3, 4, 5] which has a sum > B
For K = 4, There are subarrays [1, 2, 3, 4], [2, 3, 4, 5] which has a sum > B
For K = 3, There is a subarray [3, 4, 5] which has a sum > B
For K = 2, There were no subarray which has a sum > B.
Constraints are satisfied for maximal value of 2.
Explanation 2:

For K = 4, There are subarrays [5, 17, 100, 11] which has a sum > B
For K = 3, There were no subarray which has a sum > B.
Constraints are satisfied for maximal value of 3. 
*/

public class SpecialInteger {

	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 5};
		int B = 10;
		//int[] A = {5, 17, 100, 11};
		//int B = 130;
		int ans = subArraySum(A, B);
		System.out.println(ans);
	}
	
	public static int subArraySum(int[] A, int B) {
		int h = A.length;
		int l = 0;
		int ans = -1;
		while (l <= h) {
			int m = l + (h-l)/2;
			if (checkSubArraySum2(A, m, B)) {
				l = m + 1;
				ans = ans > m ? ans : m;
			} else {
				h = m - 1; 
			}
		}
		return ans;
	}
	/*
	 * private static boolean checkSubArraySum(int[] A, int m, int B) { for (int i =
	 * 0; i <= A.length - m; i++) { int sum = 0; for (int j = i; j < i + m;j++) {
	 * sum += A[j]; if (sum > B) { return false; } } } return true; }
	 */
	
	private static boolean checkSubArraySum2(int[] A, int m, int B) {
		long[] PF = new long[A.length];
		PF[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			PF[i] = PF[i-1] + A[i];
		}
		for (int i = 0; i <= A.length - m; i++) {
			long sum = 0;
			int s = i;
			int e = i + m - 1;
			if (s == 0) {
				sum = PF[e];
			} else {
				sum = PF[e] - PF[s-1];
			}
			if (sum > B) {
				return false;
			}
		}
		return true;
	}

}
