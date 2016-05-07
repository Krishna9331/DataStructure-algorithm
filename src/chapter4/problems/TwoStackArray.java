package chapter4.problems;

/**
 * Created by mishrk3 on 5/7/2016.
 */
public class TwoStackArray {
	int[] arr;
	int size;
	int top1;
	int top2;

	public TwoStackArray(int size) {
		this.size = size;
		arr = new int[size];
		top1 = -1;
		top2 = size;
	}

	public void pushInStack1(int data) {
		System.out.println("pushing in stack1: " + data);
		if (top1 < top2 - 1) {
			top1++;
			arr[top1] = data;
		} else {
			System.out.println("stack overflow");
		}
	}

	public void pushInStack2(int data) {
		System.out.println("pushing in stack2: " + data);
		if (top1 < top2 - 1) {
			top2--;
			arr[top2] = data;
		} else {
			System.out.println("stack overflow exception");
		}
	}

	public Integer popFromStack1() {
		System.out.println("pop from stack1");
		Integer data = null;
		if (top1 > -1) {
			data = arr[top1];
			arr[top1] = 0;
			top1--;
		} else {
			System.out.println("empty stack exception");
		}
		return data;
	}

	public Integer popFromStack2() {
		System.out.println("pop from stack2");
		Integer data = null;
		if (top2 < size) {
			data = arr[top2];
			arr[top2] = 0;
			top2++;
		} else {
			System.out.println("empty stack exception");
		}
		return data;
	}

	public void printArray() {
		for (int i : arr) {
			System.out.print(i + "->");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		TwoStackArray stackArray = new TwoStackArray(5);
		stackArray.pushInStack1(5);
		stackArray.pushInStack2(7);
		stackArray.printArray();
		stackArray.pushInStack1(4);
		stackArray.pushInStack1(6);
		stackArray.pushInStack1(9);
		stackArray.printArray();
		stackArray.pushInStack1(3);
		stackArray.printArray();
		stackArray.popFromStack1();
		stackArray.popFromStack1();
		stackArray.popFromStack1();
		stackArray.popFromStack1();
		stackArray.printArray();
		stackArray.pushInStack2(8);
		stackArray.pushInStack2(3);
		stackArray.pushInStack2(1);
		stackArray.pushInStack2(11);
		stackArray.printArray();
		stackArray.pushInStack2(13);
	}
}
