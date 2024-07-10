package com.scaler.modular.aritmetic;

import java.util.ArrayList;
import java.util.Collections;

public class FindSubSet {

	public static void main(String[] args) {
		int[] arr = {3, 5, 7};
		
	}
	
	public class Solution {
	    ArrayList < ArrayList < Integer >> ans;
	    void solve(int idx, ArrayList < Integer > cur, ArrayList < Integer > A) {
	        if (idx == A.size()) {
	            ans.add(new ArrayList < > (cur));
	            return;
	        }
	        solve(idx + 1, cur, A); // not take
	        int element = A.get(idx);
	        cur.add(element); // DO
	        solve(idx + 1, cur, A); // take
	        cur.remove(cur.size() - 1); // UNDO
	    }
	    public ArrayList < ArrayList < Integer >> subsets(ArrayList < Integer > A) {
	        Collections.sort(A);
	        ans = new ArrayList < > ();
	        ArrayList < Integer > cur = new ArrayList < > ();
	        solve(0, cur, A);
	        // sort the list of list
	        Collections.sort(ans, (ArrayList < Integer > first, ArrayList < Integer > second) -> {
	            for (int i = 0; i < first.size() && i < second.size(); i++) {
	                if (first.get(i) < second.get(i))
	                    return -1;
	                if (first.get(i) > second.get(i))
	                    return 1;
	            }
	            if (first.size() > second.size())
	                return 1;
	            return -1;
	        });
	        return ans;
	    }
	}
}
