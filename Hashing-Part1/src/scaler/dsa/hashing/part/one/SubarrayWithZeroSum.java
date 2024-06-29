package scaler.dsa.hashing.part.one;

import java.util.HashMap;

/*
Problem Description
Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1, else return 0.



Problem Constraints
1 <= |A| <= 100000

-10^9 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return whether the given array contains a subarray with a sum equal to 0.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [4, -1, 1]


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 No subarray has sum 0.
Explanation 2:

 The subarray [-1, 1] has sum 0.
 */
public class SubarrayWithZeroSum {

	public static void main(String[] args) {
		int[] A = {96,-71,18,66,-39,-32,-16,-83,-11,-92,55,66,93,5,50,-45,66,-28,69,-4,-34,-87,-32,7,-53,33,-12,-94,-80,-71,48,-93,62};
		System.out.println(solve(A));

	}
	
	public static int solve(int[] A) {
		long[] PF = new long[A.length];
		HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
		hm.put(0L, 1);
		PF[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			PF[i] = PF[i - 1] + A[i];
			if (PF[i] == 0) {
				return 1;
			}
		}
		if (null != hm.get(PF[0]) && hm.get(PF[0]) > 0) {
			return 1;
		} else {
			hm.put(PF[0], 1);
		}
		for (int i = 1; i < PF.length; i++) {
			if (null != hm.get(PF[i]) && hm.get(PF[0]) > 0) {
				return 1;
			} else {
				hm.put(PF[i], 1);
			}
		}
	   return 0;  
	  }

}
