package scaler.dsa.sorting.part.two;
/*
Given a list of non-negative integers  arrange them such that they form the largest number and return it.
ex arr = {10,2}
o/p = {2,10}
*/

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {
		 //Integer[] arr = {10,2};
		    Integer[] A = {3,30,34,5,9};
		    //Integer[] A = {8,89};
		    //Integer[] A = {0,0,0,0,0};
		    //Integer[] A = {9,99,999,9999,9998};
		    //Integer[] A = {12,121};
		    String str = "";
	        LargestNumberComprator comprator = new LargestNumberComprator();
	        Arrays.sort(A, comprator);
	        for(Integer i : A) {
	            str = str +i.toString();
	        }
	       int k = 0;
	       System.out.println(str);
	    }
	}


class LargestNumberComprator implements Comparator<Integer> {

	@Override
	public int compare(Integer num1, Integer num2) {
		String s1 = num1.toString();
		String s2 = num2.toString();
		return (s2+s1).compareTo(s1+s2);
		
	}
	
	
	
}
