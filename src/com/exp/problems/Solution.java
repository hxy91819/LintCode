package com.exp.problems;

import java.util.ArrayList;

import sun.java2d.cmm.kcms.KcmsServiceProvider;

import com.determine.classes.Point;
import com.sun.org.apache.bcel.internal.generic.IfInstruction;

public class Solution {
	/**
	 * ��һ���ʵ䣬�ҳ�����������ĵ��ʡ�
	 * 
	 * @param dictionary
	 *            : an array of strings
	 * @return: an arraylist of strings
	 */
	ArrayList<String> longestWords(String[] dictionary) {
		ArrayList<String> arrayList = new ArrayList<String>();
		int maxIndex = 0;
		int maxLength = dictionary[0].length();// ��ַ�������
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
	 * ������άƽ���ϵ�n���㣬������ж��ٵ���ͬһ��ֱ���ϡ�
	 * 
	 * ������㷨�����Ǽ����ж�������һ�ߣ������Ǽ��������ٵ���һ��
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
			// �ӵ�һ���㿪ʼ���������ĵ�
			for (int j = i + 1; j < points.length - 1; j++) {
				int gX = points[j].x - points[i].x;
				int gY = points[j].y - points[i].y;
				float f = 0;
				boolean isInfinity = false;// �Ƿ��������
				if (gX == 0) {
					isInfinity = true;
				} else {
					f = (float) gY / (float) gX;// б��
				}

				// �������������б�ʣ���ȥ�Һ�����Ƿ���һ��ֱ����
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
