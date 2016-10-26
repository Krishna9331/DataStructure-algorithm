package chapter7.problems;

import chapter7.Heap;

/**
 * Created by mishrk3 on 10/25/2016.
 */

/**
 * Given a Min heap, give an algorithm to find maximum element in heap.
 */
public class MaximumInMinHeap {

	/**
	 * Since given Heap is Min heap hence it is sure that one of the leaf node will be the maximum. Also it's true that
	 * last element in heap(element at count-1 position) will be the leaf element. Also if we notice all the element
	 * appearing after the parent of last element is leaf node. This means all the element after (count-1)/2 position is
	 * leaf node. Hence we can scan all the element from (count-1)/2 +1 to count-1 positions and find the max.
	 * 
	 * @param heap
	 *            The Min heap
	 * @return the maximum element pf the heap
	 */
	public Integer findMax(Heap<Integer> heap) {
		int max = Integer.MIN_VALUE;
		for (int i = (heap.count + 1) / 2; i < heap.count; i++) {
			if (heap.elements[i] > max) {
				max = heap.elements[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Heap<Integer> minHeap = Heap.getMinHeap();
		MaximumInMinHeap mx = new MaximumInMinHeap();
		int result = mx.findMax(minHeap);
		System.out.printf("Maximum element in heap is: " + result);
	}
}
