package chapter7.problems;

/**
 * Created by mishrk3 on 10/26/2016.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chapter7.Heap;
import chapter7.HeapUtils;

/**
 * Given k sorted list with total n input among all the lists. Give an algorithm to merge it as single sorted list of
 * size n.
 */
public class MergeKSortedList {

	public List<Integer> mergeLists(int n, List<Integer>... lists) {
		int numOfLists = lists.length;
		Heap<Integer> minHeap = new Heap<>(numOfLists, "min", Integer.class);
		List<Integer> resultList = new ArrayList<>();
		int[] indexArray = new int[numOfLists];
		for (int i = 0; i < numOfLists; i++) {
			HeapUtils.insertIntoMinHeap(minHeap, lists[i].get(indexArray[i]));
		}
		while (resultList.size() != n) {
			int min = HeapUtils.deleteMinHeap(minHeap);
			resultList.add(min);
			boolean found = false;
			for (int i = 0; i < numOfLists; i++) {
				if (indexArray[i] == lists[i].size() - 1 || found) {
					continue;
				}
				if (min == lists[i].get(indexArray[i])) {
					found = true;
					indexArray[i]++;
					HeapUtils.insertIntoMinHeap(minHeap, lists[i].get(indexArray[i]));
				}
			}
		}
		return resultList;
	}

	public static void main(String[] args) {
		MergeKSortedList merger = new MergeKSortedList();
		List<Integer> list1 = Arrays.asList(70, 75, 80, 85, 90, 95, 100);
		List<Integer> list2 = Arrays.asList(32, 37, 45, 57, 71, 87, 92);
		List<Integer> list3 = Arrays.asList(35, 41, 52, 62, 79, 84, 99);
		List<Integer> list4 = Arrays.asList(31, 42, 53, 54, 64, 72, 94);
		List<Integer> list5 = Arrays.asList(11, 43, 54, 57, 69, 86, 96);
		List<Integer> list6 = Arrays.asList(0, 5, 10, 15, 20, 25, 30);
		List<Integer> resultList = merger.mergeLists(42, list1, list2, list3, list4, list5, list6);
		System.out.println("Lists has been merged...");
		for (int i : resultList) {
			System.out.printf(" " + i);
		}
	}
}
