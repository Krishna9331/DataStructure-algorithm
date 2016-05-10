package chapter4.problems;

import chapter4.LinkedListStack;

/**
 * Created by mishrk3 on 5/10/2016.
 */
public class RemoveAdjacentDuplicate {

	LinkedListStack<String> stack = new LinkedListStack<>();

	public String removeAdjDup(String str) {
		String[] st = str.split("");
		String result = "";
		for (String s : st) {
			if (stack.isEmpty() || !s.equals(stack.getTop())) {
				stack.push(s);
			} else {
				while (!stack.isEmpty() && s.equals(stack.getTop())) {
					stack.pop();
				}
			}
		}
		while (!stack.isEmpty()) {
			result = stack.pop() + result;
		}
		return result;
	}

	public static void main(String[] args) {
		RemoveAdjacentDuplicate rad = new RemoveAdjacentDuplicate();
		System.out.println("careermonk: " + rad.removeAdjDup("careermonk"));
		System.out.println("mississippi: " + rad.removeAdjDup("mississippi"));
	}
}
