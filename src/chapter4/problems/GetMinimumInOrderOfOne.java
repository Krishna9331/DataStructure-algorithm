package chapter4.problems;

import chapter4.LinkedListStack;

/**
 * Created by mishrk3 on 5/6/2016.
 */
public class GetMinimumInOrderOfOne {

	private LinkedListStack<Integer> elementStack;
	private LinkedListStack<Integer> minStack;

	public void push(int data) {
		if (elementStack == null) {
			elementStack = new LinkedListStack<>();
		}
		if (minStack == null) {
			minStack = new LinkedListStack<>();
		}

		elementStack.push(data);
		if (minStack.isEmpty() || minStack.getTop() > data) {
			minStack.push(data);
		}
	}

	public int pop() {
		if (elementStack.getTop() == minStack.getTop()) {
			minStack.pop();
		}
		return elementStack.pop();
	}

	public int getMinimum() {
		return minStack.getTop();
	}

	public void print() {
		elementStack.print();
	}

	public static void main(String[] args) {
		GetMinimumInOrderOfOne gmio1 = new GetMinimumInOrderOfOne();
		gmio1.push(2);
		gmio1.push(6);
		gmio1.push(4);
		gmio1.push(1);
		gmio1.push(5);
		System.out.println("The current elements in stack --- ");
		gmio1.print();
		System.out.println("Minimum: " + gmio1.getMinimum());
		gmio1.pop();
		gmio1.pop();
		System.out.println("The current elements in stack --- ");
		gmio1.print();
		System.out.println("Minimum: " + gmio1.getMinimum());
	}
}
