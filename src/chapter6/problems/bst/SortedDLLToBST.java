package chapter6.problems.bst;

import static chapter3.DoublyLinkedList.Node;

import chapter3.DoublyLinkedList;

/**
 * Created by mishrk3 on 9/14/2016.
 */
public class SortedDLLToBST {

	/**
	 * TimeComplexity: O(nlogn)<br/>
	 * The below method find the middle element of the list and then make that element as root. Then break the link of
	 * the middle element with pit's previous and next if any.<br/>
	 * So we will get now three sorted DLL:<br/>
	 * <pre>
	 * 1)left of the middle element say first
	 * 2)the middle element
	 * 3)right of the middle element say second
	 * </pre> now create BST from first list and assign as left subtree of the middle, similarly create BST from right
	 * and assign as right subtree of middle.
	 * 
	 * @param head
	 *            of the sorted DLL
	 * @return root of the created BST
	 */
	public Node<Integer> listToTree(Node<Integer> head) {
		Node<Integer> temp = null;
		Node<Integer> p = null;
		Node<Integer> q = null;

		if (head == null || head.next == null) {
			return head;
		}

		temp = findMiddle(head);
		p = head;
		while (p.next != temp) {
			p = p.next;
		}
		p.next = null;
		temp.previous = null;
		q = temp.next;
		if (q != null) {
			q.previous = null;
		}
		temp.next = null;
		temp.previous = listToTree(head);
		temp.next = listToTree(q);
		return temp;
	}

	private Node<Integer> findMiddle(Node<Integer> head) {
		Node<Integer> p = head;
		Node<Integer> q = head;
		while (q != null && q.next != null) {
			p = p.next;
			q = q.next.next;
		}
		return p;
	}

	public static void main(String[] args) {
		SortedDLLToBST dllToBST = new SortedDLLToBST();
		DoublyLinkedList<Integer> list = DoublyLinkedList.getSortedDLL();
		Node<Integer> root = dllToBST.listToTree(list.getHead());
		System.out.println("The list to tree conversion is done");
	}
}
