package scaler.dsa.maths.modular.aritmetic.gcd;

import java.util.HashMap;

/*Problem Description
Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
Since the answer may be large, return the answer modulo (109 + 7).
Note: Ensure to handle integer overflow when performing the calculations.
*/

/*Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 106
*/

/*Input Format
The first argument given is the integer array A.
The second argument given is the integer B.
*/

/*Output Format
Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).
*/

/*Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
 B = 2

Input 2:
 A = [5, 17, 100, 11]
 B = 28
*/

/*Example Output
Output 1:
 4
Output 2:
 1
*/

public class PairSumDivisibleByM {
	
	public static void main(String[] args) {
		int[] A = {5, 17, 100, 11};
		int B = 28;
		int solve = solve(A, B);
		System.out.println(solve);

	}
	
	public static int solve(int[] A, int B) {
        long MOD = (1000 * 1000 * 1000) + 7;
        HashMap<Integer, Integer> hm = new HashMap<>();
        long ans = 0;
        int l = A.length;
        for (int i = 0; i < l; i++) {
            int mod = A[i] % B;
            if (null == hm.get(mod)) {
                hm.put(mod, 1);
            } else {
                hm.put(mod, hm.get(mod) + 1);
            }
        }

        for (int j = 0; j <= B/2; j++) {
            long count = hm.get(j) != null ? hm.get(j) : 0;
            if (j == 0 || (B % 2 == 0 && j == B / 2)) {
               ans += (count * (count - 1)) / 2;
            } else {
               ans += count * (hm.get(B - j) != null ? hm.get(B - j) : 0);
            }
            
        }
        return (int)(ans % MOD);
    }

}
