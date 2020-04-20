public class Solution {
    public int largestRectangleArea(int[] heights) {

        if (null == heights || heights.length == 0) {
            return 0;
        }

        if (heights.length == 1) {
            return heights[0];
        }

        int result = 0;
        int calcResult = 0;
        int lenght = 0;
        int hegiht = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] == 0) {
                lenght = 0;
            } else {
                lenght = 1;
                hegiht = heights[i];
                calcResult = lenght * hegiht;
                if (calcResult > result) {
                    result = calcResult;
                }
            }
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] == 0) {
                    lenght = 0;
                    hegiht = 0;
                    continue;
                }

                lenght++;
                if (heights[j] != 0 && heights[j] < hegiht) {
                    hegiht = heights[j];
                }

                calcResult = lenght * hegiht;
                if (calcResult > result) {
                    result = calcResult;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println("expect=10; result=" + new Solution().largestRectangleArea(new int[]{0, 9, 0, 10}));
        System.out.println("expect=10; result=" + new Solution().largestRectangleArea(new int[]{0, 9, 0, 10, 0}));
        System.out.println("expect=10; result=" + new Solution().largestRectangleArea(new int[]{9, 0, 10, 0}));
        System.out.println("expect=10; result=" + new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println("expect=9; result=" + new Solution().largestRectangleArea(new int[]{9, 0}));
        System.out.println("expect=9; result=" + new Solution().largestRectangleArea(new int[]{0, 9}));
        System.out.println("expect=9; result=" + new Solution().largestRectangleArea(new int[]{0, 9, 0}));
        System.out.println("expect=9; result=" + new Solution().largestRectangleArea(new int[]{0, 0, 9, 0}));


        System.out.println("expect=0; result=" + new Solution().largestRectangleArea(new int[]{0}));
        System.out.println("expect=1; result=" + new Solution().largestRectangleArea(new int[]{1}));
        System.out.println("expect=2; result=" + new Solution().largestRectangleArea(new int[]{1, 2}));
        System.out.println("expect=2; result=" + new Solution().largestRectangleArea(new int[]{2, 1}));
    }
}
