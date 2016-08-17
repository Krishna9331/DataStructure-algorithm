package chapter6.problems.binarytree;

/**
 * Created by mishrk3 on 8/9/2016.
 */

import chapter5.LinkedListQueue;

/**
 * Given a binary tree with three pointers left, right and nextSibling give an algorithm for filling the nextSibling
 * assuming they are NULL initially.
 * <p>
 * The problem can be solved using BFS traversal as each node is followed by it's next sibling.
 */
public class NextSiblingUsingLeftRight<E> {

    private static class BinaryTree<E> {
        Node<E> root;

        static class Node<E> {
            E item;
            Node<E> left;
            Node<E> right;
            Node<E> nextSibling;

            public Node(E item, Node<E> left, Node<E> right, Node<E> nextSibling) {
                this.item = item;
                this.left = left;
                this.right = right;
                this.nextSibling = nextSibling;
            }
        }
    }

    void fillingNext(BinaryTree.Node<E> root) {
        BinaryTree.Node<E> temp = null;
        LinkedListQueue<BinaryTree.Node<E>> queue = new LinkedListQueue<>();
        if (null == root) {
            return;
        }

        queue.enQueue(root);
        queue.enQueue(null);
        while (!queue.isEmpty()) {
            temp = queue.deQueue();

            if (null == temp) {
                if (!queue.isEmpty()) {
                    queue.enQueue(null);
                }
            } else {
                temp.nextSibling = queue.getFront();
                if (null != temp.left) {
                    queue.enQueue(temp.left);
                }
                if (null != temp.right) {
                    queue.enQueue(temp.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        NextSiblingUsingLeftRight<Integer> ns = new NextSiblingUsingLeftRight<>();
        BinaryTree tree = getSampleTree();
        ns.fillingNext(tree.root);
        System.out.println("Tree relations has been established");
    }

    private static BinaryTree getSampleTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = new BinaryTree.Node<>(1, null, null, null);
        tree.root.left = new BinaryTree.Node<>(2, null, null, null);
        tree.root.left.left = new BinaryTree.Node<>(4, null, null, null);
        tree.root.left.right = new BinaryTree.Node<>(11, null, null, null);
        tree.root.right = new BinaryTree.Node<>(3, null, null, null);
        tree.root.right.left = new BinaryTree.Node<>(6, null, null, null);
        tree.root.right.right = new BinaryTree.Node<>(7, null, null, null);
        return tree;
    }

}
