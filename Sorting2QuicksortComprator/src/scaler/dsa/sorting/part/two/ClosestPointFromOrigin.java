package scaler.dsa.sorting.part.two;

import java.util.Arrays;
import java.util.Comparator;

/*
 Given an array of points where p[i] = [x,y] representing a point on X-Y plane and an integer k, return k closest point to the origin.
 ex arr = {{1,3},{-2,2}} and k = 1
 ex arr = {{3,3},{5,-1},{-2,4}} and k = 2
*/

public class ClosestPointFromOrigin {

	public static void main(String[] args) {
		Integer[][] arr =  {{3,3},{5,-1},{-2,4}};
		Integer k = 2;
		DistanceComparator comprator = new DistanceComparator();
		Arrays.sort(arr, comprator);
		for (int i = 0; i < k; i++) {
			System.out.println("X: " + arr[i][0] + " Y: " + arr[i][1]);
		}
}

}

class DistanceComparator implements Comparator<Integer[]> {

	@Override
	public int compare(Integer[] p1, Integer[] p2) {
		Integer d1 = (p1[0] * p1[0]) + (p1[1] * p1[1]);
		Integer d2 = (p2[0] * p2[0]) + (p2[1] * p2[1]);
		return d1.compareTo(d2);
	}
	
}
