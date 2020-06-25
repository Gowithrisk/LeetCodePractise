package leetcode.array.no26removeDuplicates;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 1;
        int l1 = 0;
        int l2 = 1;
        while (l2 < nums.length) {
            if (nums[l1] == nums[l2]) {
                l2++;
                continue;
            } else if (nums[l1] != nums[l2]) {
                l1++;
                count++;
                nums[l1] = nums[l2];
            }
        }

        String temp = "";
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i] + ",";
        }
        System.out.println(temp);
        return count;
    }


    public static void main(String[] args) {
        System.out.println("expect:2," + new Solution().removeDuplicates(new int[]{1, 1, 2}));
        System.out.println("expect:2," + new Solution().removeDuplicates(new int[]{1, 1, 1, 1, 1, 5}));
        System.out.println("expect:4," + new Solution().removeDuplicates(new int[]{1, 2, 2, 3, 3, 5}));
        System.out.println("expect:1," + new Solution().removeDuplicates(new int[]{1}));
        System.out.println("expect:2," + new Solution().removeDuplicates(new int[]{1, 3, 3}));
        System.out.println("expect:3," + new Solution().removeDuplicates(new int[]{1, 2, 3}));
    }
}
