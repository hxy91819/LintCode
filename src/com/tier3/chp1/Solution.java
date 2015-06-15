package com.tier3.chp1;

import java.util.ArrayList;

/**
 * 给你一个整数n. 从 1 到 n 按照下面的规则打印每个数：
 * 
 * 如果这个数被3整除，打印fizz. 如果这个数被5整除，打印buzz. 如果这个数能同时被3和5整除，打印fizz buzz.
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
