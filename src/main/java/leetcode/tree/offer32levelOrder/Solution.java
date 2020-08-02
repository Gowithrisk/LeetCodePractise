package leetcode.tree.offer32levelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result;
        if (root == null) {
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        int size = 1;
        while (!queue.isEmpty()) {
            result = new ArrayList<Integer>();
            size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                result.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            results.add(result);
        }
        return results;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);
        List<List<Integer>> tt = new Solution().levelOrder(t);
        for (List<Integer> aa : tt) {
            String temp = "";
            for (int i = 0; i < aa.size(); i++) {
                temp += aa.get(i) + ",";
            }
            System.out.println(temp);
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