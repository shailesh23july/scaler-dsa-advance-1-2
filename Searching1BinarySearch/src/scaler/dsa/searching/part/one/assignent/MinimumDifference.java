package scaler.dsa.searching.part.one.assignent;
/*
Problem Description
You are given a 2-D matrix C of size A × B.
You need to build a new 1-D array of size A by taking one element from each row of the 2-D matrix in such a way that the cost of the newly built array is minimized.

The cost of an array is the minimum possible value of the absolute difference between any two adjacent elements of the array.

So if the newly built array is X, the element picked from row 1 will become X[1], element picked from row 2 will become X[2], and so on.

Determine the minimum cost of the newly built array.



Problem Constraints
2 <= A <= 1000
2 <= B <= 1000
1 <= C[i][j] <= 106



Input Format
The first argument is an integer A denoting number of rows in the 2-D array.
The second argument is an integer B denoting number of columns in the 2-D array.
The third argument is a 2-D array C of size A x B.



Output Format
Return an integer denoting the minimum cost of the newly build array.



Example Input
Input 1:

 A = 2
 B = 2
 C = [ [8, 4]
      [6, 8] ]
Input 2:

 A = 3
 B = 2
 C = [ [7, 3]
       [2, 1]
       [4, 9] ]


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 Newly build array : [8, 8]. The minimum cost will be 0 since the absolute difference will be 0(8-8).
Explanation 2:

 Newly build array : [3, 2, 4]. The minimum cost will be 1 since the minimum absolute difference will be 1(3 - 2). 
*/



public class MinimumDifference {

	public static void main(String[] args) {
		int ans = Integer.MAX_VALUE;
		int A = 3;
		int B = 2;
		int[][] mat ={ 
	               {7, 3},
	               {2, 1},
	               {4, 9}  
	               };
		for (int i = 0; i < mat.length; i++) {
			mat[i] = divideConquer(mat[i]); 
		}
		for (int i = 0; i < A-1; i++) {
			for (int j = 0; j< B; j++) {
				int ubIndex = upperBound(mat[i+1], mat[i][j]);
				int lbIndex = lowerBound(mat[i+1], mat[i][j]);
				if (ubIndex > 0) {
					ans = mat[i+1][ubIndex] - mat[i][j]	< ans ? mat[i+1][ubIndex] - mat[i][j] : ans;
				} if (lbIndex > 0) {
					ans = mat[i][j] - mat[i+1][lbIndex]	< ans ? mat[i][j] - mat[i+1][lbIndex] : ans;
				}
			}
		}
        System.out.println(ans);
	}
	
	public static int[] divideConquer(int[] arr) {
		//Base Case
		if (arr.length == 1) {
		  return arr;
		}
       
		int[] A = new int[arr.length/2];
		int[] B = new int[arr.length - A.length];
		for (int i = 0; i < A.length; i++) {
			A[i] = arr[i];
		}
		int k = 0;
		for (int i = A.length; i < arr.length; i++) {
			B[k++] = arr[i];
		}
		 A = divideConquer(A);
		 B = divideConquer(B);
		 return mergeSort(A, B);
	}
	
	public static int[] mergeSort(int[] A, int[] B) {
		int[] res = new int[A.length + B.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < A.length && j < B.length) {
			if (A[i] <= B[j]) {
				res[k++] = A[i];
				i++;
			} else {
				res[k++] = B[j];
				j++;
			}
		}
		while (i < A.length) {
			res[k++] = A[i];
			i++;
		}
		while (j < B.length) {
			res[k++] = B[j];
			j++;
		}
		return res;
	}
	
	public static int upperBound(int[] arr, int k) {
		int low = 0;
		int high = arr.length - 1;
		int ans = -1;
		while (low <= high) {
			int mid = low + ((high - low)/2);
			if (arr[mid] == k) {
				return mid;
			}else if (arr[mid] > k) {
				high = mid - 1;
                ans = mid;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}
	
	public static int lowerBound(int[] arr, int k) {
		int low = 0;
		int high = arr.length - 1;
		int ans = -1;
		while (low <= high) {
			int mid = low + ((high - low)/2);
			if (arr[mid] == k) {
				return mid;
			}else if (arr[mid] > k) {
				high = mid - 1;
			} else {
				low = mid + 1;
				ans = mid;
			}
		}
		return ans;
	}

}
