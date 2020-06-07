package tree.no100isSameTree;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (null == p && null == q) {
            return true;
        } else if (null != p && null != q && p.val == q.val) {
            if (isSameTree(p.left, q.left)) {
                return isSameTree(p.right, q.right);
            } else {
                return false;
            }
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);

        System.out.println("expect is true; result is:" + new Solution().isSameTree(t1, t2));

        t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t2.right = new TreeNode(2);
        System.out.println("expect is false; result is:" + new Solution().isSameTree(t1, t2));

        t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(1);

        t2.left = new TreeNode(1);
        t2.right = new TreeNode(2);

        System.out.println("expect is false; result is:" + new Solution().isSameTree(t1, t2));
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