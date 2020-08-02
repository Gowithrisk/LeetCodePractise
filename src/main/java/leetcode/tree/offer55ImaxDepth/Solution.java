package leetcode.tree.offer55ImaxDepth;

public class Solution {
    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        return getMaxDepth(root, 0);
    }

    private int getMaxDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        depth++;
        if (node.left == null && node.right == null) {
            maxDepth = Math.max(maxDepth, depth);
        }
        getMaxDepth(node.left, depth);
        getMaxDepth(node.right, depth);
        return maxDepth;
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