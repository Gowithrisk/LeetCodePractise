package no107levelOrderBottom;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> resultss = new ArrayList<>();
        List<List<Integer>> results2 = new ArrayList<>();
        levelOrderBottom(root, resultss, 0);

        for (int i = resultss.size() - 1; i >= 0; i--) {
            if (resultss.get(i).size() == 0) {
                continue;
            }
            results2.add(resultss.get(i));
        }

        return results2;
    }

    private void levelOrderBottom(TreeNode node, List<List<Integer>> lists, int depth) {
        lists.add(new ArrayList<Integer>());

        if (node == null) {
            return;
        }
        levelOrderBottom(node.left, lists, depth + 1);
        levelOrderBottom(node.right, lists, depth + 1);
        lists.get(depth).add(node.val);
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> oneLevel = new ArrayList<>();
            // 每次都取出一层的所有数据
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                oneLevel.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            // 每次都往队头塞
            result.addFirst(oneLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t3;
        t3 = new TreeNode(3);
        t3.left = new TreeNode(9);
        t3.right = new TreeNode(20);

        t3.right.left = new TreeNode(15);
        t3.right.right = new TreeNode(7);
        System.out.println("expect is 15,7,; 9,20,; 3; result is:" + printlll(new Solution().levelOrderBottom2(t3)));
    }

    public static String printlll(List<List<Integer>> sss) {
        String temp = "";
        for (List<Integer> ss : sss) {
            for (Integer i : ss) {
                temp += i + ",";
            }
            temp += ";";
        }
        return temp;
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