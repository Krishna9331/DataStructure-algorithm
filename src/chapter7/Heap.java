package chapter7;

import java.lang.reflect.Array;

/**
 * Created by mishrk3 on 10/21/2016.
 */
public class Heap<E> {
	public static final String MAX_HEAP = "max";
	public E[] elements;
	public int count; // number of element in heap
	public int capacity; // size of the heap
	public String heapType; // Min Heap or Max Heap

	public Heap(int capacity, String heapType, Class<E> clazz) {
		this.count = 0;
		this.capacity = capacity;
		this.heapType = heapType;
		elements = (E[]) Array.newInstance(clazz, capacity);
	}

	/**
	 * The property of heap is for an element at position i the position of parent will be (i-1)/2
	 *
	 * @param heap
	 *            The heap
	 * @param i
	 *            the index of element for which parent need to be found in @heap
	 * @return index of parent of element at i or -1 if not found
	 */
	public static int getParent(Heap<Integer> heap, int i) {
		if (i <= 0 || i > heap.count) {
			return -1;
		}
		return (i - 1) / 2;
	}

	/**
	 * As per heap property for an element at i it's left child will be at 2*1 +1 position
	 *
	 * @param heap
	 *            The heap
	 * @param i
	 *            index of parent for which left child need to be found
	 * @return index of the left child or -1 if not found
	 */
	public static int getLeftChild(Heap<Integer> heap, int i) {
		int left = 2 * i + 1;
		if (left > heap.count - 1) {
			return -1;
		}
		return left;
	}

	/**
	 * As per heap property for an element at i it's right child will be at 2*1 +2 position
	 *
	 * @param heap
	 *            The heap
	 * @param i
	 *            index of parent for which right child need to be found
	 * @return index of the right child or -1 if not found
	 */
	public static int getRightChild(Heap<Integer> heap, int i) {
		int right = 2 * i + 2;
		if (right > heap.count - 1) {
			return -1;
		}
		return right;
	}

	/**
	 * In the max heap the root is the largest element, hence element at index 0 will be maximum.
	 * 
	 * @param heap
	 *            The heap
	 * @return max element for Max heap or min element for min heap or -1 if heap is empty
	 */
	public static int getRootElement(Heap<Integer> heap) {
		if (heap.count == 0) {
			return -1;
		}
		return heap.elements[0];
	}

	/**
	 * @return Heap of Integer which violates the heap property at position 2
	 */
	public static Heap<Integer> getMaxUnHeap() {
		Heap<Integer> heap = new Heap<>(7, MAX_HEAP, Integer.class);
		heap.elements[0] = 17;
		heap.elements[1] = 13;
		heap.elements[2] = 3;
		heap.elements[3] = 1;
		heap.elements[4] = 4;
		heap.elements[5] = 2;
		heap.elements[6] = 5;
		heap.count = 7;
		return heap;
	}

	public static Heap<Integer> getMaxHeap() {
		Heap<Integer> heap = new Heap<>(7, MAX_HEAP, Integer.class);
		heap.elements[0] = 17;
		heap.elements[1] = 13;
		heap.elements[2] = 6;
		heap.elements[3] = 1;
		heap.elements[4] = 4;
		heap.elements[5] = 2;
		heap.elements[6] = 5;
		heap.count = 7;
		return heap;
	}

	public static Heap<Integer> getMinHeap() {
		Heap<Integer> heap = new Heap<>(12, MAX_HEAP, Integer.class);
		heap.elements[0] = 1;
		heap.elements[1] = 5;
		heap.elements[2] = 14;
		heap.elements[3] = 2;
		heap.elements[4] = 10;
		heap.elements[5] = 21;
		heap.elements[6] = 18;
		heap.elements[7] = 3;
		heap.elements[8] = 11;
		heap.elements[9] = 28;
		heap.elements[10] = 37;
		heap.elements[11] = 42;
		heap.count = 12;
		return heap;
	}
}
