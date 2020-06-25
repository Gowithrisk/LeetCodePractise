package leetcode.tree.no111minDepth;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }
        int currentDep = 0;
        int result = Integer.MAX_VALUE;
        if (root.left != null) {
            currentDep = minDepth(root.left);
            result = Math.min(currentDep, result);
        }

        if (root.right != null) {
            currentDep = minDepth(root.right);
            result = Math.min(result, currentDep);
        }
        return result + 1;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);

        System.out.println("expect is 2, result is :" + new Solution2().minDepth(t));
    }

}

