package no69mySqrt;

public class Solution {
    public int mySqrt(int x) {

        if (x <= 0) {
            return 0;
        }

        return  (int) Math.sqrt(x);

    }

    public static void main(String[] args) {
        System.out.println("expect 2, result is:" + new Solution().mySqrt(4));
        System.out.println("expect 2, result is:" + new Solution().mySqrt(8));
        System.out.println("expect 1, result is:" + new Solution().mySqrt(1));
        System.out.println("expect 0, result is:" + new Solution().mySqrt(0));
        System.out.println("expect 0, result is:" + new Solution().mySqrt(-1));

    }
}
