package chapter6.problems.binarytree;

import chapter4.LinkedListStack;
import chapter5.LinkedListQueue;

/**
 * Created by mishrk3 on 5/18/2016.
 */
public class BinaryTree<E> {

	private Node<E> root;

	private static class Node<E> {
		E item;
		Node<E> left;
		Node<E> right;

		public Node(E item, Node<E> left, Node<E> right) {
			this.item = item;
			this.left = left;
			this.right = right;
		}

		@Override public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;

			Node<?> node = (Node<?>) o;

			if (!item.equals(node.item))
				return false;
			if (!left.equals(node.left))
				return false;
			return right.equals(node.right);

		}

		@Override public int hashCode() {
			int result = 0;
			if (null != item) {
				result = item.hashCode();
			}
			if (left != null) {
				result = 31 * result + left.hashCode();
			}
			if (right != null) {
				result = 31 * result + right.hashCode();
			}
			return result;
		}
	}

	public void preOrderTraversal(Node<E> root) {
		if (null != root) {
			System.out.printf(root.item + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

	/**
	 * The logic behind below method is:
	 * Continue below steps in infinite loop:
	 * 1) print the root and push it into the stack
	 * 2)if it has left child, then make left child as root
	 * 3)Continue step one and two until root is not null
	 * So using above three steps we will start printing from the root element and traverse all the left child of each
	 * child root node. e.g. if root is 1 and it  has left as 2 which has left has 4(leaf node) then order of printing
	 * will be 1, 2, 4, remember it has not yet visited the right child of 2.
	 * 4)if step 3 breaks(means if there is no more left child or we reached leaf node), then check if stack is empty
	 * 5)if step 4 is true break and exit
	 * 6)pop the stack and make root equal to right child of poped element
	 * Since we are in infinite loop and now we have valid root step 1 and 3 will continue. this means right child of
	 * 2 will be printed(if any). and then will continue either traverse down or pop the next one from stack.
	 */
	public void preOrderNonRecursive() {
		Node<E> p = root;
		LinkedListStack<Node<E>> stack = new LinkedListStack<>();
		while (true) {
			while (null != p) {
				System.out.printf(p.item + " ");
				stack.push(p);
				p = p.left;
			}
			if (stack.isEmpty()) {
				break;
			}
			p = stack.pop();
			p = p.right;
		}
	}

	public void inOrderTraversal(Node<E> root) {
		if (null != root) {
			inOrderTraversal(root.left);
			System.out.printf(root.item + " ");
			inOrderTraversal(root.right);
		}
	}

	/**
	 * In order traversal is similar to pre order however with some difference:
	 * Continue below steps in infinite loop
	 * 1) push the root in stack
	 * 2) make left child of root as new root
	 * 3)continue step 1 and 2 until root is not null
	 * So using above will insert all the left element in stack starting from root to left most leaf.
	 * The left will be at top.
	 * 4)if step 3 breaks(means if there is no more left child or we reached leaf node), then check if stack is empty
	 * 5)if step 4 is true break and exit
	 * 6)pop the stack and print the element
	 * 7)make root as right child of poped element
	 * Since we are in infinite loop and now we have valid root step 1 and 3 will continue. this means right child of
	 * 2 will be printed(if any). and then will continue either traverse down or pop the next one from stack.
	 */
	public void InOrderNonRecursive() {
		Node<E> p = root;
		LinkedListStack<Node<E>> stack = new LinkedListStack<>();
		while (true) {
			while (null != p) {
				stack.push(p);
				p = p.left;
			}
			if (stack.isEmpty()) {
				break;
			}
			p = stack.pop();
			System.out.printf(p.item + " ");
			p = p.right;

		}
	}

	public void postOrderTraversal(Node<E> root) {
		if (null != root) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.printf(root.item + " ");
		}
	}

	/**
	 * In post order traversal each node is traversed twice. The below method print an element only if it has printed
	 * all it's left and right child. so after visiting left subtree of a node it visits the element and then it
	 * goes to traverse the right subtree, once that is done it comes back and print the current node.
	 * <pre>
	 * 1) push the root in the stack
	 * 2)initialize previous as null
	 * 3)if stack is not empty, get the top element from the stack
	 * 4)if previous is null or current is equal to previous.left or previous.right
	 * 		i)if current.left is not null push the left into the stack
	 * 		ii) otherwise if current.right not equal to null push that into stack
	 * 5)if previous is equal to current.left
	 * 			i)	if current.right not null push it into stack
	 * 6)otherwise print the element and pop it from stack
	 * 7)make previous as current.
	 * So for tree with nodes as: root 1 with left child 2 and right child 3.
	 * and 2 has left as 4 and right as 5.
	 * and 3 has left as 6 and right as 7.
	 * below will be the flow:
	 * push 1 into stack     Stack[1]
	 * previous as null
	 * current is 1 (top of stack)
	 * since previous as null and 1 has left child so push 2 into stack Stack[2, 1]
	 * previous = current, which will be 1
	 * next iteration
	 * current will be 2 (again top of stack)
	 * since current(2) is left of previous(1) and 2 has left child so 4 will be pushed in stack 	Stack[4, 2, 1]
	 * previous will be 2
	 * next iteration
	 * current will be 4, and it is left child of previous(2)  but have no child so will go to end and make previous
	 * also as 4.    Stack[4, 2, 1]
	 * next iteration
	 * previous = current = 4 which will not pass step 4 hence will go to step 6 and print 4 also pop 4 from stack
	 *  														Stack[2, 1]
	 *  next iteration:
	 *  current = 2(stack top)
	 *  it will not pass step4 but it will pass step 5 as 2 is parent of 4.
	 *  	hence it will check if it has right child and then it will push 5 in stack   Stack[5, 2, 1]
	 *  previous = 2
	 *  next iteration
	 *  current = 5
	 *  which will pass the step 4, however no child hence will go last and make previous also as 5
	 *  and same as 4 it will print 5 and pop it out 		Stack[2,1 ]
	 *  now we have seen that it has parsed left and then right tree of node 2.
	 *  next iteration:
	 *  current = 2 and previous = 5 which will not pass step 4 or 5 hence will go 2 step 6 and print and pop 2.
	 *  																				Stack [1]
	 *   now we have parsed left tree of root 1 and it will parse the right same as it did for node 2.
	 * </pre>
	 */
	public void postOrderNonRecursive() {
		if (null == root) {
			return;
		}
		Node<E> p = root;
		LinkedListStack<Node<E>> stack = new LinkedListStack<>();
		stack.push(p);
		Node<E> previous = null;
		while (!stack.isEmpty()) {
			Node<E> current = stack.getTop();
			if (null == previous || current.equals(previous.left) || current.equals(previous.right)) {
				if (null != current.left) {
					stack.push(current.left);
				} else if (null != current.right) {
					stack.push(current.right);
				}
			} else if (previous.equals(current.left)) {
				if (null != current.right) {
					stack.push(current.right);
				}
			} else {
				System.out.printf(current.item + " ");
				stack.pop();
			}
			previous = current;
		}
	}

	public void levelOrderTraversal() {
		Node<E> p = root;
		Node<E> temp;
		LinkedListQueue<Node<E>> queue = new LinkedListQueue<>();
		if (null == p) {
			return;
		}
		queue.enQueue(p);
		while (!queue.isEmpty()) {
			temp = queue.deQueue();
			System.out.printf(temp.item + " ");
			if (temp.left != null) {
				queue.enQueue(temp.left);
			}
			if (temp.right != null) {
				queue.enQueue(temp.right);
			}
		}
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		populateTree(tree);
		System.out.println("PreOrder Recursive: ");
		tree.preOrderTraversal(tree.root);
		System.out.println("PreOrder NonRecursive: ");
		tree.preOrderNonRecursive();

		System.out.println("InOrder Recursive: ");
		tree.inOrderTraversal(tree.root);
		System.out.println("InOrder NonRecursive: ");
		tree.InOrderNonRecursive();

		System.out.println("PostOrder Recursive: ");
		tree.postOrderTraversal(tree.root);
		System.out.println("PostOrder NonRecursive: ");
		tree.postOrderNonRecursive();

		tree.levelOrderTraversal();
	}

	private static void populateTree(BinaryTree<Integer> tree) {
		tree.root = new Node<>(1, null, null);
		tree.root.left = new Node<>(2, null, null);
		tree.root.left.left = new Node<>(4, null, null);
		tree.root.left.right = new Node<>(5, null, null);
		tree.root.right = new Node<>(3, null, null);
		tree.root.right.left = new Node<>(6, null, null);
		tree.root.right.right = new Node<>(7, null, null);
	}
}
