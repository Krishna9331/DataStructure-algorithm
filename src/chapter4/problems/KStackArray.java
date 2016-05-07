package chapter4.problems;

/**
 * Created by mishrk3 on 5/7/2016.
 */
public class KStackArray {
	int[] arr;
	int[] next;
	int[] top;
	int n, k;
	int free;

	public KStackArray(int size, int numOfStack) {
		this.n = size;
		this.k = numOfStack;
		arr = new int[size];
		next = new int[size];
		top = new int[k];
		for (int i = 0; i < k; i++) {
			top[i] = -1;
		}
		free = 0;
		for (int i = 0; i < n - 1; i++) {
			next[i] = i + 1;
		}
		next[n - 1] = -1;
	}

	boolean isFull() {
		return (free == -1);
	}

	boolean isEmpty(int sn) {
		return (top[sn] == -1);
	}

	/**
	 * @param data    data to be inserted
	 * @param stackId stackId starting from 0
	 *                The logic of below n stack implementation:
	 *                irrespective of entry of element in stack number, the element is getting inserted in arr
	 *                sequentially.
	 *                e.g. 	ks.push(15, 2);
	 *                ks.push(45, 2);
	 *                ks.push(17, 1);
	 *                will put element in arr[0], arr[1] and arr[2].
	 *                principle:
	 *                1. next[free] always contains the next free arr index.
	 *                2. top[i] always contains the the value j for which arr[j] is top element for ith stack
	 *                and next[j] is next top element index in arr for the stack.e.g.
	 *                if top[2] is 4, this means arr[4] is top element for the 2nd stack and next[4] (say 6)will
	 *                contain index of next top element in arr, so arr[6] will be the next top of 2nd stack.
	 */
	public void push(int data, int stackId) {
		if (isFull()) {
			System.out.println("stack overflow exception");
		}

		int i = free;
		free = next[i];
		next[i] = top[stackId];
		top[stackId] = i;

		arr[i] = data;
	}

	public Integer pop(int stackId) {
		if (isEmpty(stackId)) {
			System.out.println("stack is empty");
			return null;
		}

		int i = top[stackId];
		top[stackId] = next[i];
		next[i] = free;
		free = i;

		return arr[i];
	}

	public static void main(String[] args) {
		KStackArray ks = new KStackArray(10, 3);
		ks.push(15, 2);
		ks.push(45, 2);
		ks.push(17, 1);
		ks.push(49, 1);
		ks.push(39, 1);
		ks.push(11, 0);
		ks.push(9, 0);
		ks.push(7, 0);
		ks.push(11, 2);
		ks.push(12, 1);

		System.out.println("Popped element from stack 2 is " + ks.pop(2));
		System.out.println("Popped element from stack 1 is " + ks.pop(1));
		System.out.println("Popped element from stack 0 is " + ks.pop(0));
		ks.push(32, 1);
		ks.push(42, 1);
		ks.push(62, 1);
	}
}
