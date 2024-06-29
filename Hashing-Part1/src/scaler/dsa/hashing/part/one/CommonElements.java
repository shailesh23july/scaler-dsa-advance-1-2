package scaler.dsa.hashing.part.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
Problem Description
Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.

NOTE:

Each element in the result should appear as many times as it appears in both arrays.
The result can be in any order.


Problem Constraints
1 <= N, M <= 105

1 <= A[i] <= 109



Input Format
First argument is an integer array A of size N.

Second argument is an integer array B of size M.



Output Format
Return an integer array denoting the common elements.



Example Input
Input 1:

 A = [1, 2, 2, 1]
 B = [2, 3, 1, 2]
Input 2:

 A = [2, 1, 4, 10]
 B = [3, 6, 2, 10, 10]


Example Output
Output 1:

 [1, 2, 2]
Output 2:

 [2, 10]


Example Explanation
Explanation 1:

Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
Explantion 2:

 Elements (2, 10) appears in both the array.
 */

public class CommonElements {

	public static void main(String[] args) {
		int[] A = {1, 2, 2, 1};
		int[] B = {2, 3, 1, 2};
		int[] solve = solve(A, B);
		for (int i = 0; i < solve.length; i++) {
		System.out.print(solve[i]);
		 }

	}
	
	 public static int[] solve(int[] A, int[] B) {
		 ArrayList<Integer> ansList = new ArrayList<Integer>();
		 HashMap<Integer, Integer> frq_A = new HashMap<Integer, Integer>();
		 HashMap<Integer, Integer> frq_B = new HashMap<Integer, Integer>();
		 ArrayList<Integer> uniqueElement = new ArrayList<Integer>();
		 for (int i = 0; i < A.length; i++) {
			 int count = frq_A.getOrDefault(A[i], 0) + 1;
			 frq_A.put(A[i], count);
			 if (count == 1) {
				 uniqueElement.add(A[i]); 
			 }
		 }
		 for (int i = 0; i < B.length; i++) {
			 frq_B.put(B[i], frq_B.getOrDefault(B[i], 0) + 1);
		 }
		 for (int i = 0; i < uniqueElement.size(); i++) {
			 if (null != frq_B.get(uniqueElement.get(i))) {
				 int count = frq_B.get(uniqueElement.get(i)) <= frq_A.get(uniqueElement.get(i)) ?  frq_B.get(uniqueElement.get(i)) :  frq_A.get(uniqueElement.get(i));
				 for (int j = 0; j < count; j++) {
					 ansList.add(uniqueElement.get(i));
				 }
			 }
		 }
		 int[] ans = new int[ansList.size()];
		 for (int i = 0; i < ans.length; i++) {
			 ans[i] = ansList.get(i);
		 }
	     return ans;
	  }

	
}
