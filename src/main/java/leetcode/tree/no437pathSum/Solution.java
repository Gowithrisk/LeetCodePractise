package tree.no437pathSum;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * 示例：
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * 返回 3。和等于 8 的路径有:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 * <p>
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 */
public class Solution {

    public int count = 0;

    public int pathSum(TreeNode root, int sum) {
        if (null == root) {
            return 0;
        }
        sumLoop(root, sum);


        if (null != root.left) {
            System.out.println("next left node; sum:" + sum + ", node began at:" + root.left.val);
            pathSum(root.left, sum);
        }

        if (null != root.right) {
            System.out.println("next right node; sum:" + sum + ", node began at:" + root.right.val);
            pathSum(root.right, sum);
        }
        return count;
    }


    public int sumLoop(TreeNode root, int sum) {

        if (null == root) {
            System.out.println();
            return 0;
        }

        int minus = sum - root.val;
        System.out.print(root.val + "(" + minus + ")" + ",");

        if (minus == 0) {
            System.out.println("Bingo");
            count++;
        }

        sumLoop(root.left, minus);
        sumLoop(root.right, minus);

        return count;
    }

    public static void main(String[] args) {
        // [1,-2,-3,1,3,-2,null,-1]  -1
        TreeNode t3;
        t3 = new TreeNode(1);
        t3.left = new TreeNode(-2);
        t3.right = new TreeNode(-3);

        t3.left.left = new TreeNode(1);
        t3.left.right = new TreeNode(3);

        t3.right.left = new TreeNode(-2);

        t3.left.left.left = new TreeNode(-1);
        System.out.println("expect is 4; result is:" + new Solution().pathSum(t3, -1));

        // [-2,null,-3]  -3
        TreeNode t2;
        t2 = new TreeNode(-2);
        t2.right = new TreeNode(-3);
        System.out.println("expect is 1; result is:" + new Solution().pathSum(t2, -3));

        //root = [1], sum = 1
        TreeNode t1;
        t1 = new TreeNode(1);
        System.out.println("expect is 1; result is:" + new Solution().pathSum(t1, 1));

        //root = [10, 5,-3, 3,2,null,11, 3,-2,null,1], sum = 8
        TreeNode t4;
        t4 = new TreeNode(10);
        t4.left = new TreeNode(5);
        t4.right = new TreeNode(-3);

        t4.left.left = new TreeNode(3);
        t4.left.right = new TreeNode(2);

        t4.right.right = new TreeNode(11);

        t4.left.left.left = new TreeNode(3);
        t4.left.left.right = new TreeNode(-2);

        t4.left.right.right = new TreeNode(1);

        System.out.println("expect is 3; result is:" + new Solution().pathSum(t4, 8));

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