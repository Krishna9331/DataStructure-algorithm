package chapter6.problems.generictree;

import static chapter6.problems.generictree.GenericTree.Node;

/**
 * Created by mishrk3 on 8/16/2016.
 */
public class NumberOfChild {
	Node<Integer> temp = null;
	int count = 0;

	public int numOfChild(Node<Integer> node) {
		temp = node.firstChild;
		while (temp != null) {
			count++;
			temp = temp.nextSibling;
		}
		return count;
	}

	public static void main(String[] args) {
		NumberOfChild child = new NumberOfChild();
		GenericTree<Integer> tree = GenericTree.createTree();
		System.out.println("Number of Child of 1 is: " + child.numOfChild(tree.root));
	}
}
