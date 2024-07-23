package scaler.dsa.bit.manipulation.one;

public class ToggleBit {

	public static void main(String[] args) {
		int A = 1;
		int B = 2;
		int solve = solve(A, B);
		System.out.println(solve);
	}
	
	public static int solve(int A, int B) {
		return A ^ (1 << B);
	}

}
