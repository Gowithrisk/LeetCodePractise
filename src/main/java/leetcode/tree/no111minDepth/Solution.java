package leetcode.tree.no111minDepth;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        int currentDep = 0;
        TreeNode t = null;

        while (!queue.isEmpty()) {
            currentDep++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                t = queue.poll();
                if (t.left == null && t.right == null) {
                    result = Math.min(result, currentDep);
                    continue;
                }
                queue.add(root.left);
                queue.add(root.right);
            }
        }
        return result;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}