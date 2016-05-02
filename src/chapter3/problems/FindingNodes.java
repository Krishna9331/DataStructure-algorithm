package chapter3.problems;

/**
 * Created by mishrk3 on 5/2/2016.
 */
public class FindingNodes {

	public SampleList.Node lastModularNodeFromFirst(SampleList list, int k) {
		SampleList.Node p = list.head;
		SampleList.Node modular = null;
		int i = 0;
		if (k <= 0) {
			return null;
		} else {
			while (p != null) {
				if (i % k == 0) {
					modular = p;
				}
				p = p.next;
				i++;
			}
		}
		return modular;
	}

	public SampleList.Node firstModularNodeFromLast(SampleList list, int k) {
		SampleList.Node p = list.head;
		SampleList.Node modular = list.head;
		if (k <= 0) {
			return null;
		} else {
			for (int i = 0; i <= k; i++) {
				p = p.next;
			}
			while (p != null) {
				modular = modular.next;
				p = p.next;
			}
		}
		return modular;
	}

	/**
	 * if we find the index divided by k initialize the fract by head first time and for after wards increase the
	 * fract by one node.
	 */
	public SampleList.Node fractionalNode(SampleList list, int k) {
		SampleList.Node p = list.head;
		SampleList.Node fract = null;
		if (k <= 0) {
			return null;
		}
		int index = 0;
		while (p != null) {
			if (index % k == 0) {
				if (fract == null) {
					fract = list.head;
				} else {
					fract = fract.next;
				}
			}
			p = p.next;
			index++;
		}
		return fract;
	}

	/**
	 * check if an index is square of number or not starting from 1.
	 * for first match intialize the sqrtnode with head and further occurrence point it to next one
	 */
	public SampleList.Node sqrtNode(SampleList list) {
		SampleList.Node p = list.head;
		SampleList.Node sqrt = null;
		int index = 1;
		int num = 1;
		while (p != null) {
			if (index == num * num) {
				if (sqrt == null) {
					sqrt = list.head;
				} else {
					sqrt = sqrt.next;
				}
				num++;
			}
			p = p.next;
			index++;
		}
		return sqrt;
	}

	public SampleList.Node mergeAlternate(SampleList list1, SampleList list2) {
		SampleList.Node newHead = new SampleList.Node(0, null);
		SampleList.Node temp = newHead;
		SampleList.Node p = list1.head;
		SampleList.Node q = list2.head;
		while (p != null && q != null) {
			temp.next = p;
			temp = temp.next;
			p = p.next;

			temp.next = q;
			q = q.next;
			temp = temp.next;
		}
		if (p == null) {
			temp.next = q;
		} else {
			temp.next = p;
		}
		return newHead.next;
	}

	public static void main(String[] args) {
		SampleList s1 = new SampleList();
		s1.insert(1);
		s1.insert(3);
		s1.insert(4);
		s1.insert(7);
		s1.insert(9);
		s1.insert(2);
		s1.insert(8);
		s1.insert(5);
		s1.insert(6);
		SampleList s2 = new SampleList();
		s2.insert(23);
		s2.insert(33);
		s2.insert(43);
		s2.insert(53);
		s2.insert(63);
		s2.insert(73);
		s2.insert(83);
		System.out.println("The original list is: ");
		s1.print();
		FindingNodes fn = new FindingNodes();
		SampleList.Node lastModularNode = fn.lastModularNodeFromFirst(s1, 4);
		System.out.println("\nlast modular from first for the size of 9 and k as 4: " + lastModularNode.item);

		SampleList.Node firstModularFrmLast = fn.firstModularNodeFromLast(s1, 4);
		System.out.println("\nfirst modular from last for the size of 9 and k as 4: " + firstModularFrmLast.item);

		SampleList.Node sqrtNode = fn.sqrtNode(s1);
		System.out.println("The square root position node for the list size 9: " + sqrtNode.item);

		SampleList.Node fractionalNode = fn.fractionalNode(s1, 2);
		System.out.println("n/kth position node where n is 9 and k is 2: " + fractionalNode.item);
		System.out.println("\n The second list is: ");
		s2.print();
		SampleList mergedList = new SampleList();
		mergedList.head = fn.mergeAlternate(s1, s2);

		System.out.println("\n merging alternate first and second list: ");
		mergedList.print();

	}
}
