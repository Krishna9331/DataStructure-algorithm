package hackerrank;

import chapter3.SinglyLinkedList;

import static chapter3.SinglyLinkedList.Node;

/**
 * Created by mishrk3 on 12/19/2016. <pre> 
 * You're given the pointer to the head node of a sorted linked list, where the data in the nodes is in ascending order. Delete as few nodes as possible so that the list does not contain any value more than once. The given head pointer may be null indicating that the list is empty.

 For now do not be concerned with the memory deallocation. In common abstract data structure scenarios, deleting an element might also require deallocating the memory occupied by it. For an initial intro to the topic of dynamic memory please consult: http://www.cplusplus.com/doc/tutorial/dynamic/

 Input Format 
 You have to complete the Node* removeDuplicates(Node* head) method which takes one argument - the head of the sorted linked list. You should NOT read any input from stdin/console.

 Output Format 
 Delete as few nodes as possible to ensure that no two nodes have the same data. Adjust the next pointers to ensure that the remaining nodes form a single sorted linked list. Then return the head of the sorted updated linked list. Do NOT print anything to stdout/console.

 Sample Input

 1 -> 1 -> 3 -> 3 -> 5 -> 6 -> NULL
 NULL
 Sample Output

 1 -> 3 -> 5 -> 6 -> NULL
 NULL
 Explanation 
 1. 1 and 3 are repeated, and are deleted. 
 2. Empty list remains empty.
 </pre>
 */
public class DeleteDuplicateFromSortedList {

	Node removeDuplicates(Node head) {
		// This is a "method-only" submission.
		// You only need to complete this method.
		Node q = head;
		Node prev = head;
		while (q.next != null) {
			q = q.next;
			if (q!= null && q.item == prev.item) {
				prev.next = q.next;
			} else {
				prev = q;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		SinglyLinkedList list = SinglyLinkedList.getSortedListWithDuplicates();
		DeleteDuplicateFromSortedList del = new DeleteDuplicateFromSortedList();
		//del.removeDuplicates(list.head);

		SinglyLinkedList list1 = SinglyLinkedList.getSortedListWithSameElements();
		del.removeDuplicates(list1.head);
		System.out.println("duplicate deleted...");
	}
}
