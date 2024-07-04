package scaler.dsa.hashing.part.two;

import java.util.HashMap;

/*
Problem Description
You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.



Problem Constraints
1 <= N <= 106

1 <= A[i] <= 109


Input Format
First argument is an integer array A
Second argument is an integer B.



Output Format
Return an integer array.



Example Input
Input 1:

 A = [1, 2, 1, 3, 4, 3]
 B = 3
Input 2:

 A = [1, 1, 2, 2]
 B = 1


Example Output
Output 1:

 [2, 3, 3, 2]
Output 2:

 [1, 1, 1, 1]


Example Explanation
Explanation 1:

 A=[1, 2, 1, 3, 4, 3] and B = 3
 All windows of size B are
 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]
 So, we return an array [2, 3, 3, 2].
Explanation 2:

 Window size is 1, so the output array is [1, 1, 1, 1].
 */

public class DistinctNumbersInWindow {

	public static void main(String[] args) {
		   int B = 3;
		   int[] A = {1, 2, 1, 3, 4, 3};
		   int[] dNums = dNums(A, B);
		   for (int i = 0; i < dNums.length; i++) {
			   System.out.println(dNums[i]);
 
		   }
		  
	}
	
	
	public static int[] dNums(int[] A, int B) {
		 int[] ans = new int[A.length - B + 1];
		 HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		 for (int i = 0; i < B; i++) {
			 hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
		 }
		 ans[0] = hm.size();
		 for (int i = 1; i <= A.length - B; i++) {
			 int old_ele = A[i-1];
			 int newele = A[i + B -1];
			 hm.put(newele, hm.getOrDefault(newele, 0) + 1);
			 hm.put(old_ele, hm.get(old_ele) - 1);
			 if (hm.get(old_ele) == 0) {
				 hm.remove(old_ele) ;         
			 }
			 ans[i] = hm.size();
		 }
	    return ans;
	 }

}
