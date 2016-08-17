package chapter6.problems.generictree;

/**
 * Created by mishrk3 on 8/9/2016.
 */

/**
 * A generic tree is generally represented as first child/Sibling representation as below:
 * 1)At each node link children of same parent(Sibling) from left to right.
 * 2)Remove link from parent to all the children except the first child(left most).
 * <p>
 * If we look at above algorithm any node will have max two child either next sibling or first child or both.
 * Only thing difference from Binary tree with the generic is it does not has any concept of left and right.
 */
public class GenericTree<E> {

    public Node<E> root;

    public static class Node<E> {
        E item;
        Node<E> firstChild;
        Node<E> nextSibling;

        public Node(E item, Node<E> firstChild, Node<E> nextSibling) {
            this.item = item;
            this.firstChild = firstChild;
            this.nextSibling = nextSibling;
        }
    }

    public Node<E> getRoot() {
        return root;
    }

    public static GenericTree<Integer> createTree() {
        GenericTree<Integer> tree = new GenericTree<>();
        tree.root = new Node<Integer>(1, null, null);
        tree.root.firstChild = new Node<Integer>(2, null, null);
        tree.root.firstChild.nextSibling = new Node<Integer>(3, null, null);
        tree.root.firstChild.nextSibling.firstChild = new Node<Integer>(6, null, null);
        tree.root.firstChild.nextSibling.firstChild.nextSibling = new Node<Integer>(7, null, null);
        tree.root.firstChild.nextSibling.nextSibling = new Node<Integer>(4, null, null);
        tree.root.firstChild.nextSibling.nextSibling.firstChild = new Node<Integer>(8, null, null);
        tree.root.firstChild.nextSibling.nextSibling.nextSibling = new Node<Integer>(5, null, null);
        tree.root.firstChild.nextSibling.nextSibling.nextSibling.firstChild = new Node<Integer>(9, null, null);
        tree.root.firstChild.nextSibling.nextSibling.nextSibling.firstChild.nextSibling = new Node<Integer>(10, null,
                null);
        tree.root.firstChild.nextSibling.nextSibling.nextSibling.firstChild.nextSibling.nextSibling = new Node<Integer>(
                11, null, null);
    return tree;
    }
}
