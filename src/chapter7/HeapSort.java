package chapter7;

/**
 * Created by mishrk3 on 10/24/2016.
 */

/**
 * One of the main Application of heap ADT is sorting. Heap sort insert all the element from an unsorted array to heap
 * and then delete the root continuously until heap is empty.
 */
public class HeapSort {

	/**
	 * @param array
	 *            The integer array to be sorted
	 * @param n
	 *            length of the array
	 * @return sorted array
	 */
	public Integer[] heapSort(int[] array, int n) {
		Heap<Integer> heap = new Heap<>(n, "max", Integer.class);
		int oldSize, i, temp;
		buildHeap(heap, array, n);
		oldSize = heap.count;
		for (i = n - 1; i > 0; i--) {
			temp = heap.elements[0];
			heap.elements[0] = heap.elements[heap.count - 1];
			heap.elements[heap.count - 1] = temp;
			heap.count--;
			HeapUtils.heapify(heap, 0);
		}
		heap.count = oldSize;
		return heap.elements;
	}

	/**
	 * The below method takes an integer array and put it in heap.
	 * 
	 * @param heap
	 *            The empty heap
	 * @param array
	 *            an integer array
	 * @param n
	 *            number of element in array
	 */
	public void buildHeap(Heap<Integer> heap, int[] array, int n) {
		if (heap == null) {
			return;
		}
		while (n > heap.capacity) {
			HeapUtils.resizeHeap(heap);
		}
		for (int i = 0; i < n; i++) {
			heap.elements[i] = array[i];
		}
		heap.count = n;
		for (int i = (n - 1) / 2; i >= 0; i--) {
			HeapUtils.heapify(heap, i);
		}
	}

	public static void main(String[] args) {
		int[] array = {
				4, 7, 2, 8, 1, 9
		};
		printArray(array);
		HeapSort hSort = new HeapSort();
		System.out.println("\nArray after sorting...");
		Integer[] resultArray = hSort.heapSort(array, array.length);
		for (int i : resultArray) {
			System.out.printf(" " + i);
		}
	}

	private static void printArray(int[] array) {
		for (int i : array) {
			System.out.printf(" " + i);
		}
	}
}
