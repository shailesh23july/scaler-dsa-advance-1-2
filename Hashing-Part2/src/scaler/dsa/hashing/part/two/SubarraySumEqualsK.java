package scaler.dsa.hashing.part.two;

import java.util.HashMap;

/*
Given an array of integers A and an integer B.
Find the total number of subarrays having sum equals to B.


Problem Constraints
 1 <= length of the array <= 50000
-1000 <= A[i] <= 1000


Input Format
The first argument given is the integer array A.
The second argument given is integer B.


Output Format
Return the total number of subarrays having sum equals to B.


Example Input
Input 1:
A = [1, 0, 1]
B = 1
Input 2:
A = [0, 0, 0]
B = 0


Example Output
Output 1:
4
Output 2:
6


Example Explanation
Explanation 1:
[1], [1, 0], [0, 1] and [1] are four subarrays having sum 1.
Explanation 1:
All the possible subarrays having sum 0.
 */

public class SubarraySumEqualsK {

	public static void main(String[] args) {
		int[] A = {0, 0, 0};
		int B = 0;
        System.out.println(solve(A, B));
	}
	
	public static int solve(int[] A, int B) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int ans = 0;
		int[] PF = new int[A.length];
		PF[0] = A[0];
		if (PF[0] == B) {
			ans++;
		}
		for (int i = 1; i < A.length; i++) {
			PF[i] = PF[i-1] + A[i];
			if (PF[i] == B) {
				ans++;
			}
		}
		for (int i = 0 ; i < PF.length; i++) {
			int co_pair = PF[i] - B;
			if (null != hm.get(co_pair)) {
				ans += hm.get(co_pair);
			}
			hm.put(PF[i], hm.getOrDefault(PF[i], 0) + 1);
		}
		return ans;
    }

}
