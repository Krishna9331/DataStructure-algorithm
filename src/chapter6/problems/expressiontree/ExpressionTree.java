package chapter6.problems.expressiontree;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;

import chapter4.LinkedListStack;

/**
 * Created by mishrk3 on 8/29/2016.
 */

/**
 * A tree representing an expression is called expression tree. In this tree all the leaf nodes are operands and all
 * internal nodes are operator.
 */
public class ExpressionTree {

	/**
	 * @param postfixExp
	 *            the postfix expression
	 * @return the root node of the tree created from above postfix expression The logic for the method is traversed the
	 *         postfix expression and perform below operation. 1) if symbol is operand the push in to stack 2) else pop
	 *         the last two element from stack and make it right and left pointer of the operator and then push it back
	 *         to stack.
	 */
	public Node<Character> buildExpTree(char[] postfixExp) {

		LinkedListStack<Node<Character>> stack = new LinkedListStack<>();
		for (Character ch : postfixExp) {
			if (isOperand(ch)) {
				Node<Character> newNode = new Node<>(ch, null, null);
				stack.push(newNode);
			} else {
				Node<Character> t1 = stack.pop();
				Node<Character> t2 = stack.pop();
				Node<Character> newNode = new Node<>(ch, null, null);
				newNode.right = t1;
				newNode.left = t2;
				stack.push(newNode);
			}
		}
		return stack.getTop();
	}

	private boolean isOperand(Character ch) {
		return !(ch.equals('+') || ch.equals('-') || ch.equals('*') || ch.equals('/'));
	}

	public static void main(String[] args) {
		ExpressionTree et = new ExpressionTree();
		char[] postfix = {
				'A', 'B', 'C', '*', '+', 'D', '/'
		};
		Node<Character> root = et.buildExpTree(postfix);
		System.out.println("Root of the tree: " + root.item);
	}

}
