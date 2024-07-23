package scaler.dsa.arrays.one.dimensional;

import java.util.ArrayList;

public class AddOne {

	public static void main(String[] args) {
      int[] A = {9,9,9};
      int[] one = addOne(A);
      for (int i = 0; i < one.length; i++) {
    	  System.out.print(one[i] + " ");
      }
	}
	
	public static int[] addOne(int[] A) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int number = A[A.length -1] + 1;
		int place = 1;
		for (int i = A.length - 2; i >= 0; i--) {
			place *= 10;
			number += A[i] * place; 
		}
		while (number > 0) {
			list.add(number % 10);
			number /= 10;
		}
		int[] ans = new int[list.size()];
		int k = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			ans[k++] = list.get(i);
		}
		return ans;
	}

}
