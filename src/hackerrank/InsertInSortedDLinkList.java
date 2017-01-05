package hackerrank;

/**
 * Created by mishrk3 on 12/21/2016.
 */
public class InsertInSortedDLinkList {
	static class Node {
		int data;
		Node prev;
		Node next;
	}

	Node SortedInsert(Node head,int data) {
		Node newNode = new Node();
		newNode.data = data;
		Node p = head, q = null;
		if (head == null) {
			head = newNode;
		} else {
			while (p.next != null && p.data <= data) {
				q = p;
				p = p.next;
			}
			 if (p.data < newNode.data) {
				p.next = newNode;
				newNode.prev = p;
				newNode.next = null;
			}else if (q == null) {
				newNode.next = head;
				head.prev = newNode;
				head = newNode;
			} else {
				q.next = newNode;
				newNode.prev = q;
				newNode.next = p;
				p.prev = newNode;
			}
		}
		return head;
	}


	public static void main(String[] args) {
		Node node = new Node();
		node.data = 8;
		InsertInSortedDLinkList in = new InsertInSortedDLinkList();

		Node head = in.SortedInsert(null, 1);
		Node head1 = in.SortedInsert(head, 4);
		Node head2 = in.SortedInsert(head1, 2);
		Node head3 = in.SortedInsert(head2, 3);
		Node head4 = in.SortedInsert(head3, 7);
		Node head5 = in.SortedInsert(head4, 6);
		Node head6 = in.SortedInsert(head5, 9);
		Node head7 = in.SortedInsert(head6, 10);
		System.out.println("All insert done: " + head7);
	}

}
