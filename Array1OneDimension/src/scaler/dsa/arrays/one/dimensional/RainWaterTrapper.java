package scaler.dsa.arrays.one.dimensional;

public class RainWaterTrapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int totalWaterTrapped(int[] A) {
		int[] prifixMAx = findPrifixMax(A);
		int[] suffixMax = findSuffixMax(A);
		int totalWater = 0;
		for (int i = 0; i < A.length; i++) {
			int currWater = (prifixMAx[i] < suffixMax[i] ? prifixMAx[i] : suffixMax[i]) - A[i];
			totalWater += currWater;
		}
		return totalWater;
	}

	private static int[] findSuffixMax(int[] A) {
		int[] pfMax = new int[A.length];
		pfMax[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			pfMax[i] = pfMax[i-1] > A[i] ? pfMax[i-1] : A[i];
		}
		return pfMax;
	}

	private static int[] findPrifixMax(int[] A) {
		int[] sfMax = new int[A.length];
		sfMax[A.length - 1] = A[A.length - 1];
		for (int i = A.length - 2; i >= 0; i--) {
			sfMax[i] = sfMax[i+1] > A[i] ? sfMax[i+1] :  A[i];
		}
      return sfMax;
	}

}
