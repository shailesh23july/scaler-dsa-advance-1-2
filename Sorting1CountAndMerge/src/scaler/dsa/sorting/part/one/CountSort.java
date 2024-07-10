package scaler.dsa.sorting.part.one;

import java.util.ArrayList;
import java.util.Collections;

/*
 Find the smallest number that can be formed by rearranging the digits of the given number.
 ex 1: N = 6342721
     o/p = 1223467
 ex 2: N = 427390
     o/p = 023479 
 ex 3: N = -2383-23 
*/

public class CountSort {

	public static void main(String[] args) {
		//int N = 6342721;
		//int N = 427390;
		//int[] N = {-2,3,8,3,-2,3};
		int[] N = {-2,-3,-8,-3,-2,-3};
		//solveIdeaOne(N);
		//solveIdeaTwo(N);
		solveCountSortNegativeNumversIdeaThree(N);
	}
	
	//Idea 1: Convert N into array and sort.
	public static void solveIdeaOne(int N) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (N > 0) {
			list.add(N%10);
			N /= 10;
		}
		Collections.sort(list);
		System.out.println(list);
	}
	//Idea 2:
	//1. Create a frequency map 10 indexed array.
	//2. Go through each digit in N and count the frequency.
	//3. Go through 0-9 index in the array and print the element to the frequency.
	public static void solveIdeaTwo(int N) {
		int[] freqArr = new int[10];
		while (N > 0) {
			int index = N%10;
			freqArr[index]++;
			N /= 10;
		}
		for (int i = 0; i < freqArr.length; i++) {
			while(freqArr[i]>0) {
				System.out.print(i);
				freqArr[i]--;
			}
		}
	}
	
	public static void solveCountSortNegativeNumversIdeaThree(int[] N) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N.length; i++) {
			 min = N[i] < min ? N[i] : min;
			 max = N[i] > max ? N[i] : max;
		}
		int freq_range = (max - min) + 1;
		int[] freqMap = new int[freq_range];
		for (int i = 0; i < N.length; i++) {
			freqMap[N[i] - min]++;
		}
		for (int i = 0; i < freqMap.length; i++) {
			while(freqMap[i] > 0) {
				System.out.print(i + min);
				freqMap[i]--;
			}
		}
		
	}
	
	

}
