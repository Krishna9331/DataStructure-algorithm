package chapter3.problems;

/**
 * Created by mishrk3 on 4/28/2016.
 */
public class SortingTwoList {

	public SampleList sortList(SampleList list1, SampleList list2) {
		SampleList resultList = new SampleList();
		SampleList.Node p1 = list1.head;
		SampleList.Node p2 = list2.head;

		while (p1 != null && p2 != null) {
			if (p1.item < p2.item) {
				resultList.insert(p1.item);
				p1 = p1.next;
			} else {
				resultList.insert(p2.item);
				p2 = p2.next;
			}
		}

		if (p1 != null) {
			while (p1 != null) {
				resultList.insert(p1.item);
				p1 = p1.next;
			}
		} else {
			while (p2 != null) {
				resultList.insert(p2.item);
				p2 = p2.next;
			}
		}

		return resultList;
	}

	public static void main(String[] args) {
		SortingTwoList sl = new SortingTwoList();
		SampleList l1 = new SampleList();
		l1.insert(2);
		l1.insert(4);
		l1.insert(5);
		l1.insert(8);
		l1.insert(11);
		SampleList l2 = new SampleList();
		l2.insert(1);
		l2.insert(3);
		l2.insert(6);
		l2.insert(7);
		l2.insert(9);
		l2.insert(10);
		l2.insert(12);

		System.out.println("First list: ");
		l1.print();
		System.out.println();
		System.out.println("Second list: ");
		l2.print();
		System.out.println();
		System.out.println("List after merging");
		SampleList result = sl.sortList(l1, l2);
		result.print();
	}
}
