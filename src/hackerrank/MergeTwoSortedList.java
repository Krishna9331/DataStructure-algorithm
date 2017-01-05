package hackerrank;

/**
 * Created by mishrk3 on 12/15/2016.
 */
public class MergeTwoSortedList {

	static class Node {
		int data;
		Node next;
	}

	Node mergeLists(Node headA, Node headB) {
		Node q = headA;
		Node p = headB;
		Node head = null;
		Node curr = null;
		Node tmp = null;
		while (q != null && p != null) {
			tmp = new Node();
			if (q.data > p.data) {
				tmp.data = p.data;
				p = p.next;
			} else {
				tmp.data = q.data;
				q = q.next;
			}
			if (head == null) {
				head = tmp;
			} else {
				curr.next = tmp;
			}
			curr = tmp;
		}
		if (p == null) {
			if(head == null){
				return q;
			}
			curr.next = q;
		} else {
			if(head == null){
				return p;
			}
			curr.next = p;
		}
		return head;
	}

	public static void main(String[] args) {
		MergeTwoSortedList mrg = new MergeTwoSortedList();
		Node nodeA = new Node();
		nodeA.data = 1;
		Node nodeA1 = new Node();
		nodeA1.data = 3;
		nodeA.next = nodeA1;
		Node nodeA2 = new Node();
		nodeA2.data = 5;
		nodeA1.next = nodeA2;
		Node nodeA3 = new Node();
		nodeA3.data = 6;
		nodeA2.next = nodeA3;

		Node nodeB = new Node();
		nodeB.data = 2;
		Node nodeB1 = new Node();
		nodeB1.data = 4;
		nodeB.next = nodeB1;
		Node nodeB2 = new Node();
		nodeB2.data = 7;
		nodeB1.next = nodeB2;
		Node head = mrg.mergeLists(nodeA, nodeB);

		Node c = null;
		Node head1 = mrg.mergeLists(c, nodeB);
		System.out.println("List is merged with head: " + head.data);
	}
}
