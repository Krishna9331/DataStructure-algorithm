package chapter7.problems;

import chapter7.Heap;
import chapter7.HeapUtils;

/**
 * Created by mishrk3 on 10/26/2016.
 */

/**
 * Design a heap data structure that supports finding dynamic median.
 */
public class DynamicMedian {
	public static final int INITIAL_CAPACITY = 10;

	Heap<Integer> minHeap = new Heap<>(INITIAL_CAPACITY, "min", Integer.class);
	Heap<Integer> maxHeap = new Heap<>(INITIAL_CAPACITY, "max", Integer.class);

	/**
	 * The insert logic is soul for the implementation of the dynamic heap. The logic is as below: <br/>
	 * <pre>
	 *     1) MaxHeap always contains the elements less than minimum of Min heap
	 *     2) If total number of element is Even then:
	 *        i)if data is less than max of the MaxHeap then
	 *         a)Insert the data into Max heap
	 *         b)Delete the root element of the MaxHeap
	 *         c)Insert the deleted max into Min heap.
	 *        endIf.
	 *       else
	 *        Insert the data into Min heap
	 *      endIf
	 *     3) If total number of element is Odd then
	 *       i)if data is greater then minimum of the Min heap then
	 *        a)Insert data into Mean heap
	 *        b)Delete the minimum from Min heap
	 *        c)Insert the deleted Minimum in Max Heap
	 *       endIf
	 *      else
	 *       Insert the data into Max Heap.
	 * </pre><br/>
	 * Hence above logic says if total count (maxheap +Minheap) is even then try to insert in MinHeap otherwise in
	 * Maxheap.<br/>
	 * Reference: http://codercareer.blogspot.in/2012/01/no-30-median-in-stream.html
	 * 
	 * @param data
	 *            to be inserted in heap
	 */
	public void insert(int data) {
		if ((minHeap.count + maxHeap.count) % 2 == 0) {
			if (data < Heap.getRootElement(maxHeap)) {
				HeapUtils.insertIntoMaxHeap(maxHeap, data);
				int max = HeapUtils.deleteMaxHeap(maxHeap);
				HeapUtils.insertIntoMinHeap(minHeap, max);
			} else {
				HeapUtils.insertIntoMinHeap(minHeap, data);
			}
		} else {
			if (data > Heap.getRootElement(minHeap)) {
				HeapUtils.insertIntoMinHeap(minHeap, data);
				int min = HeapUtils.deleteMinHeap(minHeap);
				HeapUtils.insertIntoMaxHeap(maxHeap, min);
			} else {
				HeapUtils.insertIntoMaxHeap(maxHeap, data);
			}
		}
	}

	public int getMedian() {
		if ((minHeap.count + maxHeap.count) % 2 == 0) {
			return (Heap.getRootElement(minHeap) + Heap.getRootElement(maxHeap)) / 2;
		} else {
			return Heap.getRootElement(minHeap);
		}
	}

	public static void main(String[] args) {
		DynamicMedian median = new DynamicMedian();
		median.insert(1);
		median.insert(1);
		median.insert(2);
		median.insert(4);
		median.insert(5);
		System.out.println("The median of {1, 1, 2, 4, 5} is: " + median.getMedian());
		System.out.println("Inserting 7...");
		median.insert(7);
		System.out.println("The median is: " + median.getMedian());
		System.out.println("Inserting 9...");
		median.insert(9);
		System.out.println("The median is: " + median.getMedian());
	}
}
