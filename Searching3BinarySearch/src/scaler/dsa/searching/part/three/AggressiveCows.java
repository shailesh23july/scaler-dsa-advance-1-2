package scaler.dsa.searching.part.three;

import java.util.Arrays;

/*
Given N Cows and M stalls, all M stalls are on X axis at different locations given in stall[]. 
Place all N cows in such a way that the minimum distance between any 2 cows is maximized. 
Note 1: In one stall only one cow can be accommodated.
Note 2: And all the cow has to be placed.
stall = {1,2,4,8,9}; Cow = 3.
   
*/
public class AggressiveCows {

	public static void main(String[] args) {
		//int[] stalls = {1,2,4,8,9};
		//int[] stalls = {2,6,11,14,19,25,30,39,43};
		int[] stalls = {5,17,100,11};
		Arrays.sort(stalls);
		int cows = 2;
		int ans = aggressiveCows(stalls, cows);
		System.out.println(ans);

	}
	
	public static int aggressiveCows(int[] stalls, int cows) {
		int n = stalls.length;
		int l = 1;
		int h = stalls[n - 1] - stalls[0];
		int ans = -1;
		while (l <= h) {
			int m = l + (h - l) / 2;
			if (check(m, stalls, cows)) {
				l = m + 1;
				ans = m;
			} else {
				h = m - 1;
			}
		}
		return ans;
	}

	private static boolean check(int m, int[] stalls, int cows) {
		int stalledCows = 1;
		int lastStalledCow = stalls[0];
		for (int i = 1; i < stalls.length; i++) {
			if (stalls[i] - lastStalledCow >= m) {
				stalledCows++;
				lastStalledCow = stalls[i];
			}
			if (stalledCows >= cows) {
				return true;
			}
		}
		return false;
	}

}
