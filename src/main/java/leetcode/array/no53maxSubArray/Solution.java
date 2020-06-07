package array.no53maxSubArray;

public class Solution {

    public int maxSubArray(int[] nums) {

        int l = 0;
        int result = nums[0];
        int tempResult = 0;
        for (int i = 0; i < nums.length; i++) {
            l = i + 1;
            tempResult = nums[i] > 0 ? nums[i] : 0;
            while (l < nums.length) {
                tempResult += nums[l];
                if (tempResult > result) {
                    result = tempResult;
                }
                l++;
            }

        }
        return result;

    }

    public static void main(String[] args) {

        //  [-2,1,-3,4,-1,2,1,-5,4],  6
        System.out.println("expect 6, result is :" + new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println("expect 0, result is :" + new Solution().maxSubArray(new int[]{0}));
        System.out.println("expect 1, result is :" + new Solution().maxSubArray(new int[]{1}));
        System.out.println("expect 1, result is :" + new Solution().maxSubArray(new int[]{0, 1}));
        System.out.println("expect 3, result is :" + new Solution().maxSubArray(new int[]{1, 2}));
        System.out.println("expect 1, result is :" + new Solution().maxSubArray(new int[]{-2, 1}));
    }

}
