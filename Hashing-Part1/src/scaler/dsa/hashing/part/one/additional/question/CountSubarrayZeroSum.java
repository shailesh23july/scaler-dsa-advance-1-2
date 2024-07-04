package scaler.dsa.hashing.part.one.additional.question;

import java.util.HashMap;

public class CountSubarrayZeroSum {
	/*
Problem Description
Given an array A of N integers.

Find the count of the subarrays in the array which sums to zero. Since the answer can be very large, 
return the remainder on dividing the result with 109+7


Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109


Input Format
Single argument which is an integer array A.


Output Format
Return an integer.


Example Input
Input 1:

 A = [1, -1, -2, 2]
Input 2:

 A = [-1, 2, -1]


Example Output
Output 1:

3
Output 2:

1


Example Explanation
Explanation 1:

 The subarrays with zero sum are [1, -1], [-2, 2] and [1, -1, -2, 2].
Explanation 2:

 The subarray with zero sum is [-1, 2, -1].
*/

	public static void main(String[] args) {
		int[] A = {-1, 2, -1};
		System.out.println(solve(A));
		System.out.println("RAM".equals(null));

	}
	
	public static int solve(int[] A) {
		long MOD = (1000 * 1000 * 1000) + 7;
		long count = 0L;
		long[] PF = new long[A.length];
		HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
		hm.put(0L, 1);
		PF[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			PF[i] = PF[i - 1] + A[i];
		}
		if (null != hm.get(PF[0])) {
			count++;
		} else {
			hm.put(PF[0], 1);
		}
		for (int i = 1; i < PF.length; i++) {
			if (null != hm.get(PF[i])) {
				count++;
			} else {
				hm.put(PF[i], 1);
			}
		}
	   return (int)(count % MOD);  
	  }


}
