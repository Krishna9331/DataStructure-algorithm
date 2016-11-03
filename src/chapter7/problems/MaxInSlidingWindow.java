package chapter7.problems;

/**
 * Created by mishrk3 on 11/3/2016.
 */

import chapter5.problems.DEQueue;

/**
 * Given array A[] with sliding window of size w which is moving from very left to very right. Assume that we can see
 * the w numbers in the window. Each time the sliding window moves rightwards by one position. Write an algorithm to
 * find Max of each window.
 */
public class MaxInSlidingWindow {

	/**
	 * @param a
	 *            An array of integer
	 * @param n
	 *            number of elements in {@param} a
	 * @param w
	 *            size of the window
	 * @param b
	 *            result array which stores max with each window starting from 0. <br/>
	 *            <br/>
	 *            The below code uses double ended queue as data structure as it supports insertion and deletion at both
	 *            end. The trick is ti find a way such that the front of the queue will always store the index of
	 *            largest element traversed till now. So if an elements is found it check against all the element from
	 *            back and keep popping it until it finds the element bigger than it. And the it always check the index
	 *            of element at the front falls in current window or not.
	 */
	void findMaxInSlidingWindow(int[] a, int n, int w, int[] b) {
		DEQueue<Integer> deQueue = new DEQueue<>();
		// populate the queue for first w-1 element, this will make sure front has max element for elements 0 to w-1
		// followed by elements till w-1. Hence queue will contain 1->2->1 as 0th element is smaller than 1st one.
		for (int i = 0; i < w; i++) {
			while (!deQueue.isEmpty() && a[i] >= a[deQueue.getBack()]) {
				deQueue.popBackDEQ();
			}
			deQueue.pushBackDEQ(i);
		}
		// loop from w to n with increment of 1 as window slides one position each time
		for (int i = w; i < n; i++) {
			// populate the result array with front position before each loop.
			b[i - w] = a[deQueue.getFront()];
			// check for the position of next element in the array. pops the elements from back until it finds greater
			// than current element otherwise make the current as front
			while (!deQueue.isEmpty() && a[i] >= a[deQueue.getBack()]) {
				deQueue.popBackDEQ();
			}
			// check if current index of front falls in sliding window otherwise pop until next max element for current
			// window arrives.
			while (!deQueue.isEmpty() && deQueue.getFront() <= i - w) {
				deQueue.popFrontDEQ();
			}
			// push the current element's index at the back of queue, it will become front if it is greater than all
			// elements in queue.
			deQueue.pushBackDEQ(i);
		}
		// populate the last index as loop will exit
		b[n - w] = a[deQueue.getFront()];
	}

	public static void main(String[] args) {
		MaxInSlidingWindow max = new MaxInSlidingWindow();
		int n = 8;
		int[] a = {
				1, 3, -1, -3, 5, 3, 6, 7
		};
		int w = 3;
		int[] b = new int[n - w + 1];
		max.findMaxInSlidingWindow(a, n, w, b);
		for (int i : b) {
			System.out.println(i);
		}
	}
}
