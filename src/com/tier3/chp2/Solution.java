package com.tier3.chp2;

import java.util.ArrayList;

public class Solution {
	/**
	 * ���һ�ַ�������һ���ַ����е����пո��滻�� %20 ������Լ�����ַ������㹻�Ŀռ��������µ��ַ�������õ����ǡ���ʵ�ġ��ַ����ȡ�
	 * 
	 * ���磺�����ַ���"Mr John Smith", ����Ϊ 13
	 * 
	 * �滻�ո�֮��Ľ��Ϊ"Mr%20John%20Smith"
	 * 
	 * ��ΪJava���ܲ������ã��ʴ˺����޷���LintCode��ʵ��
	 * 
	 * @param string
	 *            : An array of Char
	 * @param length
	 *            : The true length of the string
	 * @return: The true length of new string
	 */
	public int replaceBlank(char[] string, int length) {
		ArrayList<Character> arrayList = new ArrayList<Character>();
		// ��ת�����char���鱣�浽arrayList��
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
		// Ȼ���ٱ���arrayList�����䱣�浽�µ�char������
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
