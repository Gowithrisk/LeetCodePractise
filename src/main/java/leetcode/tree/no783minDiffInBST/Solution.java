package leetcode.tree.no783minDiffInBST;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    //题目理解错了，不是相邻两点，而是任意两点的最小差
    List<Integer> result = new ArrayList<Integer>();

    public int minDiffInBST(TreeNode root) {

        if (root == null) {
            return 0;
        }
        loop(root);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < result.size() - 1; i++) {
            min = Math.min(min, result.get(i + 1) - result.get(i));
        }
        return min;
    }

    private void loop(TreeNode node) {
        if (node == null) {
            return;
        }

        loop(node.left);
        result.add(node.val);
        loop(node.right);
    }

    // [90,69,null,49,89,null,52,null,null,null,null]
    public static void main(String[] args) {
        TreeNode t = new TreeNode(90);
        t.left = new TreeNode(69);
        t.left.left = new TreeNode(49);
        t.left.right = new TreeNode(89);
        t.left.left.right = new TreeNode(52);
        System.out.println("expect is 1 , the result is:" + new Solution().minDiffInBST(t));

        // [4,2,6,1,3,null,null]
        t = new TreeNode(4);
        t.left = new TreeNode(2);
        t.right = new TreeNode(6);
        t.left.left = new TreeNode(1);
        t.left.right = new TreeNode(3);
        System.out.println("expect is 1 , the result is:" + new Solution().minDiffInBST(t));
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