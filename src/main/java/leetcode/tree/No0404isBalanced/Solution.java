package tree.No0404isBalanced;

import java.util.LinkedList;
import java.util.Queue;


public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
            return false;
        }
        System.out.println("xxxxxxxxxx");
        //µÝ¹é×Ó½Úµã;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 1;
        }
        System.out.println(node.val);
        int leftDepth = maxDepth(node.left) + 1;
        int rightDepth = maxDepth(node.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }

    public boolean isBalanced2(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);

        int minDepth = 1;
        int index = 1;
        int size = 1;
        TreeNode node = null;
        while (!queue.isEmpty()) {
            size = queue.size();

            index++;
            for (int i = 0; i < size; i++) {
                node = queue.poll();

                if (minDepth == 1 && (node.left == null || node.right == null)) {
                    minDepth = index;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            if ((index - minDepth) > 1) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        // [1,2,2,3,null,null,3,4,null,null,4]
        TreeNode t4;
        t4 = new TreeNode(1);
        t4.left = new TreeNode(2);
        t4.right = new TreeNode(22);

        t4.left.left = new TreeNode(3);
        t4.right.right = new TreeNode(33);

        t4.left.left.left = new TreeNode(4);
        t4.right.right.right = new TreeNode(44);

        System.out.println("expect is false; result is:" + new Solution().isBalanced(t4));

// [1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5]

        TreeNode t3;
        t3 = new TreeNode(1);
        t3.left = new TreeNode(2);
        t3.right = new TreeNode(2);

        t3.left.left = new TreeNode(3);
        t3.left.right = new TreeNode(3);
        t3.right.left = new TreeNode(3);
        t3.right.right = new TreeNode(3);

        t3.left.left.left = new TreeNode(4);
        t3.left.left.right = new TreeNode(4);
        t3.left.right.left = new TreeNode(4);
        t3.left.right.right = new TreeNode(4);

        t3.right.left.left = new TreeNode(4);
        t3.right.left.right = new TreeNode(4);

        t3.left.left.left.left = new TreeNode(5);
        t3.left.left.right.right = new TreeNode(5);

        System.out.println("expect is true; result is:" + new Solution().isBalanced(t3));

        TreeNode t1;
        t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);

        t1.right.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);

        System.out.println("expect is true; result is:" + new Solution().isBalanced(t1));

        TreeNode t2;
        t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(2);

        t2.left.left = new TreeNode(3);
        t2.left.right = new TreeNode(3);

        t2.left.left.left = new TreeNode(4);
        t2.left.left.right = new TreeNode(4);

        System.out.println("expect is false; result is:" + new Solution().isBalanced(t2));
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