package com.exp.problems;

import java.util.ArrayList;

import sun.java2d.cmm.kcms.KcmsServiceProvider;

import com.determine.classes.Point;
import com.sun.org.apache.bcel.internal.generic.IfInstruction;

public class Solution {
	/**
	 * 给一个词典，找出其中所有最长的单词。
	 * 
	 * @param dictionary
	 *            : an array of strings
	 * @return: an arraylist of strings
	 */
	ArrayList<String> longestWords(String[] dictionary) {
		ArrayList<String> arrayList = new ArrayList<String>();
		int maxIndex = 0;
		int maxLength = dictionary[0].length();// 最长字符串长度
		for (int i = 0; i < dictionary.length - 1; i++) {
			if (maxLength < dictionary[i + 1].length()) {
				maxLength = dictionary[i + 1].length();
				maxIndex = i + 1;
			}
		}

		for (int i = maxIndex; i < dictionary.length; i++) {
			if (dictionary[i].length() == maxLength) {
				arrayList.add(dictionary[i]);
			}
		}

		return arrayList;
	}

	/**
	 * 给出二维平面上的n个点，求最多有多少点在同一条直线上。
	 * 
	 * 下面的算法有误，是计算有多少三点一线，而不是计算最多多少点在一起。
	 * 
	 * @param points
	 *            an array of point
	 * @return an integer
	 */
	public int maxPoints(Point[] points) {
		int sum = 0;
		if (points == null) {
			return 0;
		}
		if (points.length == 2) {
			return 2;
		} else if (points.length > 2) {
			sum = 2;
		} else if (points.length == 1) {
			return 1;
		} else if (points.length == 0) {
			return 0;
		}

		for (int i = 0; i < points.length - 2; i++) {
			// 从第一个点开始，连接其后的点
			for (int j = i + 1; j < points.length - 1; j++) {
				int gX = points[j].x - points[i].x;
				int gY = points[j].y - points[i].y;
				float f = 0;
				boolean isInfinity = false;// 是否是无穷大
				if (gX == 0) {
					isInfinity = true;
				} else {
					f = (float) gY / (float) gX;// 斜率
				}

				// 根据连接两点的斜率，再去找后面点是否在一条直线上
				for (int k = j + 1; k < points.length; k++) {
					int gXN = points[k].x - points[i].x;
					int gYN = points[k].y - points[i].y;
					if (gXN == 0 && isInfinity) {
						sum++;
					} else if (gXN != 0) {
						float fN = (float) gYN / (float) gXN;
						if (f == fN) {
							sum++;
						}
					}
				}
			}
		}
		return sum;
	}
}
