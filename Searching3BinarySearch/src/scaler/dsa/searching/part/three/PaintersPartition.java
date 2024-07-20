package scaler.dsa.searching.part.three;
/*
We have to paint N board of lengths A1,A2,A3....An.There are k painters available and each takes 1 unit of time to paint 1 unit of board.
Find the minimum time to get the job done.
Note: A painter will paint continuous unit of boards.
arr = {3,5,1,7,8,2,5,3,10,1,4,7,5,4,6}
*/

public class PaintersPartition {

	public static void main(String[] args) {
		int[] times = {3,5,1,7,8,2,5,3,10,1,4,7,5,4,6};
		int k = 4;
		int ans = paintersPartition(times, k);
		System.out.println(ans);

	}
	
	public static int paintersPartition(int[] times, int noOfPainters) {
		int l = max(times);
		int h = sum(times);
		int ans = -1;
		while(l <= h) {
			int m = l + (h-l)/2;
			if (check(m, times, noOfPainters)) {
				ans = m;
				h = m - 1;
			} else {
				l = m + 1;
			}
		}
		return ans;
	}

	private static boolean check(int curTime, int[] times, int noOfPainters) {
		int painterUsed = 1;
		int consumedTime = 0;
		for (int i = 0; i < times.length; i++) {
			if (consumedTime + times[i] <= curTime) {
				consumedTime += times[i];
			} else {
				painterUsed++;
				consumedTime = times[i];
			}
			if (painterUsed > noOfPainters) {
				return false;
			}
		}
		return true;
	}

	private static int max(int[] times) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < times.length; i++) {
			max = times[i] > max ? times[i] : max;
		}
		return max;
	}

	private static int sum(int[] times) {
		int sum = times[0];
		for (int i = 1; i < times.length; i++) {
			sum += times[i];
		}
		return sum;
	}

}
