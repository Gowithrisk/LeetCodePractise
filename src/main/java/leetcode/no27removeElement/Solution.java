package no27removeElement;

public class Solution {
    public int removeElement(int[] nums, int val) {

        int count = 0;

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int index = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[index] = nums[j];
                index++;
                count++;
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
        System.out.println("expect:1," + new Solution().removeElement(new int[]{1, 1, 2}, 1));
        System.out.println("expect:2," + new Solution().removeElement(new int[]{1, 1, 2}, 2));
        System.out.println("expect:1," + new Solution().removeElement(new int[]{1, 1, 1, 1, 1, 5}, 1));
        System.out.println("expect:4," + new Solution().removeElement(new int[]{1, 2, 2, 3, 3, 5}, 3));
        System.out.println("expect:0," + new Solution().removeElement(new int[]{1}, 1));
        System.out.println("expect:1," + new Solution().removeElement(new int[]{1, 3, 3}, 3));
        System.out.println("expect:2," + new Solution().removeElement(new int[]{1, 2, 3}, 2));
    }
}


