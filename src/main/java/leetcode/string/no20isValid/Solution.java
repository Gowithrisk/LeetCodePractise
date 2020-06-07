package string.no20isValid;

import java.util.HashMap;
import java.util.Stack;

public class Solution {

    /**
     * {:123,  }:125
     * (:40,  ):41
     * [:91,  ]:93
     */
    public boolean isValid(String s) {

        if (null == s || "".equals(s)) {
            return true;
        }
        HashMap<Character, Character> amap = new HashMap<Character, Character>();
        amap.put(')', '(');
        amap.put(']', '[');
        amap.put('}', '{');
        Stack<Character> stack = new Stack<Character>();

        char[] ss = s.toCharArray();

        for (int i = 0; i < ss.length; i++) {
            if (' ' == ss[i]) {
                continue;
            }
            if (stack.empty()) {
                stack.push(ss[i]);
            } else {
                if (stack.peek() == amap.get(ss[i])) {
                    stack.pop();
                } else {
                    stack.push(ss[i]);
                }

            }
        }

        if (stack.empty()) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println("true, result is " + new Solution().isValid(" (( ))"));
        System.out.println("false, result is " + new Solution().isValid("([)]"));
        System.out.println("false, result is " + new Solution().isValid("(()"));
        System.out.println("true, result is " + new Solution().isValid("()"));
        System.out.println("true, result is " + new Solution().isValid("()[]{}"));
        System.out.println("false, result is " + new Solution().isValid("(]"));
        System.out.println("false, result is " + new Solution().isValid("(][)"));
    }

}
