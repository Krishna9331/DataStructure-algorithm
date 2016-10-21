package chapter7;

/**
 * Created by mishrk3 on 10/21/2016.
 */
public class Heap<E> {
	E[] elements;
	int count; // number of element in heap
	int capacity; // size of the heap
	int heapType; // Min Heap or Max Heap

	public Heap(int capacity, int heapType) {
		this.count = 0;
		this.capacity = capacity;
		this.heapType = heapType;
		elements = (E[]) new Object[capacity];
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
	public int getParent(Heap<Integer> heap, int i) {
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
	public int getLeftChild(Heap<Integer> heap, int i) {
		int left = 2 * i + 1;
		if (left > heap.count) {
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
	public int getRightChild(Heap<Integer> heap, int i) {
		int right = 2 * i + 2;
		if (right > heap.count) {
			return -1;
		}
		return right;
	}

	/**
	 * In the max heap the root is the largest element, hence element at index 0 will be maximum.
	 * 
	 * @param heap
	 *            The heap
	 * @return max element in heap or -1 if heap is empty
	 */
	public int MaxElement(Heap<Integer> heap) {
		if (heap.count == 0) {
			return -1;
		}
		return heap.elements[0];
	}
}
