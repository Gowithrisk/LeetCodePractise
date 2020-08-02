package leetcode.tree.no000checkSequence;

public class Solution {
    public void showSequence(TreeNode t) {
        loopQianXu(t);
    }

    private void loopQianXu(TreeNode node) {
        if (node == null) {

            return;
        }
        //System.out.println("ÖÐÐò:" + node.value);
        loopQianXu(node.left);
        //System.out.println("Ç°Ðò(ËÑË÷Ê÷):" + node.value);
        loopQianXu(node.right);
        System.out.println("ºóÐò:" + node.value);
        return;
    }

//                   10
//	     8                     12
//	6        9             11         13
//	                                       22
//
    //mark1: 10,8,6,9,12,11,13,22
    //mark2: 6,8,9,10,11,12,13,22
    //mark3: 6,9,8,11,22,13,12,10
    public static void main(String[] args) {
        TreeNode t = new TreeNode(10);
        t.left = new TreeNode(8);
        t.right = new TreeNode(12);
        t.left.left = new TreeNode(6);
        t.left.right = new TreeNode(9);
        t.right.left = new TreeNode(11);
        t.right.right = new TreeNode(13);
        t.right.right.right = new TreeNode(22);
        new Solution().showSequence(t);

    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}