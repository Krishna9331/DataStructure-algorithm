package hackerrank;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = 26;
		int h[] = new int[n];
		for (int h_i = 0; h_i < n; h_i++) {
			h[h_i] = in.nextInt();
		}
		int maxHeight = 0;
		String word = in.next();
		int length = word.length();
		for (int i = 0; i < length; i++) {
			int height = h[word.charAt(i) - 97];
			if (h[word.charAt(i) - 97] > maxHeight) {
				maxHeight = height;
			}
		}
		System.out.println(maxHeight*length*1);
	}
}
