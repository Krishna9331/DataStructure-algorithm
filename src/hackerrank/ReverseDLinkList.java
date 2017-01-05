package hackerrank;

import chapter3.DoublyLinkedList;

import static chapter3.DoublyLinkedList.Node;

/**
 * Created by mishrk3 on 12/19/2016.
 */
public class ReverseDLinkList {

	Node reverse(Node head) {

		Node q = head;
		Node prev = head;
		Node temp = head.next;
		Node curr = temp;
		while (curr != null) {
			curr = temp;
			temp = temp.next;
			curr.next = prev;
			prev.previous = curr;
			//curr.previous = temp;
			prev = curr;
			curr = temp;
			q = q.next;
		}
		head.next = null;
		return prev;
	}

	public static void main(String[] args) {
		DoublyLinkedList list = DoublyLinkedList.getSampleDLL();
		ReverseDLinkList reverseDLinkList = new ReverseDLinkList();
		Node newHead = reverseDLinkList.reverse(list.getHead());
		System.out.printf("List is reversed..." + newHead.item);
	}
}
