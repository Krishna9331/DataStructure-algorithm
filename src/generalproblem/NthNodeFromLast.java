package generalproblem;

/**
 * Created by mishrk3 on 12/15/2016.
 */
public class NthNodeFromLast {

	static class Node {
		int data;
		Node next;
	}

	int getNode(Node head,int n) {
		// This is a "method-only" submission.
		// You only need to complete this method.
		Node p = head;
		Node q = head;
		for(int i = 0; i <= n; i++){
			p = p.next;
		}
		while(p != null){
			q = q.next;
			p = p.next;
		}
		return q.data;
	}

	public static void main(String[] args) {
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
		NthNodeFromLast ls = new NthNodeFromLast();
		int data = ls.getNode(nodeA, 3);
		System.out.println("3td Node from last is: "+ data);
	}
}
