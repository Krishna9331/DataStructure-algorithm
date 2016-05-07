package chapter4.problems;

/**
 * Created by mishrk3 on 5/7/2016.
 */
public class ThreeStackArray {
	int[] arr;
	int size;
	int top1;
	int top2;
	int base3;
	int top3;

	public ThreeStackArray(int size) {
		arr = new int[size];
		this.size = size;
		top1 = -1;
		top2 = size;
		base3 = size / 2;
		top3 = size / 2 - 1;
	}

	public void push1(int data) {
		System.out.println("pushing data in stack1: " + data);
		if (top1 < base3 - 1) {
			top1++;
			arr[top1] = data;
		} else if (top3 < top2 - 1) {
			shiftRight();
			top1++;
			arr[top1] = data;
		} else {
			System.out.println("stack overflow exception");
		}
	}

	public void push2(int data) {
		System.out.println("pushing data in stack2: " + data);
		if (top3 < top2 - 1) {
			top2--;
			arr[top2] = data;
		} else if (top1 < base3 - 1) {
			shiftLeft();
			top2--;
			arr[top2] = data;
		} else {
			System.out.println("stack overflow exception");
		}
	}

	public void push3(int data) {
		System.out.println("pushing data in stack3: " + data);
		if (top3 < top2 - 1) {
			top3++;
			arr[top3] = data;
		} else if (top1 < base3 - 1) {
			shiftLeft();
			top3++;
			arr[top3] = data;
		} else {
			System.out.println("stack overflow exception");
		}
	}

	public Integer pop1() {
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

	public Integer pop2() {
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

	public Integer pop3() {
		System.out.println("pop from stack3");
		Integer data = null;
		if (base3 <= top3) {
			data = arr[top3];
			arr[top3] = 0;
			top3--;
		} else {
			System.out.println("empty stack exception");
		}
		return data;
	}

	private void shiftLeft() {
		for (int i = base3; i <= top3; i++) {
			arr[i - 1] = arr[i];
			arr[i] = 0;
		}
		base3--;
		top3--;
	}

	private void shiftRight() {
		for (int i = top3; i >= base3; i--) {
			arr[i + 1] = arr[i];
			arr[i] = 0;
		}
		base3++;
		top3++;
	}

	public void printArray() {
		for (int i : arr) {
			System.out.print(i + "->");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ThreeStackArray tsa = new ThreeStackArray(7);
		tsa.pop1();
		tsa.pop2();
		tsa.pop3();
		tsa.push1(3);
		tsa.push2(5);
		tsa.printArray();
		tsa.push2(7);
		tsa.push2(9);
		tsa.push2(4);
		tsa.printArray();
		tsa.push1(2);
		tsa.push3(8);
		tsa.printArray();
		tsa.pop2();
		tsa.pop2();
		tsa.pop2();
		tsa.printArray();
		tsa.push1(11);
		tsa.push1(31);
		tsa.printArray();
		tsa.push3(7);
		tsa.printArray();
		tsa.pop3();
		tsa.pop3();
		tsa.printArray();
	}

}
