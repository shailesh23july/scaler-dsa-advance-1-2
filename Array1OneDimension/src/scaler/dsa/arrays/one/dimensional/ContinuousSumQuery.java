package scaler.dsa.arrays.one.dimensional;

public class ContinuousSumQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	  public int[] solve(int A, int[][] B) {
		  int[] ans = new int[A];
		  for (int i = 0; i < B.length; i++) {
			  int l = B[i][0] - 1; 
			  int r = B[i][1] - 1;
			  ans[l] += B[i][2];
			  if (r < A-1) {
				  ans[r+1] -= B[i][2];  
			  }
		  }
		  for (int i = 1; i < ans.length; i++) {
			  ans[i] += ans[i-1];
		  }
		  return ans;
	  }

}
