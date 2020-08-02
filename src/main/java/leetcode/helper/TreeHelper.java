package leetcode.helper;

import leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeHelper {
    public static void printTreeNode(TreeNode node) {

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(node);

        TreeNode n;
        int level = 0;
        int size = 0;
        System.out.println("--------------------------------BEGIN---------------------------------------------------");
        while (!queue.isEmpty()) {
            size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                n = queue.poll();
                System.out.println(String.format("level:%s, node:[%s], ID:[%s]", level, n.val, n));
                if (n.left != null) {
                    queue.offer(n.left);
                }
                if (n.right != null) {
                    queue.offer(n.right);
                }
            }
        }
        System.out.println("--------------------------------END---------------------------------------------------");
    }

    public static TreeNode string2Treenode(String input) {
        if (input == null || input.equals("") || input.equals("[]")) {
            return null;
        }
        input = input.replace("[", "").replace("]", "");
        String[] temps = input.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(temps[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = null;

        int queueSize = 0;
        int polltimes = getN(temps.length);
        int tempsLocation = 1;

        queue.offer(root);
        for (int i = 0; i <= polltimes; i++) {
            queueSize = queue.size();
            for (int k = 0; k < queueSize; k++) {
                node = queue.poll();
                if (tempsLocation >= temps.length) {
                    break;
                }
                if (!"null".equals(temps[tempsLocation])) {
                    node.left = new TreeNode(Integer.parseInt(temps[tempsLocation]));
                    tempsLocation++;
                    queue.offer(node.left);
                    //System.out.println(String.format("tempsLocation:[%s];Value:[%s]; polltimes:%s", tempsLocation, node.left.val, polltimes));
                }
                if (tempsLocation >= temps.length) {
                    break;
                }
                if (!"null".equals(temps[tempsLocation])) {
                    node.right = new TreeNode(Integer.parseInt(temps[tempsLocation]));
                    tempsLocation++;
                    queue.offer(node.right);
                    // System.out.println(String.format("tempsLocation:[%s];Value:[%s]; polltimes:%s", tempsLocation, node.right.val, polltimes));
                }
            }

        }

        return root;
    }


    private static int getN(int number) {
        return nCount2NCiFang(number) - 1;
    }

    private static int nCount2NCiFang(int number) {
        if (number < 2) {
            return 1;
        }
        return nCount2NCiFang(number / 2) + 1;
    }

    public static void main(String[] args) {
        System.out.println("0:" + getN(+0));
        System.out.println("1:" + getN(1));
        System.out.println("2:" + getN(2));
        System.out.println("3:" + getN(3));
        System.out.println("4:" + getN(4));
        System.out.println("5:" + getN(5));
        System.out.println("6:" + getN(6));
        System.out.println("7:" + getN(7));
        System.out.println("8:" + getN(8));
        System.out.println("9:" + getN(9));
        System.out.println("10:" + getN(10));
        System.out.println("11:" + getN(11));
        System.out.println("12:" + getN(12));
        System.out.println("13:" + getN(13));
        System.out.println("14:" + getN(14));
        System.out.println("16:" + getN(16));
        System.out.println("64:" + getN(64));
    }

}
