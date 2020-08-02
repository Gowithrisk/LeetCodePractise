package leetcode.tree.offer55isBalanced;

public class Solution {

    int maxDepth = 0;


    public boolean isBalanced(TreeNode root) {

        if (null == root) {
            return true;
        }

        if (!subTree(root)) {
            return false;
        }

        if (root.left != null && !isBalanced(root.left)) {
            return false;
        }

        if (root.right != null && !isBalanced(root.right)) {
            return false;
        }

        return true;
    }

    private boolean subTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = 1;
        int rightDepth = 1;

        if (root.left != null) {
            leftDepth = loop(root.left, 1);
        }
        maxDepth = 0;
        if (root.right != null) {
            rightDepth = loop(root.right, 1);
        }

        if (Math.abs(leftDepth - rightDepth) <= 1) {
            return true;
        } else {
            return false;
        }
    }

    private int loop(TreeNode node, int deep) {
        if (node == null) {
            return deep;
        }

        deep++;
        if (node.left == null && node.right == null) {
            maxDepth = Math.max(maxDepth, deep);
        }

        loop(node.left, deep);
        loop(node.right, deep);
        return maxDepth;
    }

    public static void main(String[] args) {
        // [2,1,3,0,7,9,1,2,null,1,0,null,null,8,8,null,null,null,null,7] true
        TreeNode t4 = new TreeNode(2);
        t4.left = new TreeNode(1);
        t4.right = new TreeNode(3);
        t4.left.left = new TreeNode(0);
        t4.left.right = new TreeNode(7);
        t4.right.left = new TreeNode(9);
        t4.right.right = new TreeNode(1);
        t4.left.left.left = new TreeNode(2);
        t4.left.right.left = new TreeNode(1);
        t4.left.right.right = new TreeNode(0);
        t4.left.right.right.right = new TreeNode(0);
        System.out.println("expect true, result is: " + new Solution().isBalanced(t4));

        // [1,2,2,3,null,null,3,4,null,null,4] false
        TreeNode t3 = new TreeNode(1);
        t3.left = new TreeNode(2);
        t3.right = new TreeNode(2);

        t3.left.left = new TreeNode(3);
        t3.right.right = new TreeNode(3);

        t3.left.left.left = new TreeNode(4);
        t3.right.right.right = new TreeNode(4);
        System.out.println("expect false, result is: " + new Solution().isBalanced(t3));


        // [1,null,2,null,3] false
        TreeNode t2 = new TreeNode(1);
        t2.right = new TreeNode(2);
        t2.right.right = new TreeNode(3);
        System.out.println("expect false, result is: " + new Solution().isBalanced(t2));

        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);
        System.out.println("expect true, result is: " + new Solution().isBalanced(t));

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(2);

        t1.left.left = new TreeNode(15);
        t1.left.right = new TreeNode(7);

        t1.left.left.left = new TreeNode(15);
        t1.left.left.right = new TreeNode(15);
        System.out.println("expect false, result is: " + new Solution().isBalanced(t1));
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