package chapter15;

/**
 * Created by mishrk3 on 4/8/2017.
 */
public class KMP {

	/**
	 * Time Complexity: O(m + n)
	 *
	 * @param text
	 *            the given text
	 * @param pattern
	 *            the pattern
	 * @return the index at which patter is found in text else -1;
	 */
	public int findPattern(char[] text, char[] pattern) {
		int m = pattern.length;
		int[] prefixTable = createPrefixTable(pattern, m);
		int n = text.length;
		int i = 0, j = 0;
		while (i < n) {
			if (text[i] == pattern[j]) {
				if (j == m - 1) {
					return i - j;
				} else {
					i++;
					j++;
				}
			} else if (j > 0) {
				j = prefixTable[j - 1];
			} else {
				i++;
			}
		}
		return -1;
	}

	private int[] createPrefixTable(char[] pattern, int m) {
		int[] table = new int[m];
		int i = 1, j = 0;
		table[0] = 0;
		while (i < m) {
			if (pattern[i] == pattern[j]) {
				table[i] = j + 1;
				i++;
				j++;
			} else if (j > 0) {
				j = table[j - 1];
			} else {
				table[i] = 0;
				i++;
			}
		}
		return table;
	}

	public static void main(String[] args) {
		KMP kmp = new KMP();
		char[] pattern = "ababaca".toCharArray();
		char[] text = "bacbabababacaca".toCharArray();
		int[] prefixTable = kmp.createPrefixTable(pattern, pattern.length);
		System.out.println("The prefix table for Pattern ababaca is: ");
		for (int i : prefixTable) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(
				"The pattern ababaca is found in text bacbabababacaca at index: " + kmp.findPattern(text, pattern));

		char[] pattern1 = "caca".toCharArray();
		System.out.println(
				"The pattern caca is found in text bacbabababacaca at index: " + kmp.findPattern(text, pattern1));

		char[] pattern2 = "cacab".toCharArray();
		System.out.println(
				"The pattern caca is found in text bacbabababacaca at index: " + kmp.findPattern(text, pattern2));
	}

}
