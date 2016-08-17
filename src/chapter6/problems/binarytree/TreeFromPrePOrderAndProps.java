package chapter6.problems.binarytree;

/**
 * Created by mishrk3 on 8/9/2016.
 */

/**
 * A tree with special property where leaves are represented with L and internal node with I. Also assume that each node
 * has either 0 or 2 children. Given preorder Traversal construct the tree.
 */
public class TreeFromPrePOrderAndProps {

    private int i = 0;

    /**
     * @param preOrder preorder traversal
     * @return root node of the Tree
     * <p>
     * preOrder traversal means first root will come and then preOrder traversal of left subtree followed by that of
     * right subtree.
     * In normal case it is impossible to find where left subtree ends and the right one starts. In our case every node
     * has either 0 or 2 child. So if a node exists it's sibling also exists. Hence  every time if we are computing a
     * subtree we need to compute it's sibling subtree as well.
     * <p>
     * Secondly whenever we get L in the input string that is leaf node and we can stop for that subtree. if L node is
     * left child of the parent then we need to look for the sibling of the L. If L is right child then we need to go
     * up in the hierarchy and look for next subtree.
     * <p>
     * e.g for a given preOrder: IILLILL below code will behave like:
     * <p>
     * first call ({'I', 'L', 'I', 'L', 'L'}) and i= 0 since array is not null as well as 0th element is not equal to L
     * hence it will trigger below call:
     * ({'I', 'L', 'I', 'L', 'L'}) with i= 1
     * <p>
     * Executing ({'I', 'L', 'I', 'L', 'L'}) since 1st element is not L hence this call will fire another recursion:
     * ({'I', 'L', 'I', 'L', 'L'}) with i = 2 which is L and will end the recursion and then come to calculate it's
     * sibling subtree.
     * ({'I', 'L', 'I', 'L', 'L'}) with i = 3 that will also end recursion but will be back to up in the hierarchy to
     * look for next subtree and make the call as :
     * Executing ({'I', 'L', 'I', 'L', 'L'}) with i = 4
     *
     * and that is how it continues.....
     *
     * On below code i keeps the track if the element to be traversed.
     */
    public SampleBinaryTree.Node<Character> buildTreeFromPreOrder(Character[] preOrder) {
        if (preOrder == null) {
            return null;
        }
        SampleBinaryTree.Node<Character> newNode = new SampleBinaryTree.Node<>(preOrder[i], null, null);
        if (preOrder[i] == 'L') {
            return newNode;
        }
        i = i + 1;
        newNode.left = buildTreeFromPreOrder(preOrder);
        i = i + 1;
        newNode.right = buildTreeFromPreOrder(preOrder);
        return newNode;
    }

    public static void main(String[] args) {
        TreeFromPrePOrderAndProps tpp = new TreeFromPrePOrderAndProps();
        Character[] preOrder = {'I', 'I', 'L', 'L', 'I', 'L', 'L'};
        SampleBinaryTree.Node<Character> root = tpp.buildTreeFromPreOrder(preOrder);
        System.out.println("The root node is: " + root.item);
    }
}
