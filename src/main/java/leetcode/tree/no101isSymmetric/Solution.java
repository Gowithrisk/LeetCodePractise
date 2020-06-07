package tree.no101isSymmetric;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isSysmtric(root.left, root.right);
    }

    private boolean isSysmtric(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }

        if ((null == left && null != right) || (null != left && null == right) || left.val != right.val) {
            return false;
        }

        return isSysmtric(left.left, right.right) && isSysmtric(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode t1;
        // [          9,
        //     -42,              -42,
        // null,    76,        76,   null,
        //        null, 13, null,13       ]
        t1 = new TreeNode(9);

        t1.left = new TreeNode(-42);
        t1.right = new TreeNode(-42);

//        t1.left.left = new TreeNode(null);
        t1.left.right = new TreeNode(76);
        t1.right.left = new TreeNode(76);
//        t1.right.right = new TreeNode(null);


//        t1.left.left.left = new TreeNode(null);
        t1.left.right.right = new TreeNode(13);
//        t1.left.right.left = new TreeNode(null);
        t1.right.left.right = new TreeNode(13);

        System.out.println("expect is false; result is:" + new Solution().isSymmetric(t1));


        t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.left.left = new TreeNode(3);
        t1.left.right = new TreeNode(4);

        t1.right = new TreeNode(2);
        t1.right.left = new TreeNode(3);
        t1.right.right = new TreeNode(4);
        System.out.println("expect is false; result is:" + new Solution().isSymmetric(t1));


        t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.left.left = new TreeNode(3);
        t1.left.right = new TreeNode(4);

        t1.right = new TreeNode(2);
        t1.right.left = new TreeNode(4);
        t1.right.right = new TreeNode(3);
        System.out.println("expect is true; result is:" + new Solution().isSymmetric(t1));


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