package chapter4.problems;

import chapter4.LinkedListStack;

/**
 * Created by mishrk3 on 5/6/2016.
 */
public class StringXPalindrome {

	public boolean isPalindrome(String string) {
		LinkedListStack<String> stack = new LinkedListStack<>();
		String[] str = string.split("");
		int i = 0;
		for (i = 0; !"X".equals(str[i]); i++) {
			stack.push(str[i]);
		}
		i++;
		while (i < str.length) {
			if (stack.isEmpty() || !str[i].equals(stack.pop())) {
				return false;
			}
			i++;
		}
		return true;
	}

	public static void main(String[] args) {
		StringXPalindrome sXP = new StringXPalindrome();
		System.out.println("ABCXCBA is palindrome: " + sXP.isPalindrome("ABCXCBA"));
		System.out.println("abbaXabba is palindrome: " + sXP.isPalindrome("abbaXabba"));
		System.out.println("abaaXaabc is palindrome: " + sXP.isPalindrome("abaaXaabc"));
	}
}
