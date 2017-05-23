package generalproblems;

import static java.lang.Math.max;

/**
 * Created by mishrk3 on 5/23/2017.
 */
public class MinInsertionToMakePalindrome {

	public int findMinimumInsertion(String word) {
		int len = word.length();
		String reverse = reverse(word);
		return len - findLongestCommonSequence(word, reverse);
	}

	private int findLongestCommonSequence(String word, String reverse) {
		int l = word.length();
		int m = reverse.length();
		int[][] lcs = new int[l + 1][m + 1];
		for (int i = 0; i <= l; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0 || j == 0) {
					lcs[i][j] = 0;
				} else if (word.charAt(i - 1) == reverse.charAt(j - 1)) {
					lcs[i][j] = 1 + lcs[i - 1][j - 1];
				} else {
					lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1]);
				}

			}
		}
		return lcs[l][m];
	}

	private String reverse(String word) {
		String reverse = "";
		for (int i = word.length() - 1; i >= 0; i--) {
			reverse += word.charAt(i);
		}
		return reverse;
	}

	public static void main(String[] args) {
		MinInsertionToMakePalindrome makePalindrome = new MinInsertionToMakePalindrome();
		int minimumInsertion = makePalindrome.findMinimumInsertion("ab");
		System.out.println("Min insertion required to make \"ab\" palindrome is: " + minimumInsertion);
		int minimumInsertion1 = makePalindrome.findMinimumInsertion("aa");
		System.out.println("Min insertion required to make \"aa\" palindrome is: " + minimumInsertion1);
		int minimumInsertion2 = makePalindrome.findMinimumInsertion("abcd");
		System.out.println("Min insertion required to make \"abcd\" palindrome is: " + minimumInsertion2);
		int minimumInsertion3 = makePalindrome.findMinimumInsertion("abcda");
		System.out.println("Min insertion required to make \"abcda\" palindrome is: " + minimumInsertion3);
		int minimumInsertion4 = makePalindrome.findMinimumInsertion("abcde");
		System.out.println("Min insertion required to make \"abcde\" palindrome is: " + minimumInsertion4);
		int minimumInsertion5 = makePalindrome.findMinimumInsertion("apple");
		System.out.println("Min insertion required to make \"apple\" palindrome is: " + minimumInsertion5);

	}
}
