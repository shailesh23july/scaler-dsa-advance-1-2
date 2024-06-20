package scaler.dsa.maths.combinatorics;

public class PascalTriangle {
	/*
	Problem Description

	Write a program to print the pascal triangle up to A rows.

	Problem Constraints

	1 <= A <= 25

	Input Format

	The first argument is an integer A.

	Output Format

	Return a 2D array consisting of A rows whose each row contains A integers.

	Example Input
	Input 1:
	A = 3
	Input 2:
	A = 5
	Example Output
	Output 1:
	1 0 0 
	1 1 0 
	1 2 1 
	Output 2:
	1 0 0 0 0
	1 1 0 0 0
	1 2 1 0 0
	1 3 3 1 0
	1 4 6 4 1 
	Example Explanation
	Explanation 1:
	Row 1 = 1 0 0 
	Row 2 = 1C0 1C1 0 = 1 1 0
	Row 3 = 2C0 2C1 2C2 = 1 2 1
	*/

	public static void main(String[] args) {
		int A = 5;
		int[][] solve = solve(A);
		for (int i = 0; i < solve.length; i ++) {
			for (int j = 0; j < solve[0].length; j++) {
				System.out.print(solve[i][j] + " ");
			}
			System.out.print("\n");
		}

	}
	
	public static int[][] solve(int A) {
		int[][] arr = new int[A][A];
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < A; j++) {
				if (j == 0 || i == j) {
					arr[i][j] = 1;
				}else if (j > i) {
					arr[i][j] = 0;
				}
				else {
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			}
		}
		return arr;
    }

}
