package chapter6.problems.generictree;

/**
 * Created by mishrk3 on 8/10/2016.
 */
public class SumOfAllNodes {

    public int sum(GenericTree.Node<Integer> root) {
        if (null == root) {
            return 0;
        }
        return root.item + sum(root.firstChild) + sum(root.nextSibling);
    }
}
