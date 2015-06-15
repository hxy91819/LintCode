package com.tier3.chp2;

import java.util.ArrayList;

public class Solution {
	/**
	 * 设计一种方法，将一个字符串中的所有空格替换成 %20 。你可以假设该字符串有足够的空间来加入新的字符，且你得到的是“真实的”字符长度。
	 * 
	 * 例如：对于字符串"Mr John Smith", 长度为 13
	 * 
	 * 替换空格之后的结果为"Mr%20John%20Smith"
	 * 
	 * 因为Java不能操作引用，故此函数无法在LintCode上实现
	 * 
	 * @param string
	 *            : An array of Char
	 * @param length
	 *            : The true length of the string
	 * @return: The true length of new string
	 */
	public int replaceBlank(char[] string, int length) {
		ArrayList<Character> arrayList = new ArrayList<Character>();
		// 将转换后的char数组保存到arrayList中
		for (int i = 0; i < length; i++) {
			if (string[i] == ' ') {
				arrayList.add('%');
				arrayList.add('2');
				arrayList.add('0');
			} else {
				arrayList.add(string[i]);
			}
		}

		char[] stringNew = new char[arrayList.size()];
		// 然后再遍历arrayList，将其保存到新的char数组中
		for (int i = 0; i < arrayList.size(); i++) {
			stringNew[i] = arrayList.get(i);
		}

		string = stringNew;

		return string.length;
	}

	/**
	 * @param num
	 *            : an integer
	 * @return: an integer, the number of ones in num
	 */
	public int countOnes(int num) {
		// write your code here
		String binString = Integer.toBinaryString(num);

		int sum = 0;
		for (int i = 0; i < binString.length(); i++) {
			if (binString.charAt(i) == '1') {
				sum++;
			}
		}
		return sum;
	}

	/* ---------------------------------------------------------------------- */

}
