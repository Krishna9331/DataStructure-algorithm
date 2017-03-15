package hackerrank;

import java.util.Scanner;

/**
 * Created by mishrk3 on 3/15/2017.
 */

/**
 * It generates all the string with alternate vowel and consonant of given length.
 */
public class AlternateVowelAndConsonenetString {

	public static void main(String[] args) {
		char[] vowels = {
				'a', 'e', 'i', 'o', 'u'
		};
		char[] consonants = {
				'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'
		};

		int len1 = vowels.length;
		int len2 = consonants.length;
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long start1 = System.currentTimeMillis();
		printAllAlternateStringVowel(vowels, consonants, "", len1, len2, n);
		printAllAlternateStringConsonent(vowels, consonants, "", len1, len2, n);
		long diff1 = System.currentTimeMillis() - start1;
		System.out.println(diff1);
	}

	private static void printAllAlternateStringVowel(char[] vowels, char[] consonants, String prefix, int len1,
			int len2, int n) {
		if (n == 0) {
			System.out.println(prefix);
			return;
		}

		for (int i = 0; i < len1; i++) {
			String newPrefix = prefix + vowels[i];
			printAllAlternateStringConsonent(vowels, consonants, newPrefix, len1, len2, n - 1);
		}
	}

	private static void printAllAlternateStringConsonent(char[] vowels, char[] consonants, String prefix, int len1,
			int len2, int n) {
		if (n == 0) {
			System.out.println(prefix);
			return;
		}

		for (int j = 0; j < len2; j++) {
			String newPrefix = prefix + consonants[j];
			printAllAlternateStringVowel(vowels, consonants, newPrefix, len1, len2, n - 1);
		}
	}
}
