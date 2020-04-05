package leetcode.findSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> resultList = new ArrayList<Integer>();
		if (null == s || s.length() == 0 || null == words || words.length == 0 || (s.length() < words.length)) {
			return resultList;
		}

		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		HashMap<String, Integer> map2 = new HashMap<String, Integer>();

		int awordLength = words[0].length();
		int wordlength = words[0].length() * words.length;
		String tems;
		int nextLenth = 0;
		for (String s1 : words) {
			int count = map1.getOrDefault(s1, 0);
			map1.put(s1, count + 1);
		}

		int count1 = 0;
		for (int i = 0; i < s.length(); i++) {
			nextLenth = i + wordlength;
			if (nextLenth > s.length()) {
				break;
			}

			count1 = 0;
			tems = s.substring(i, nextLenth);
			String awordString = "";
//			System.out.println(tems);
			map2 = new HashMap<String, Integer>();
			for (int j = 0; j < words.length; j++) {
				awordString = tems.substring(j * awordLength, (j + 1) * awordLength);
				int countKey = map2.getOrDefault(awordString, 0);
				map2.put(awordString, countKey + 1);
//					System.out.println(tems + " contains:" + words[j] + "; count1 =" + count1 + ";");
				if (map1.get(words[j]) == map2.get(words[j])) {
//						System.out.println(String.format("key:%s;map1:%s;map2:%s", words[j], map1.get(words[j]),
//								 map2.get(words[j])));
					count1++;
				}
			}

			boolean isResult = true;
			for (int k = 0; k < words.length; k++) {
				if (map1.get(words[k]) != map2.get(words[k])) {
					isResult = false;
				}
			}
			if (isResult) {
				resultList.add(i);
			}
		}

		return resultList;

	}

	public static void main(String[] args) {
		// testcase:
		// s为空/words为空/s的长度<words的长度,都返回为空
		// "wordgoodgoodgoodbestword" ["word","good","best","good"] 8
		// "wordgoodgoodgoodbestword" ["word","good","best","word"] 8 ""
		printResult("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "word" }, "");
		printResult("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "good" }, "8");
		printResult("barfoothefoobarman", new String[] { "foo", "bar" }, "0,9");
		printResult("foobar", new String[] { "foo", "bar" }, "0");
		printResult("", new String[] { "foo", "bar" }, "");
		printResult("foo", new String[] {}, "");
		printResult("", null, "");
		printResult("foo", new String[] { "foo" }, "0");
	}

	private static void printResult(String s, String[] words, String expect) {

		// words.forEach(s1)-> System.out.println(s1);
		String tempString = "";
		if (words != null && words.length != 0) {
			for (String s1 : words) {
				tempString += s1 + ",";
			}
		}

		System.out.println("s=" + s + "\nwords=" + tempString + "\nexpect=" + expect);
		tempString = "";
		for (int s1 : new Solution().findSubstring(s, words)) {
			tempString += s1 + ",";
		}
		System.out.println("result=" + tempString + "\n");

	}

}
