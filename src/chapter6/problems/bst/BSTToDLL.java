package chapter6.problems.bst;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;

import chapter6.problems.binarytree.SampleBinaryTree;

/**
 * Created by mishrk3 on 9/8/2016.
 */

/**
 * Given a BST convert it to circular doubly Link list with Space Complexity O(1). <pre>
 *
 *                              20
 *                           /     \
 *                          10     30
 *                         / \    /  \
 *                        5  15  25  40
 * </pre> <br/>
 * The below code works on the logic of divide and conquer, where we create list from left and right tree and then
 * combine the left list with root followed by right with left list. The code flow for above tree will work like as
 * below: <br/>
 * <pre>
 *                                        treeToList(5)-> since left and right is null hence it will create 5<=>5
 * *                                    /
 *                    / treeToList(10)
 *                   /                  \ treeToList(15) ->same as above 15<=>15
 *                  /
 *                 /After evaluation of 5 and 15 append will be called for 5<=>5 and 10<=>10 which will result as
 *                /circular DLL between 5 and 10 as 5<=>10<=>5 and then the call will be to append 15 in this which will
 * 1)treeToList(20)                         result as 5<=>10<=>15 <=>5
 *                \
 *                 \                Same as above right subtree will be converted to Doubly circular link list
 *                  \               and at last left will be merged with 20 and then right with left
 *                   \                / treeToList(25)
 *                     treeToList(30)
 *                                    \ treeToList(40)
 *the final list will be
 *              5<=>10<=>15<=>20<=>25<=>30<=>40<=>5
 *
 * </pre>
 */
public class BSTToDLL {

	/**
	 * The append method is the conquer phase in below code. where it takes two node and connect to each other and
	 * create circular link list.
	 * 
	 * @param a
	 *            the first node
	 * @param b
	 *            the second
	 * @return node after connecting a and b circularly
	 */
	public Node<Integer> append(Node<Integer> a, Node<Integer> b) {
		Node<Integer> aLast, bLast;
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		aLast = a.left;
		bLast = b.left;
		aLast.right = b;
		b.left = aLast;
		bLast.right = a;
		a.left = bLast;
		return a;
	}

	/**
	 * The treeToList method is the divide phase where it separate the left tree of the root and right tree of the root.
	 * then it recursively create circular DLL from left sub tree and same for the right sub tree. Then it goes for the
	 * conquer where it first add the root in left DLL and then with the left DLL with right subtree DLL.
	 * 
	 * @param root
	 *            of the BST tree
	 * @return the circular link list created with all the nodes of BST
	 */
	public Node<Integer> treeToList(Node<Integer> root) {
		Node<Integer> aList, bList;
		if (root == null) {
			return null;
		}
		aList = treeToList(root.left);
		bList = treeToList(root.right);
		root.left = root;
		root.right = root;
		aList = append(aList, root);
		aList = append(aList, bList);
		return aList;
	}

	public static void main(String[] args) {
		BSTToDLL bstToDLL = new BSTToDLL();
		SampleBinaryTree tree = SampleBinaryTree.getSmallBST();
		Node<Integer> head = bstToDLL.treeToList(tree.getRoot());
		Node<Integer> temp = head;
		do {
			System.out.print(temp.item + "-->");
			temp = temp.right;
		} while (temp.item != head.item);
	}
}
