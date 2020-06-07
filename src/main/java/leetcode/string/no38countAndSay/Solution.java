package string.no38countAndSay;

public class Solution {
    public String countAndSay(int n) {
        String result = "";

        result = count( n);


        return result;
    }

    private String count(int n) {

        if (n == 1) {
            return "1";
        }

        String result = count(n - 1);
        String temp = "";
        int index = 0;
        for (int i = 0; i < result.length(); i++) {
            while (index < result.length()) {
                if (result.charAt(i) == result.charAt(index)) {
                    index++;
                }else {
                    break;
                }
            }
            temp += (index - i) + String.valueOf(result.charAt(i));
            i = index - 1;
        }
        return temp;
    }

    public static void main(String[] args) {

        System.out.println("expect:111221, the result is :" + new Solution().countAndSay(5));
        System.out.println("expect:1, the result is :" + new Solution().countAndSay(1));
        System.out.println("expect:11, the result is :" + new Solution().countAndSay(2));
        System.out.println("expect:21, the result is :" + new Solution().countAndSay(3));
        System.out.println("expect:1211, the result is :" + new Solution().countAndSay(4));

    }

}
