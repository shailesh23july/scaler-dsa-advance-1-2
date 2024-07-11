package scaler.dsa.sorting.part.two;

import java.util.Comparator;

public class ComparFactors implements Comparator<Integer> {

	@Override
	public int compare(Integer num1, Integer num2) {
		Integer f1 = countFactors(num1);
		Integer f2 = countFactors(num2);
		int comparResult = f1.compareTo(f2);
		if (comparResult == 0) {
			return num1.compareTo(num2);
		}
		return comparResult;
	}

	public int countFactors(int N) {
		int count = 0;
		for (int i = 1; i * i <= N; i++) {
			if (N % i == 0) {
				if (i == N / i) {
					count++;
				} else {
					count += 2;
				}
			}
		}
		return count;
	}

}
