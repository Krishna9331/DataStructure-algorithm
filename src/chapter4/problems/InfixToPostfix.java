package chapter4.problems;

import chapter4.LinkedListStack;

/**
 * Created by mishrk3 on 5/4/2016.
 */
public class InfixToPostfix {

	public String infixToPostfix(String str) {
		LinkedListStack<String> stack = new LinkedListStack<>();
		String[] st = str.split("");
		String result = "";
		for (String s : st) {
			if (StackUtil.operator(s)) {
				if (")".equals(s)) {
					while (!stack.isEmpty() && !"(".equals(stack.getTop())) {
						result += stack.pop();
					}
					if (!stack.isEmpty()) {
						stack.pop();
					}
				} else {
					if (!stack.isEmpty() && !StackUtil.isLowerPrecedence(s, stack.getTop())) {
						stack.push(s);
					} else {
						while (!stack.isEmpty() && StackUtil.isLowerPrecedence(s, stack.getTop())) {
							String top = stack.pop();
							if (!"(".equals(top)) {
								result += top;
							}
						}
						stack.push(s);
					}
				}
			} else {
				result += s;
			}
		}
		while (!stack.isEmpty()) {
			result += stack.pop();
		}

		return result;
	}

	public static void main(String[] args) {
		InfixToPostfix itp = new InfixToPostfix();
		System.out.println("The Postfix expression for A*B-(C+D)+E is: " + itp.infixToPostfix("A*B-(C+D)+E"));
		System.out.println("The Postfix expression for 1+2*4/5-7+3/6 is: " + itp.infixToPostfix("1+2*4/5-7+3/6"));
		System.out.println("The Postfix expression for a+(b*c)/d is: " + itp.infixToPostfix("a+(b*c)/d"));
	}
}
