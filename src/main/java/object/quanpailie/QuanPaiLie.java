package object.quanpailie;

import java.util.Scanner;

public class QuanPaiLie {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		QuanPaiLie quanPaiLie = new QuanPaiLie();
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

			quanPaiLie.permutation(chars, 0);
		}

	}

	public void permutation(char[] ss, int i) {
		if (ss == null || i < 0 || i > ss.length) {// 1
			return;
		}

		if (i == ss.length - 1) {// 2
			System.out.println(new String(ss));
		} else {
			for (int j = i; j < ss.length; j++) {// 3
				char temp = ss[j];// 交换前缀,使之产生下一个前缀
				ss[j] = ss[i];
				ss[i] = temp;
				permutation(ss, i + 1);// 4
				temp = ss[j]; // 将前缀换回来,继续做上一个的前缀排列.//5
				ss[j] = ss[i];
				ss[i] = temp;
			}
		}
	}

}
