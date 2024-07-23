package scaler.dsa.arrays.one.dimensional;

public class MaxSumContigiousSubArray {

	public static void main(String[] args) {
		int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int maxSubArraySum = maxSubArraySum(A);
        System.out.println(maxSubArraySum);
	}
	
	public static int maxSubArraySum(int[] A) {
		int curSum = 0;
		int maxSum = Integer.MIN_VALUE;
		int l = 0;
		int r = 0;
		int[] index = new int[2];
		for (int i = 0; i < A.length; i++) {
			curSum += A[i];
			if (curSum > maxSum) {
				maxSum = curSum;
				index[0] = l;
				index[1] = r;
			}
			if (curSum < 0) {
				curSum = 0;
				l = i + 1;
				r = i + 1;
			} else {
				r = i + 1;
			}
		}
		if (maxSum == Integer.MIN_VALUE) {
			for (int i = 0; i < A.length; i++) {
				maxSum = maxSum > A[i] ? maxSum :  A[i];
			}
		}
		System.out.println("[ " + index[0] + " " + index[1] + " ]");
		return maxSum;
	}

}
