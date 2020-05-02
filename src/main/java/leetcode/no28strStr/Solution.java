package no28strStr;

public class Solution {
    public int strStr(String haystack, String needle) {

        if ("".equals(needle) || null == needle) {
            return 0;
        }

        if ("".equals(haystack)) {
            return -1;
        }

        return haystack.indexOf(needle);
    }

    public int strStr2(String haystack, String needle) {
        if ("".equals(needle) || null == needle) {
            return 0;
        }

        if ("".equals(haystack) || haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("expect 2;" + new Solution().strStr2("hello", "ll"));
        System.out.println("expect -1;" + new Solution().strStr2("aaaa", "bba"));
        System.out.println("expect 0;" + new Solution().strStr2("a", ""));
        System.out.println("expect -1;" + new Solution().strStr2("", "a"));
        System.out.println("expect 0;" + new Solution().strStr2("a", "a"));
    }
}
