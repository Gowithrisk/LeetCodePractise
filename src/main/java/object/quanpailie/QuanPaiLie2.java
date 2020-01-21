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
		System.out.println(String.format("递归进入当前level:%s", start));
		if (start == end) {
			System.out.println("start==end 得多结果数组：" + new String(arr) + " ; return 上一层loop: " + (start - 1));
			return;
		}
		for (int i = start; i <= end; i++) {
			System.out.println(String.format("进入loop； 数组:%s, %s与%s互换；i:%s; start:%s", new String(arr), arr[i],
					arr[start], i, start));
			swap(arr, i, start); // 把特定数字换到最前面来

			System.out.println(String.format("互换得到数组:%s; 递归进入下一层:%s", new String(arr), start + 1));
			fullSort(arr, start + 1, end);

			System.out.println(String.format("end 换回:%s与%s互换;  i:%s; start:%s； 数组：%s；", arr[start], arr[i], start, i,
					new String(arr)));
			swap(arr, start, i);
			System.out.println(String.format("end 换回之后 ; 数组：%s；", new String(arr)));
		}
		System.out.println(String.format("返回上一层:, 当前level:%s; 当前指针指在%s", start, arr[start]));
	}

	public void swap(char arr[], int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
