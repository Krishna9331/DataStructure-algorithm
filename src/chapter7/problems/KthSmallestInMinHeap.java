package chapter7.problems;

import chapter7.Heap;
import chapter7.HeapUtils;

/**
 * Created by mishrk3 on 10/26/2016.
 */
public class KthSmallestInMinHeap {

	/**
	 * The below method using the property of min heap, that root element is smaller than it's children. Hence if we
	 * delete the root and heapify it we will have element at root which is second smallest in the original heap. Hence
	 * if we repeat the deletion for k-1th time the last element will be kth smallest in the heap.<br/>
	 * TimeComplexity: O(klogn)
	 * 
	 * @param heap
	 *            The min heap
	 * @param k
	 *            the kth number to be returned
	 * @return kth smallest element
	 */
	public int findKthElement(Heap<Integer> heap, int k) {
		for (int i = 0; i < k - 1; i++) {
			HeapUtils.deleteMinHeap(heap);
		}
		return HeapUtils.deleteMinHeap(heap);
	}

	public static void main(String[] args) {
		Heap<Integer> minHeap = Heap.getMinHeap();
		KthSmallestInMinHeap ele = new KthSmallestInMinHeap();
		int result = ele.findKthElement(minHeap, 6);
		System.out.printf("6th smallest element is: " + result);
	}
}
