package chapter4;

/**
 * Created by mishrk3 on 5/4/2016.
 */
public class DynamicArrayStack<E> {

	private int top;
	private Object[] stack;
	private static final int INITIAL_SIZE = 5;

	public DynamicArrayStack() {
		stack = new Object[INITIAL_SIZE];
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == stack.length - 1;
	}

	public void push(E item) {
		if (isFull()) {
			expandStack();
		}
		System.out.println("push: " + item);
		top++;
		stack[top] = item;
	}

	private void expandStack() {
		int newSize = stack.length * 2;
		Object[] stackNew = new Object[newSize];
		for (int i = 0; i < stack.length; i++) {
			stackNew[i] = stack[i];
		}
		stack = stackNew;
	}

	public void pop() {
		if (isEmpty()) {
			System.out.println("stack is Empty -> empty stack exception");
			return;
		}
		System.out.println("pop: " + stack[top]);
		top--;
	}

	public void getTop() {
		System.out.println("\ntop: " + stack[top]);
	}

	public static void main(String[] args) {
		DynamicArrayStack<Integer> das = new DynamicArrayStack<>();
		System.out.println("size of Stack: " + das.stack.length);
		das.push(6);
		das.push(4);
		das.push(3);
		das.push(1);
		das.push(9);
		das.getTop();
		System.out.println("\ntrying to push element in full stack");
		das.push(8);
		das.getTop();
	}

}
