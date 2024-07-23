package scaler.dsa.bit.manipulation.one;

public class SubArrayOR {

	public static void main(String[] args) {
		// int[] A = {1, 2, 3, 4, 5};
		int[] A = { 7, 8, 9, 10 };
		System.out.println(solve(A));
	}

	public static int solve(int[] A) {
		long MOD = (1000 * 1000 * 1000) + 7;
		long ans = 0;
		for (int i = 0; i < 32; i++) {
			long cnt_continuous_zero = 0;
			long total_subArray_not_contributing = 0;
			for (int j = 0; j < A.length; j++) {
				if (!isSetBit(A[j], i)) {
					cnt_continuous_zero++;
				} else {
					total_subArray_not_contributing += (cnt_continuous_zero * (cnt_continuous_zero + 1)) / 2;
					cnt_continuous_zero = 0;
				}
				if (j == A.length - 1) {
					total_subArray_not_contributing += (cnt_continuous_zero * (cnt_continuous_zero + 1)) / 2;
				}
			}
			long total_subArray_contributing = (((long)A.length * (A.length + 1)) / 2) - total_subArray_not_contributing;
			ans = (ans + total_subArray_contributing * (1 << i)) % MOD;
		}
		return (int) ans;
	}
	
	public static boolean isSetBit(int num, int i) {
		return (num & (1 << i)) > 0 ? true : false;
	}

}
 