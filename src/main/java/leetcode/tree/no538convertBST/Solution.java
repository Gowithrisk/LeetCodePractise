package leetcode.tree.no538convertBST;

public class Solution {

    int summary = 0;

    public TreeNode convertBST(TreeNode root) {
        loop(root);
        return root;
    }

    private void loop(TreeNode node) {
        if (node == null) {
            return ;
        }
        loop(node.right);
        summary += +node.val;
        node.val = summary;
        loop(node.left);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(2);
        t.right = new TreeNode(13);

        TreeNode result = new Solution().convertBST(t);
        System.out.println("expect is 18,20,13; the result is:");
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