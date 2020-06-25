package leetcode.tree.no111minDepth;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int curDept = 1;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<Pair<TreeNode, Integer>>();
        queue.offer(new Pair<TreeNode, Integer>(root, 1));
        Pair<TreeNode, Integer> nodePair = null;
        while (!queue.isEmpty()) {
            nodePair = queue.poll();
            if (nodePair.getKey().left == null && nodePair.getKey().right == null) {
                return nodePair.getValue();
            }
            if (nodePair.getKey().left != null) {
                queue.offer(new Pair<TreeNode, Integer>(nodePair.getKey().left, nodePair.getValue() + 1));
            }
            if (nodePair.getKey().right != null) {
                queue.offer(new Pair<TreeNode, Integer>(nodePair.getKey().right, nodePair.getValue() + 1));
            }
        }

        return curDept;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);

        System.out.println("expect is 2, result is :" + new Solution3().minDepth(t));
    }
}
