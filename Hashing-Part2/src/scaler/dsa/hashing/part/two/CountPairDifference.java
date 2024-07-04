package scaler.dsa.hashing.part.two;
/*
Problem Description
You are given an array A of N integers and an integer B.
Count the number of pairs (i,j) such that A[i] - A[j] = B and i ≠ j.

Since the answer can be very large, return the remainder after dividing the count with 109+7.


Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109
1 <= B <= 109


Input Format
First argument A is an array of integers and second argument B is an integer.


Output Format
Return an integer.


Example Input
Input 1:

A = [3, 5, 1, 2]
B = 4
Input 2:

A = [1, 2, 1, 2]
B = 1


Example Output
Output 1:

1
Output 2:

4


Example Explanation
Example 1:

The only pair is (2, 3) which gives difference as 4
Example 2:

The pair which gives difference as 3 are (2, 1), (4, 1), (2, 3) and (4, 3). 
 */

import java.util.HashMap;

public class CountPairDifference {

	public static void main(String[] args) {
		   int B = 10;
		   int[] A = {18,26,17,30,13,30,20,13};
		   System.out.println(solve(A, B));
	}
	
	public static int solve(int[] A, int B) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int ans = 0;
		for (int i = 0; i < A.length; i++) {
			int co_pair = A[i] - B;
			int co_pair2 = A[i] + B;
			if (null != hm.get(co_pair)) {
				ans +=  hm.get(co_pair);
			}
			if (null != hm.get(co_pair2)) {
				ans +=  hm.get(co_pair2);
			} 
			hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
		}
		return ans;
		
	}

}
