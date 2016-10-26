package chapter7;

/**
 * Created by mishrk3 on 10/24/2016.
 */
public class HeapUtils {
	/**
	 * After insertion of an element at a position it is possible that it may not satisfy the heap property. In such
	 * case we need to adjust the location of heap. This process is called heapifying. In max heap we need to find the
	 * maximum of the element's children and swap it with element and continue to do the same until each node satisfy
	 * the heap property. In case of Max heap we process from top to bottom hence heapifying max heap is also known as
	 * Percolate down.<br/>
	 * TimeComplexity: O(logn)<br/>
	 * SpaceComplexity: O(1)
	 * 
	 * @param heap
	 *            The heap
	 * @param i
	 *            the location where we need to heapifyMax the element.
	 */
	public static void heapifyMax(Heap<Integer> heap, int i) {
		int leftChildIndex, rightChildIndex, max, temp;
		leftChildIndex = Heap.getLeftChild(heap, i);
		rightChildIndex = Heap.getRightChild(heap, i);
		if (leftChildIndex != -1 && heap.elements[leftChildIndex] > heap.elements[i]) {
			max = leftChildIndex;
		} else {
			max = i;
		}
		if (rightChildIndex != -1 && heap.elements[rightChildIndex] > heap.elements[max]) {
			max = rightChildIndex;
		}
		if (max != i) {
			temp = heap.elements[i];
			heap.elements[i] = heap.elements[max];
			heap.elements[max] = temp;
		} else {
			return;
		}
		heapifyMax(heap, max);
	}

	public static void heapifyMin(Heap<Integer> heap, int i) {
		int leftChildIndex, rightChildIndex, min, temp;
		leftChildIndex = Heap.getLeftChild(heap, i);
		rightChildIndex = Heap.getRightChild(heap, i);
		if (leftChildIndex != -1 && heap.elements[leftChildIndex] < heap.elements[i]) {
			min = leftChildIndex;
		} else {
			min = i;
		}
		if (rightChildIndex != -1 && heap.elements[rightChildIndex] < heap.elements[min]) {
			min = rightChildIndex;
		}
		if (min != i) {
			temp = heap.elements[i];
			heap.elements[i] = heap.elements[min];
			heap.elements[min] = temp;
		} else {
			return;
		}
		heapifyMin(heap, min);
	}

	/**
	 * To deleteMaxHeap an element from heap, we just need to deleteMaxHeap the root. This is the only operation
	 * supported by standard heap. Algorithm is as below: <br/>
	 * <pre>
	 *     1. Copy the root/first element into some variable
	 *     2. Copy the last element into the root element location.
	 *     3. Percolate down/heapifyMax the root element
	 *
	 * </pre>
	 * 
	 * @param heap
	 *            The heap
	 * @return the deleted element or root
	 */
	public static int deleteMaxHeap(Heap<Integer> heap) {
		int temp;
		if (heap.count == 0) {
			return -1;
		}
		temp = heap.elements[0];
		heap.elements[0] = heap.elements[heap.count - 1];
		heap.count--;
		heapifyMax(heap, 0);
		return temp;
	}

	public static int deleteMinHeap(Heap<Integer> heap) {
		int temp;
		if (heap.count == 0) {
			return -1;
		}
		temp = heap.elements[0];
		heap.elements[0] = heap.elements[heap.count - 1];
		heap.count--;
		heapifyMin(heap, 0);
		return temp;
	}

	/**
	 * The insertIntoMaxHeap follow below principle: <br/>
	 * <pre>
	 *     1. Increase the heap size if it is full
	 *     2. Keep the new element at the end of the heap tree
	 *     3. Heapify the element from bottom to top
	 * </pre> <br/>
	 * Since we are following the bottom up approach here hence it is called Percolate up.
	 * 
	 * @param heap
	 *            The heap
	 * @param data
	 *            the item need to be inserted in heap
	 * @return index of the inserted item
	 */
	public static int insertIntoMaxHeap(Heap<Integer> heap, int data) {
		int i;
		if (heap.count == heap.capacity) {
			resizeHeap(heap);
		}
		heap.count++;
		i = heap.count - 1;
		while (i > 0 && data > heap.elements[(i - 1) / 2]) {
			heap.elements[i] = heap.elements[(i - 1) / 2];
			i = (i - 1) / 2;
		}
		heap.elements[i] = data;
		return i;
	}

	/**
	 * @param heap
	 *            The heap
	 * @param data
	 *            the item need to be inserted in heap
	 * @return index of the inserted item
	 */
	public static int insertIntoMinHeap(Heap<Integer> heap, int data) {
		int i;
		if (heap.count == heap.capacity) {
			resizeHeap(heap);
		}
		heap.count++;
		i = heap.count - 1;
		while (i > 0 && data < heap.elements[(i - 1) / 2]) {
			heap.elements[i] = heap.elements[(i - 1) / 2];
			i = (i - 1) / 2;
		}
		heap.elements[i] = data;
		return i;
	}

	public static void resizeHeap(Heap<Integer> heap) {
		Integer[] newElements = new Integer[heap.capacity * 2];
		int i = 0;
		for (int ele : heap.elements) {
			newElements[i] = ele;
			i++;
		}
		heap.elements = newElements;
		heap.capacity = heap.capacity * 2;
	}

	public static void main(String[] args) {
		HeapUtils heapUtils = new HeapUtils();
		Heap<Integer> heap = Heap.getMaxUnHeap();
		heapUtils.heapifyMax(heap, 2);
		System.out.println("Heapified the passed heap : " + heap);
	}
}
