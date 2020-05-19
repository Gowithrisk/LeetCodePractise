package no104maxDepth;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }


    public static void main(String[] args) {
        // [-8, -6,7,  6,null, null,null,    null,5]
        TreeNode t3;
        t3 = new TreeNode(-8);
        t3.left = new TreeNode(-6);
        t3.right = new TreeNode(7);

        t3.left.left = new TreeNode(6);

        t3.left.left.right = new TreeNode(5);
        System.out.println("expect is 4; result is:" + new Solution().maxDepth(t3));

        // [3,9,20,null,null,15,7]£¬  3
        TreeNode t2;
        t2 = new TreeNode(3);
        t2.left = new TreeNode(9);
        t2.right = new TreeNode(20);

        t2.right.left = new TreeNode(15);
        t2.right.right = new TreeNode(7);
        System.out.println("expect is 3; result is:" + new Solution().maxDepth(t2));

        TreeNode t1;
        t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.left.left = new TreeNode(3);
        t1.left.right = new TreeNode(4);

        System.out.println("expect is 3; result is:" + new Solution().maxDepth(t1));


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