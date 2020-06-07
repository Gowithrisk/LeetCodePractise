package string.no58lengthOfLastWord;

public class Solution {

    public int lengthOfLastWord(String s) {

        if (null == s || " ".equals(s)) {
            return 0;
        }

        int r = 0;
        boolean isLastEmpty = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            while (!isLastEmpty && i >= 0 && s.charAt(i) == ' ') {
                i--;
                r++;
            }
            if (i < 0) {
                return 0;
            }
            isLastEmpty = true;

            if (('a' <= s.charAt(i) && s.charAt(i) <= 'z') || ('A' <= s.charAt(i) && s.charAt(i) <= 'Z')) {
                continue;
            } else if (isLastEmpty && ' ' == s.charAt(i)) {
                return s.length() - i - 1 - r;
            } else {
                return 0;
            }
        }

        return s.length() - r;

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("expect:1,¾ÓÈ»ÊÇ1. result is:" + new Solution().lengthOfLastWord("a "));
        Thread.sleep(2000);
        System.out.println("expect:0. result is:" + new Solution().lengthOfLastWord("    "));
        Thread.sleep(2000);
        System.out.println("expect:5. result is:" + new Solution().lengthOfLastWord("hellow world"));
        Thread.sleep(2000);
        System.out.println("expect:1. result is:" + new Solution().lengthOfLastWord("a"));
        Thread.sleep(2000);

        System.out.println("expect:0. result is:" + new Solution().lengthOfLastWord("hellow wor 1ld"));
        Thread.sleep(2000);

        System.out.println("expect:1. result is:" + new Solution().lengthOfLastWord(" a "));
        Thread.sleep(2000);
        System.out.println("expect:2. result is:" + new Solution().lengthOfLastWord("hellow wor ld"));
        Thread.sleep(2000);
        System.out.println("expect:0. result is:" + new Solution().lengthOfLastWord(""));
        Thread.sleep(2000);
        System.out.println("expect:0. result is:" + new Solution().lengthOfLastWord(" "));

    }
}

