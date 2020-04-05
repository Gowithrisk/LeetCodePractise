package leetcode.findSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution2 {

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		int wordNum = words.length;
		if (wordNum == 0) {
			return res;
		}
		int wordLen = words[0].length();
		
		// HashMap1 ������words�ĵ���
		HashMap<String, Integer> allWords = new HashMap<String, Integer>();
		for (String w : words) {
			int value = allWords.getOrDefault(w, 0);
			allWords.put(w, value + 1);
		}
		
		// ���������Ӵ�
		for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
			// HashMap2 �浱ǰɨ����ַ������еĵ���
			HashMap<String, Integer> hasWords = new HashMap<String, Integer>();
			int num = 0;
			// �жϸ��Ӵ��Ƿ����
			while (num < wordNum) {
				String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
				// �жϸõ����� HashMap1 ��
				if (allWords.containsKey(word)) {
					int value = hasWords.getOrDefault(word, 0);
					hasWords.put(word, value + 1);
					// �жϵ�ǰ���ʵ� value �� HashMap1 �иõ��ʵ� value
					if (hasWords.get(word) > allWords.get(word)) {
						break;
					}
				} else {
					break;
				}
				num++;
			}
			// �ж��ǲ������еĵ��ʶ���������
			if (num == wordNum) {
				res.add(i);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
