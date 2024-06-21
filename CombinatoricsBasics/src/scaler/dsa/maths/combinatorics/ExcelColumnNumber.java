package scaler.dsa.maths.combinatorics;

import javax.sound.sampled.ReverbType;

public class ExcelColumnNumber {
/*	
	Problem Description
	Given a column title as appears in an Excel sheet, return its corresponding column number.

	Problem Constraints
	1 <= length of the column title <= 5

	Input Format
	The only argument is a string that represents the column title in the excel sheet.

	Output Format
	Return a single integer that represents the corresponding column number.

	Example Input
	Input 1:

	 AB
	Input 2:
	 BB
	Example Output
	Output 1:
	 28
	Output 2:
	 54
	Example Explanation
	Explanation 1:
	 A -> 1
	 B -> 2
	 C -> 3
	 ...
	 Z -> 26
	 AA -> 27
	 AB -> 28
	Explanation 2:
	 A -> 1
	 B -> 2
	 C -> 3
	 ...
	 Z -> 26
	 AA -> 27
	 AB -> 28
	 ...
	 AZ -> 52
	 BA -> 53
	 BB -> 54
*/
	public static void main(String[] args) {
		String A = "AB";
		int titleToNumber = titleToNumber(A);
		System.out.println(titleToNumber);

	}
	
	public static int titleToNumber(String A) {
		String rev = reverse(A);
		int n = A.length();
		int ans = 0;
		int pow = 1;
		if (n == 1) {
			return A.charAt(0) - 64;
		}
		for (int i = 0; i < n; i++) {
			pow = (int) Math.pow(26, i);
			int cur = rev.charAt(i) - 64;
			ans += (cur * pow);
		}
		return ans;
	}

	 public static String reverse (String A) {
		String reverse = "";
		int j = A.length() -1;
		while (j >= 0      ) {
			reverse = reverse + A.charAt(j);
			j--;
		}
		return reverse;		
	 }
	 

}
