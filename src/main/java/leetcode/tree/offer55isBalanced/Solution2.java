package leetcode.tree.offer55isBalanced;

public class Solution2 {

    // ºÙ÷¶∑®
    public boolean isBalanced(TreeNode root) {

        if (null == root) {
            return false;
        }

        return false;

    }

    private boolean jianzhi(TreeNode root) {
        if (null == root) {
            return false;
        }
        jianzhi(root.left);
        return false;
    }

    public static void main(String[] args) {
        // [1,2,2,3,null,null,3,4,null,null,4] false
        TreeNode t3 = new TreeNode(1);
        t3.left = new TreeNode(2);
        t3.right = new TreeNode(2);

        t3.left.left = new TreeNode(3);
        t3.right.right = new TreeNode(3);

        t3.left.left.left = new TreeNode(4);
        t3.right.right.right = new TreeNode(4);
        System.out.println("expect false, result is: " + new Solution2().isBalanced(t3));


        // [1,null,2,null,3] false
        TreeNode t2 = new TreeNode(1);
        t2.right = new TreeNode(2);
        t2.right.right = new TreeNode(3);
        System.out.println("expect false, result is: " + new Solution2().isBalanced(t2));

        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);
        System.out.println("expect true, result is: " + new Solution2().isBalanced(t));

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(2);

        t1.left.left = new TreeNode(15);
        t1.left.right = new TreeNode(7);

        t1.left.left.left = new TreeNode(15);
        t1.left.left.right = new TreeNode(15);
        System.out.println("expect false, result is: " + new Solution2().isBalanced(t1));
    }
}
