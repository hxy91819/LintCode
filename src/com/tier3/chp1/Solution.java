package com.tier3.chp1;

import java.util.ArrayList;

/**
 * ����һ������n. �� 1 �� n ��������Ĺ����ӡÿ������
 * 
 * ����������3��������ӡfizz. ����������5��������ӡbuzz. ����������ͬʱ��3��5��������ӡfizz buzz.
 * 
 * @author hxy
 *
 */
public class Solution {
	/**
	 * param n: As description. return: A list of strings.
	 */
	public ArrayList<String> fizzBuzz(int n) {
		ArrayList<String> arrayList = new ArrayList<String>();

		for (int i = 1; i < n + 1; i++) {
			if (i % 3 == 0) {
				if (i % 5 == 0) {
					arrayList.add("fizz buzz");
				} else {
					arrayList.add("fizz");
				}
			} else if (i % 5 == 0) {
				arrayList.add("buzz");
			} else {
				arrayList.add(((Integer) i).toString());
			}
		}

		return arrayList;
	}
}
