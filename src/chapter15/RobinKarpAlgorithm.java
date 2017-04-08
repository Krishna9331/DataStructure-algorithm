package chapter15;

import static java.lang.Math.pow;

/**
 * Created by mishrk3 on 4/7/2017.
 */
public class RobinKarpAlgorithm {

	/**
	 * Time Complexity: O(mn)
	 * 
	 * @param text
	 *            the given text
	 * @param pattern
	 *            the pattern
	 * @return the index at which patter is found in text else -1;
	 */
	public int findPattern(char[] text, char[] pattern) {
		int m = pattern.length;
		int patternHash = calculateHash(pattern, m);
		int t0 = calculateHash(text, m);
		for (int t = 0; t < text.length - m; t++) {
			boolean flag = true;
			if (t0 == patternHash) {
				for (int i = 0; i < m; i++) {
					if (text[t + i] != pattern[i]) {
						flag = false;
					}
				}
				if (flag) {
					return t;
				}
			} else {
				t0 = calculateHashOnNextIndex(text, t0, t, m);
			}
		}
		if (t0 == patternHash) {
			boolean flag = true;
			for (int i = 0; i < m; i++) {
				if (text[m + i] != pattern[i]) {
					flag = false;
				}
			}
			if (flag) {
				return m;
			}
		}
		return -1;
	}

	private int calculateHashOnNextIndex(char[] text, int t0, int i, int m) {
		return (int) (10 * (t0 - pow(10, m - 1) * text[i]) + text[i + m]);
	}

	private int calculateHash(char[] pattern, int length) {
		int hashValue = 0;
		for (int i = 0; i < length; i++) {
			hashValue = 10 * hashValue;
			hashValue = hashValue + pattern[i];
		}
		return hashValue;
	}

	public static void main(String[] args) {
		RobinKarpAlgorithm rk = new RobinKarpAlgorithm();

		System.out.println(rk.findPattern("123456".toCharArray(), "345".toCharArray()));
		System.out.println(rk.findPattern("123456".toCharArray(), "456".toCharArray()));
		System.out.println(rk.findPattern("122456".toCharArray(), "242".toCharArray()));
	}
}
