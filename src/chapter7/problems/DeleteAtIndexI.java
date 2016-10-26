package chapter7.problems;

/**
 * Created by mishrk3 on 10/25/2016.
 */

import chapter7.Heap;
import chapter7.HeapUtils;

/**
 * Give an algorithm for deleting an element at ith index.
 */
public class DeleteAtIndexI {
	public Integer deleteElement(Heap<Integer> heap, int i) {
		int key;
		int count = heap.count;
		if (count < i + 1) {
			return null;
		}
		key = heap.elements[i];
		heap.elements[i] = heap.elements[count - 1];
		heap.count--;
		HeapUtils.heapifyMin(heap, i);
		return key;
	}

	public static void main(String[] args) {
		DeleteAtIndexI di = new DeleteAtIndexI();
		Heap<Integer> minHeap = Heap.getMinHeap();
		int result = di.deleteElement(minHeap, 4);
		System.out.printf("Delete the element: " + result);
	}
}
