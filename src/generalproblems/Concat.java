package generalproblems;

import java.util.Stack;

/**
 * Created by mishrk3 on 4/13/2017.
 */
public class Concat {
}

class A {

	static boolean check(String str) {
		Stack<String> stack = new Stack<>();
		String[] st = str.split("");
		for (String s : st) {
			if ("(".equals(s) || "{".equals(s) || "[".equals(s)) {
				stack.push(s);
			} else if (")".equals(s) || "}".equals(s) || "]".equals(s)) {
				if (stack.isEmpty()) {
					return false;
				}
				if(!isMatching(stack.pop(), s)){
					return false;
				}
			}
		}
		return stack.empty();
	}

	private static boolean isMatching(Object top, String s) {
		if (")".equals(s)) {
			return "(".equals(top);
		}
		if ("}".equals(s)) {
			return "{".equals(top);
		}
		if ("]".equals(s)) {
			return "[".equals(top);
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(A.check("[()]"));   // true
		System.out.println(A.check("(()[])")); // true
		System.out.println(A.check("([)]"));   // false
		System.out.println(A.check("(("));     // false
		System.out.println(A.check("[(()])")); // false

		System.out.println(A.check("([(([[(([]))]]))])"));   // true
		System.out.println(A.check("[](()()[[]])()[]([])")); // true
		System.out.println(A.check("([((([(([]))])))))])")); // false
		System.out.println(A.check("[](()()[[]])[][[([])")); // false
	}
}
