package com.scaler.modular.aritmetic;

public class SubsetSum {

	public static void main(String[] args) {
		int[] arr = {3, 5, 7};
		int target = 10;
		System.out.println(subset(arr, 0, 0, target));

	}
	
	public static boolean subset(int[] arr, int ssf, int index, int target) {
		//Base condition
		if (index == arr.length) {
			return ssf == target;
		}
		
		//yes
		boolean ans = subset(arr, ssf + arr[index], index + 1, target);
		//No
		ans = ans || subset(arr, ssf, index + 1, target);
		
		return ans;
	}

}
