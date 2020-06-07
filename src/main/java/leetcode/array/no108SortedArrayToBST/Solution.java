package array.no108SortedArrayToBST;

public class Solution {

    private int[] numss;

    public TreeNode sortedArrayToBST(int[] nums) {
        numss = nums;
        if (null == nums || nums.length == 0) {
            return null;
        }

        TreeNode top = new TreeNode(numss[(numss.length / 2)]);
        int left = 0;
        int right = numss.length - 1;
        return sorted(left, right);
    }

    private TreeNode sorted(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(numss[mid]);
        node.left = sorted(left + 1, mid);
        node.right = sorted(mid, right - 2);
        return node;
    }

    public static void main(String[] args) {
        System.out.println("" + new Solution().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
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