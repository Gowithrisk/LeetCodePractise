package leetcode.tree.no235lowestCommonAncestor;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return null;
        }

        if(p.val > q.val){
            TreeNode t1=p;
            p=q;
            q=t1;
        }
        if (root.val == p.val) {
            return p;
        } else if (root.val == q.val) {
            return q;
        }

        if (p.val < root.val && q.val > root.val) {
            return root;
        }else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }else {
            return lowestCommonAncestor(root.right, p, q);
        }
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