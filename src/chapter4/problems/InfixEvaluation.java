package chapter4.problems;

import chapter4.LinkedListStack;

/**
 * Created by mishrk3 on 5/5/2016.
 */
public class InfixEvaluation {
	LinkedListStack<Integer> operands = new LinkedListStack<>();
	LinkedListStack<String> operators = new LinkedListStack<>();

	public int evaluateInfix(String expression) {

		String[] str = expression.split("");
		for (int i = 0; i < str.length; i++) {
			if (" ".equals(str[i])) {
				continue;
			}
			if (!StackUtil.operator(str[i])) {
				String st = "";
				while (i < str.length && !StackUtil.operator(str[i]) && !" ".equals(str[i])) {
					st += str[i];
					i++;
				}
				operands.push(Integer.parseInt(st));
				i--;
			} else {
				if (")".equals(str[i])) {
					while (!"(".equals(operators.getTop())) {
						operands.push(StackUtil.doOperation(operands.pop(), operands.pop(), operators.pop()));
					}
					if (!operators.isEmpty()) {
						operators.pop();
					}
				} else {
					if (!operators.isEmpty() && !StackUtil.isLowerPrecedence(str[i], operators.getTop())) {
						operators.push(str[i]);
					} else {
						while (!operators.isEmpty() && StackUtil.isLowerPrecedence(str[i], operators.getTop())) {
							operands.push(StackUtil.doOperation(operands.pop(), operands.pop(), operators.pop()));
						}
						operators.push(str[i]);
					}
				}
			}
		}
		while (!operators.isEmpty()) {
			operands.push(StackUtil.doOperation(operands.pop(), operands.pop(), operators.pop()));
		}

		return operands.getTop();
	}

	public static void main(String[] args) {
		InfixEvaluation ie = new InfixEvaluation();
		System.out.println("Infix evaluation of 100 * 2 + 12 is: " + ie.evaluateInfix("100 * 2 + 12"));
		System.out.println("Infix evaluation of 100 * (2 + 12) is: " + ie.evaluateInfix("100 * (2 + 12)"));
	}
}
