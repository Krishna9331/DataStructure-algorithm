package chapter6.problems.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mishrk3 on 8/1/2016.
 */
public class VerticalSum {
    HashMap<Integer, Integer> map = new HashMap<>();

    /**
     * @param root   The root of binary tree
     * @param column the column index of root default value id 0
     *               <p>
     *               The logic behind the algo is map root with column zero and whenever we move left reduce the column
     *               value by 1 and that of right we increase the value by 1.
     *               Store column versus sum traversed item in HashMap.
     */
    void verticalSumInBTree(SampleBinaryTree.Node<Integer> root, int column) {
        if (root == null) {
            return;
        }
        verticalSumInBTree(root.left, column - 1);
        int val = map.get(column) != null ? map.get(column) + root.item : root.item;
        map.put(column, val);
        verticalSumInBTree(root.right, column + 1);
    }

    public static void main(String[] args) {
        VerticalSum vs = new VerticalSum();
        SampleBinaryTree<Integer> tree = SampleBinaryTree.getDefaultTree();
        vs.verticalSumInBTree(tree.getRoot(), 0);
        for (Map.Entry<Integer, Integer> val : vs.map.entrySet()) {
            System.out.println(val.getKey() + "->" + val.getValue());
        }
    }
}
