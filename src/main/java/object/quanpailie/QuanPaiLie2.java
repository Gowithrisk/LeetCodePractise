package object.quanpailie;

import java.util.Scanner;

public class QuanPaiLie2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		QuanPaiLie2 quanPaiLie = new QuanPaiLie2();
		String line = "";

		while (scanner.hasNext()) {
			line = scanner.next();

			if (line.length() != 1 || !Character.isDigit(line.charAt(0))) {
				return;
			}

			// Get group numbers
			// int[] numbers = new int[line];

			char[] chars = new char[Integer.parseInt(line)];

			for (int i = 0; i < chars.length; i++) {
				chars[i] = (char) ((i + 1) + '0');
			}

			quanPaiLie.fullSort(chars, 0, chars.length - 1);
		}

	}

	public void fullSort(char[] arr, int start, int end) {
		System.out.println(String.format("�ݹ���뵱ǰlevel:%s", start));
		if (start == end) {
			System.out.println("start==end �ö������飺" + new String(arr) + " ; return ��һ��loop: " + (start - 1));
			return;
		}
		for (int i = start; i <= end; i++) {
			System.out.println(String.format("����loop�� ����:%s, %s��%s������i:%s; start:%s", new String(arr), arr[i],
					arr[start], i, start));
			swap(arr, i, start); // ���ض����ֻ�����ǰ����

			System.out.println(String.format("�����õ�����:%s; �ݹ������һ��:%s", new String(arr), start + 1));
			fullSort(arr, start + 1, end);

			System.out.println(String.format("end ����:%s��%s����;  i:%s; start:%s�� ���飺%s��", arr[start], arr[i], start, i,
					new String(arr)));
			swap(arr, start, i);
			System.out.println(String.format("end ����֮�� ; ���飺%s��", new String(arr)));
		}
		System.out.println(String.format("������һ��:, ��ǰlevel:%s; ��ǰָ��ָ��%s", start, arr[start]));
	}

	public void swap(char arr[], int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
