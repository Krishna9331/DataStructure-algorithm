package chapter3.problems;

/**
 * Created by mishrk3 on 5/4/2016.
 */
public class ReverseLinkList {

	public SampleList reverseList(SampleList list) {
		SampleList.Node temp = null;
		SampleList.Node current = list.head;
		SampleList.Node next = null;
		while (current != null) {
			next = current.next;
			current.next = temp;
			temp = current;
			current = next;
		}
		list.head = temp;
		return list;
	}

	public static void main(String[] args) {
		ReverseLinkList rls = new ReverseLinkList();
		SampleList sl = new SampleList();
		sl.insert(3);
		sl.insert(5);
		sl.insert(7);
		sl.insert(9);
		sl.print();
		rls.reverseList(sl);
		System.out.println("\n List after reverse");
		sl.print();
	}

}
