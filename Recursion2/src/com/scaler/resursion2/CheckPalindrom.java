package com.scaler.resursion2;

public class CheckPalindrom {

	public static void main(String[] args) {
		String str = "abcra";
        System.out.println(checkPalindrom(str, 0, str.length()-1));

	}
	
	public static boolean checkPalindrom(String str, int start, int end) {
		 //BaseCase
		if (start > end) {
			return true;
		}
		if(str.charAt(start) == str.charAt(end)) {
			return checkPalindrom(str, start + 1, end -1);
		} else {
			return false;
		}
	}

}
