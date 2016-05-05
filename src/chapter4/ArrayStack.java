package chapter4;

/**
 * Created by mishrk3 on 5/3/2016.
 */
public class ArrayStack<E> {

	private int top;
	private Object[] stack;

	public ArrayStack(int size) {
		stack = new Object[size];
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
			System.out.println("Stack is full -> full stack Exception");
			return;
		}
		System.out.println("push: " + item);
		top++;
		stack[top] = item;
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
		ArrayStack<Integer> stack = new ArrayStack<>(6);
		System.out.println("trying to pop an empty Stack...");
		stack.pop();
		stack.push(1);
		stack.push(3);
		stack.push(5);
		stack.push(7);
		stack.getTop();
		System.out.println("\ntrying to pop Stack...");
		stack.pop();
		stack.getTop();
		stack.push(8);
		stack.push(9);
		stack.push(2);
		System.out.println();
		stack.getTop();
		System.out.println("\ntrying to push in full stack...");
		stack.push(0);
	}
}
