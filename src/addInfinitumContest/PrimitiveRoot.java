package addInfinitumContest;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by mishrk3 on 1/2/2017.
 */
public class PrimitiveRoot {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		int m = p;
		if (isPrime(p)) {
			m = p - 1;
		}
		int primeRoot = 0;
		int count = 0;
		Map<Integer, Integer> primeFactor = getPrimeFactor(m);
		for (Map.Entry<Integer, Integer> map : primeFactor.entrySet()) {
			primeFactor.put(map.getKey(), m / map.getKey());
		}
		for (int i = 2; i <= m; i++) {
			boolean notPrimeRoot = false;
			for (Map.Entry<Integer, Integer> map : primeFactor.entrySet()) {
				if (BigInteger.valueOf(i).modPow(BigInteger.valueOf(map.getValue()), BigInteger.valueOf(p))
						.equals(BigInteger.ONE))
					notPrimeRoot = true;
			}
			if (!notPrimeRoot) {
				primeRoot = i;
				count++;
				break;
			}
		}
		for (int i = 2; i <= m; i++) {
			if(gcd(i, m) == 1){
				count++;
			}
		}

		System.out.println("Lowest Prime Root is: " + primeRoot + "total number is: " + count);
	}

	private static boolean isPrime(int p) {
		for (int i = 2; i <= Math.sqrt(p); i++) {
			if (p % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static Map<Integer, Integer> getPrimeFactor(int p) {
		Map<Integer, Integer> map = new HashMap<>();
		while (p % 2 == 0) {
			insertToMap(2, map);
			p /= 2;
		}

		for (int i = 3; i <= Math.sqrt(p); i += 2) {
			while (p % i == 0) {
				insertToMap(i, map);
				p /= i;
			}
		}

		if (p > 2)
			insertToMap(p, map);
		return map;
	}

	private static void insertToMap(int i, Map<Integer, Integer> map) {
		if (map.get(i) != null) {
			map.put(i, map.get(i) + 1);
		} else {
			map.put(i, 1);
		}
	}

	private static int gcd(int a, int b) {
		if (a == b)
			return a;

		if (a > b)
			return gcd(a - b, b);
		return gcd(a, b - a);
	}
}
