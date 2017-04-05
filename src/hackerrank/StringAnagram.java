package hackerrank;

/**
 * Created by mishrk3 on 4/5/2017.
 */
public class StringAnagram {

	private static final int MAX_POSSIBLE_ASCII = 256;

	public boolean compare(int[] count, int[] txt) {
		for (int i = 0; i < MAX_POSSIBLE_ASCII; i++) {
			if (count[i] != txt[i]) {
				return false;
			}
		}
		return true;
	}

	public void findAnagram(char[] text, char[] pattern) {
		int[] count = new int[MAX_POSSIBLE_ASCII];
		int[] txt = new int[MAX_POSSIBLE_ASCII];
		int m = pattern.length;
		int n = text.length;

		for (int i = 0; i < m; i++) {
			count[pattern[i]]++;
			txt[text[i]]++;
		}

		for (int i = m; i < n; i++) {
			if (compare(count, txt)) {
				System.out.println("Anagram found at index: " + (i - m));
			}
			txt[text[i]]++;
			txt[text[i - m]]--;
		}
		if (compare(count, txt)) {
			System.out.println("Anagram found at index: " + (n - m));
		}
	}

	public static void main(String[] args) {
		String text = "BACDGABCDA";
		String pattern = "ABCD";
		StringAnagram sa = new StringAnagram();
		sa.findAnagram(text.toCharArray(), pattern.toCharArray());
	}
}
