package stringLength;

public class Solution {
	public int lengthOfLongestSubstring(String s) {

		if ("".equals(s) || null == s) {
			return 0;
		}

		if (s.length() == 1) {
			return 1;
		}

		char[] sChar = s.toCharArray();

		if (s.length() == 2) {
			if (sChar[0] == sChar[1]) {
				return 1;
			}
			return 2;
		}

		int length = 0;
		int CurrentLength = 0;

		for (int i = 0; i < sChar.length - 1; i++) {
			for (int j = i + 1; j < sChar.length; j++) {
				// 如果找到相同字符串
				if (sChar[i] == sChar[j]) {
					CurrentLength = j - i;
					if (j - i + 1 >= 4 && isSubLength(sChar, i, j)) {
						CurrentLength = 0;
					}
					break;
				}

				if (j == sChar.length - 1 && sChar[i] != sChar[j]) {
					CurrentLength = j + 1 - i;
					if (j - i + 1 >= 3 && isSubLength(sChar, i, j)) {
						CurrentLength = 0;
					}
					break;
				}
			}

			if (length < CurrentLength) {
				length = CurrentLength;
			}

		}
		return length;

	}

	private boolean isSubLength(char[] schar, int i, int j) {
		for (int i1 = i + 1; i1 <= j; i1++) {
			for (int j1 = i1 + 1; j1 <= j; j1++) {
				if (schar[i1] == schar[j1]) {
					return true;
				} else {
					isSubLength(schar, i1, j1);
				}
			}

		}
		return false;

	}

	public static void main(String[] args) {
//"cdd"
		System.out.println("cdd expent:2, and result is:" + new Solution().lengthOfLongestSubstring("cdd"));
		System.out.println("pwwkew expent:3, and result is:" + new Solution().lengthOfLongestSubstring("pwwkew"));
		System.out.println("abcddcba expent:4, and result is:" + new Solution().lengthOfLongestSubstring("abcddcba"));
		System.out.println("abcabcbb expent:3, and result is:" + new Solution().lengthOfLongestSubstring("abcabcbb"));
		System.out.println("bb expent:1, and result is:" + new Solution().lengthOfLongestSubstring("bb"));

	}
}
