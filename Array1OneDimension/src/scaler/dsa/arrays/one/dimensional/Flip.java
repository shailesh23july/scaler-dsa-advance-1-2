package scaler.dsa.arrays.one.dimensional;

public class Flip {

	public static void main(String[] args) {
	  String A = "010";
      int[] flip = flip(A);
      System.out.println(flip[0] + " " + flip[1]);
	}
	
	public static int[] flip(String A) {
		int l = 0;
		int r = 0;
		int cSum = 0;
		int maxSum = 0;
		int[] ans = new int[2];
		int[] EMPTY = {};
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == '0') {
				cSum += 1;
			} else {
				cSum -= 1;
			}
		  if (cSum > maxSum) {
			  maxSum = cSum;
			  ans[0] = l;
			  ans[1] = r;
		  }
		  if (cSum < 0) {
			  cSum = 0;
			  l = i+1;
			  r = i+1;
		  } else {
			  r += 1;
		  }
		}
		if (maxSum == 0) {
			return EMPTY;
		}
		return ans;
	}

}
