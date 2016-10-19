package chapter6.problems.bst;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.abs;

import chapter5.LinkedListQueue;
import chapter6.problems.binarytree.SampleBinaryTree;

/**
 * Created by mishrk3 on 10/19/2016.
 */

/**
 * Given a BST and a key, find an element in BST which is closest to key.
 */
public class ClosestInBST {

    int closestElement(Node<Integer> root, int key) {
        Node<Integer> temp;
        Node<Integer> element = null;
        LinkedListQueue<Node<Integer>> queue = new LinkedListQueue<>();
        int difference = MAX_VALUE;
        if (root == null) {
            return 0;
        }
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            temp = queue.deQueue();
            if (difference > abs(temp.item - key)) {
                difference = abs(temp.item - key);
                element = temp;
            }
            if (temp.left != null) {
                queue.enQueue(temp.left);
            }
            if (temp.right != null) {
                queue.enQueue(temp.right);
            }
        }
        return element.item;
    }

    public Node<Integer> findClosestRec(Node<Integer> root, int key) {
        Node<Integer> temp;
        if (root == null) {
            return root;
        }
        if (root.item == key) {
            return root;
        }
        if (root.item > key) {
            if (root.left == null) {
                return root;
            } else {
                temp = findClosestRec(root.left, key);
                return abs(temp.item - key) > abs(root.item - key) ? root : temp;
            }
        } else {
            if (root.right == null) {
                return root;
            } else {
                temp = findClosestRec(root.right, key);
                return abs(temp.item - key) > abs(root.item - key) ? root : temp;
            }
        }
    }

    public static void main(String[] args) {
        ClosestInBST closestInBST = new ClosestInBST();
        SampleBinaryTree<Integer> tree = SampleBinaryTree.getDefaultBST();
        int result = closestInBST.closestElement(tree.getRoot(), 4);
        Node<Integer> resultNode = closestInBST.findClosestRec(tree.getRoot(), 4);
        System.out.println("Closest Element in BST of 4 is: " + result);
        System.out.println("Closest Element in BST of 4 using recursion is: " + resultNode.item);

    }
}
