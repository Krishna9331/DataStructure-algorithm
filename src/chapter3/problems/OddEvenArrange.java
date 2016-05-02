package chapter3.problems;

/**
 * Created by mishrk3 on 5/2/2016.
 */
public class OddEvenArrange {

	public SampleList oddEven(SampleList list) {
		int index = 0;
		SampleList.Node p = list.head;
		SampleList.Node q = p;
		SampleList oddList = new SampleList();
		while (p != null) {
			if (p.item % 2 != 0) {
				list.deleteFromLinkedList(index);
				oddList.insert(p.item);
			} else {
				q = p;
				index++;
			}
			p = p.next;
		}
		q.next = oddList.head;
		return list;
	}

	public static void main(String[] args) {
		OddEvenArrange aea = new OddEvenArrange();
		SampleList s1 = new SampleList();
		s1.insert(1);
		s1.insert(3);
		s1.insert(4);
		s1.insert(7);
		s1.insert(9);
		s1.insert(2);
		s1.insert(8);
		s1.insert(5);
		System.out.println("The original list:");
		s1.print();
		System.out.println("\nAfter applying rearrange: \n");
		aea.oddEven(s1);
		s1.print();

	}

}
