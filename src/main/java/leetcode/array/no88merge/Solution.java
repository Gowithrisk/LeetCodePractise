package array.no88merge;

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) {
            return;
        }

        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i]=nums2[i];
            }
            return;
        }

        int l = m;
        int r = 0;
        while (r < n) {
            nums1[l] = nums2[r];
            l++;
            r++;
        }

        if (nums2[0] >= nums1[m - 1]) {
            return;
        }

        //order nums1;
        Arrays.sort(nums1);

        String temp = "";
        for (int i = 0; i < nums1.length; i++) {
            temp += String.valueOf(nums1[i]) + ",";
        }
        System.out.println(temp);
    }

    public static void main(String[] args) {
        System.out.println("expect 1,2,2,3,5,6; result is:");
        new Solution().merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);

        System.out.println("expect 1,2; result is:");
        new Solution().merge(new int[]{2, 0,}, 1, new int[]{1}, 1);

        System.out.println("expect 2,5,6; result is:");
        new Solution().merge(new int[]{0, 0, 0}, 0, new int[]{2, 5, 6}, 3);

        System.out.println("expect 1; result is:");
        new Solution().merge(new int[]{0}, 0, new int[]{1}, 1);
    }
}
