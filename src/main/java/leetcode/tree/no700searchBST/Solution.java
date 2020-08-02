package leetcode.tree.no700searchBST;

public class Solution {
    TreeNode result = null;

    public TreeNode searchBST(TreeNode root, int val) {
        if (null == root) {
            return null;
        }

        if (val == root.val) {
            result = root;
            return result;
        }
        if (result == null) searchBST(root.left, val);
        if (result == null) searchBST(root.right, val);
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