package DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Solution {
    public void printlDFSTrack(TreeNode node) {
        if (node == null) {
//            System.out.print("null,");
            return;
        }

        System.out.print(node.val + ",");
        printlDFSTrack(node.right);
        printlDFSTrack(node.left);
    }

    public void printBFS(TreeNode node) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            System.out.print(node.val + ",");
            queue.poll();
        }

    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);

        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);

        t1.left.left.left = new TreeNode(8);
        t1.left.left.right = new TreeNode(9);
        t1.left.right.left = new TreeNode(10);
        t1.left.right.right = new TreeNode(11);

        t1.right.left = new TreeNode(6);
        t1.right.right = new TreeNode(7);

        t1.right.left.left = new TreeNode(12);
        t1.right.left.right = new TreeNode(13);

        t1.right.right.left = new TreeNode(14);
        t1.right.right.right = new TreeNode(15);


        new Solution().printBFS(t1);
        System.out.println("");
        new Solution().printlDFSTrack(t1);
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