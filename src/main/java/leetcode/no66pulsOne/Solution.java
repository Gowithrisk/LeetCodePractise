package no66pulsOne;

public class Solution {
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] / 10 == 0) {
                return digits;
            } else {
                digits[i] = digits[i] - 10;
            }
        }

        if (digits[0] == 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }

        return digits;
    }

    public static void main(String[] args) {
        System.out.println("expect:124 result is:" + printlll(new Solution().plusOne(new int[]{1, 2, 3})));
        System.out.println("expect:2 result is:" + printlll(new Solution().plusOne(new int[]{1})));
        System.out.println("expect:1000 result is:" + printlll(new Solution().plusOne(new int[]{9, 9, 9})));
    }

    public static String printlll(int[] results) {
        String temp = "";
        for (int i = 0; i < results.length; i++) {
            temp += results[i];
        }
        return temp;
    }
}
