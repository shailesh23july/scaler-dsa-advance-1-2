package scaler.dsa.bit.manipulation.one;

public class StrangeEquality {

	public static void main(String[] args) {
		int A = 5;
		System.out.println(solve(A));
		//solve(A);
	}
	
	public static int solve(int A) {
        int X = A;
		int Y = 0;
		int bitCount = findBitCount(A);
		for (int i = 0; i < bitCount; i++) {
			X = X ^ (1 << i);
		}
		Y = 1 << bitCount;
        return X ^ Y;
    }
	
	public static int findBitCount(int A) {
		int count = 0;
		while (A > 0) {
			count++;
			A /= 2;
		}
		return count;
	}
	
	public static boolean isSetBit(int A, int i) {
		return (A & (1 << i)) > 0 ?  true : false; 
		
	}
	
	public static int setBit(int X, int i) {
		return X | (1 << i) ; 
		
	}

}
