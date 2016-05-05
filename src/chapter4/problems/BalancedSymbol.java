package chapter4.problems;

/**
 * Created by mishrk3 on 5/4/2016.
 */

import chapter4.LinkedListStack;

/**
 * This algorithm is really helpful for compilers. As compilers parse each string 1 by 1 and if it finds that
 * number of opening bracket is not equal to closing bracket, compiler error reported.
 */
public class BalancedSymbol {
	public boolean isBalanced(String str) {
		LinkedListStack lls = new LinkedListStack();
		String[] st = str.split("");
		for (String s : st) {
			if ("(".equals(s) || "{".equals(s) || "[".equals(s)) {
				lls.push(s);
			} else if ((")".equals(s) || "}".equals(s) || "]".equals(s)) && isMatching(lls.getTop(), s)) {
				if (lls.isEmpty()) {
					return false;
				}
				lls.pop();
			}
		}
		if (lls.isEmpty()) {
			return true;
		}
		return false;
	}

	private boolean isMatching(Object top, String s) {
		if (")".equals(s)) {
			return "(".equals(top);
		}
		if (")".equals(s)) {
			return "(".equals(top);
		}
		if (")".equals(s)) {
			return "(".equals(top);
		}
		return false;
	}

	public static void main(String[] args) {
		BalancedSymbol bs = new BalancedSymbol();
		System.out.println("expression (A+B)*(C+D) is balanced: " + bs.isBalanced("(A+B)*(C+D)"));
		System.out.println("expression (A+B*(C+D) is balanced: " + bs.isBalanced("(A+B*(C+D)"));
		System.out.println("expression ((A+B)*(C+D)) is balanced: " + bs.isBalanced("((A+B)*(C+D))"));
		System.out.println("expression ((A+B)*(C+D)} is balanced: " + bs.isBalanced("((A+B)*(C+D)}"));
	}
}
