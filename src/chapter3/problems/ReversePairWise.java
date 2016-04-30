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

	public SampleList.Node reverseKGrp(SampleList.Node head, int k) {
		SampleList.Node curr = head, temp = null, next, last = null, p = null, newHead;
		int i = 0;
		if (k == 0 || k == 1) {
			return head;
		}
		if (HasKNodes(curr, k - 1)) {
			newHead = GetKPlusOneThNode(k - 1, curr);
		} else {
			newHead = head;
		}

		while (curr != null && HasKNodes(curr, k)) {
				p = last;
			last = curr;
			temp = GetKPlusOneThNode(k, curr);
			i = 0;
			while (i < k) {
				next = curr.next;
				curr.next = temp;
				temp = curr;
				curr = next;
				i++;
				if (i == k && p != null) {
					p.next = temp;
				}
			}
		}
		return newHead;
	}

	private SampleList.Node GetKPlusOneThNode(int k, SampleList.Node head) {
		SampleList.Node kth;
		int i = 0;
		if (head == null) {
			return head;
		}
		for (i = 0, kth = head; kth != null && i < k; i++, kth = kth.next)
			;
		if (i == k && kth != null) {
			return kth;
		}
		return head.next;
	}

	private boolean HasKNodes(SampleList.Node head, int k) {
		int i = 0;
		for (i = 0; head != null && i < k; i++, head = head.next)
			;
		return i == k;
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

		SampleList s2 = new SampleList();
		s2.insert(2);
		s2.insert(3);
		s2.insert(7);
		s2.insert(5);
		s2.insert(4);
		s2.insert(9);
		s2.insert(1);
		s2.insert(6);
		s2.insert(8);
		s2.insert(11);
		s2.insert(13);
		System.out.println("\nActual list............\n");
		s2.print();
		System.out.printf("\nreversing 3 element at a time in group ......\n");
		s2.head = rpw.reverseKGrp(s2.head, 3);
		s2.print();
	}
}
