package tree.no404sumOfLeftLeaves;

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {

        return sumLeftLeaves(root, true);
    }

    private int sumLeftLeaves(TreeNode node, boolean isLeft) {
        if (null == node) {
            return 0;
        }

        if (null == node.left && isLeft) {
            return node.val;
        }

        int x = 0;
        x += sumLeftLeaves(node.left, true);
        x += sumLeftLeaves(node.right, false);


        return x;
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