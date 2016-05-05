package chapter4.problems;

import chapter4.LinkedListStack;

/**
 * Created by mishrk3 on 5/5/2016.
 */
public class PostFixEvaluation {

	LinkedListStack<Integer> stack = new LinkedListStack<>();

	public int evaluatePostfix(String expression) {
		String[] str = expression.split("");
		for (String s : str) {
			if (StackUtil.operator(s)) {
				stack.push(StackUtil.doOperation(stack.pop(), stack.pop(), s));
			} else {
				stack.push(Integer.parseInt(s));
			}
		}
		return stack.pop();
	}


	public static void main(String[] args) {
		PostFixEvaluation pe = new PostFixEvaluation();
		System.out.println("Evaluation of postfix 123*+5-: " + pe.evaluatePostfix("123*+5-"));
	}
}
