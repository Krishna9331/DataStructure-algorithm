package chapter3.problems;

/**
 * Created by mishrk3 on 4/28/2016.
 */
public class ReversePairWise {

	public SampleList.Node reversePairWise(SampleList.Node head) {
		SampleList.Node p = null;
		if (head == null || head.next == null) {
			return head;
		} else {
			p = head.next;
			head.next = p.next;
			p.next = head;
			head = p;
			head.next.next = reversePairWise(head.next.next);
			return head;
		}
	}

	public static void main(String[] args) {
		SampleList sl = new SampleList();
		sl.insert(2);
		sl.insert(5);
		sl.insert(6);
		sl.insert(9);
		sl.insert(7);
		System.out.println("The real list ---->");
		sl.print();
		System.out.println();
		System.out.println("After pair wise reversal---->");
		ReversePairWise rpw = new ReversePairWise();
		sl.head = rpw.reversePairWise(sl.head);
		sl.print();
	}
}
