package array.no1343numOfSubarrays;

public class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        if (null == arr || arr.length == 0) {
            return 0;
        }

        int count = 0;
        int result = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            result += arr[i];
            if (result == threshold) {
                return i;
            }
        }

        return 0;

    }

    public int loop(int[] arr, int index, int result) {

        if (null == arr || arr.length == 0) {
            return 0;
        }


        return 0;

    }



    public static void main(String[] args) {
        System.out.println("expect is 3, the result is:" + new Solution().numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
        System.out.println("expect is 5, the result is:" + new Solution().numOfSubarrays(new int[]{1, 1, 1, 1, 1}, 1, 0));
        System.out.println("expect is 6, the result is:" + new Solution().numOfSubarrays(new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5));
        System.out.println("expect is 1, the result is:" + new Solution().numOfSubarrays(new int[]{7, 7, 7, 7, 7, 7, 7}, 7, 7));
        System.out.println("expect is 1, the result is:" + new Solution().numOfSubarrays(new int[]{4, 4, 4, 4}, 4, 1));
    }
}
