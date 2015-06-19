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
	 * ��ΪJava���ܲ������ã��ʴ˺����޷���LintCode��ͨ��
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
	 * ������һ�� 32 λ�������Ķ����Ʊ�ʽ���ж��ٸ� 1.
	 * 
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

	/**
	 * ����쳲����������е� N ������
	 * 
	 * ��ν��쳲�����������ָ��
	 * 
	 * ǰ2������ 0 �� 1 �� �� i �����ǵ� i-1 �����͵�i-2 �����ĺ͡� 쳲��������е�ǰ10�������ǣ�
	 * 
	 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
	 * 
	 * ʹ�õݹ�ķ������ڼ�������ʱЧ�ʼ��ͣ�ʹ�õ��ƣ������ٶȺܿ졣
	 * 
	 * @param n
	 *            : an integer
	 * @return an integer f(n)
	 */
	public int fibonacci(int n) {
		if (n == 1) {
			return 0;
		} else if (n == 2) {
			return 1;
		}
		int n1 = 0, n2 = 1, sn = 0;
		for (int i = 0; i < n - 2; i++) {
			sn = n1 + n2;
			n1 = n2;
			n2 = sn;
		}
		return sn;
	}

	private static Solution solution;

	/**
	 * ���� ����Ϊ��������ģʽ֮һ�������κ�ʱ�̣����ĳ����ֻ������������һ�������ʵ������ô���ǳ��������ģʽΪ���������磬���� class
	 * Mouse (���Ƕ����mouseŶ)������Ӧ�������Ϊ singleton ģʽ��
	 * 
	 * ������������һ�� getInstance ���������ڸ������࣬ÿ�ε��� getInstance ʱ�����ɵõ�ͬһ��ʵ����
	 * 
	 * @return: The same instance of this class every time
	 */
	public static Solution getInstance() {
		return solution;
	}

	/**
	 * ��תһ������
	 * 
	 * @param head
	 *            : The head of linked list.
	 * @return: The new head of reversed linked list.
	 */
	public ListNode reverse(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode tmpNode = head;// ��ǰ�����ڵ�

		ArrayList<ListNode> arrayListNode = new ArrayList<ListNode>();

		// ���������ݴ洢��arrayListNode
		while (true) {
			if (tmpNode == null) {
				break;
			}

			arrayListNode.add(new ListNode(tmpNode.val));

			tmpNode = tmpNode.next;
		}

		int size = arrayListNode.size();

		// �ٴ�ѭ������next
		for (int i = size - 1; i >= 0; i--) {
			if (i >= 1) {
				arrayListNode.get(i).next = arrayListNode.get(i - 1);
			} else {
				arrayListNode.get(i).next = null;
			}
		}

		return arrayListNode.get(size - 1);
	}

	/**
	 * ����һ����ת�������������ʼλ����δ֪�ģ�����0 1 2 4 5 6 7 ���ܱ����4 5 6 7 0 1 2����
	 * 
	 * ����Ҫ�ҵ�������С��Ԫ�ء�
	 * 
	 * ����Լ��������в������ظ���Ԫ�ء�
	 * 
	 * @param num
	 *            : a rotated sorted array
	 * @return: the minimum number in the array
	 */
	public int findMin(int[] num) {
		int min = num[0];
		for (int i = 1; i < num.length; i++) {
			if (num[i] < min) {
				min = num[i];
			}
		}
		return min;
	}

	/**
	 * Invert a binary tree.
	 * 
	 * @param root
	 *            : a TreeNode, the root of the binary tree
	 * @return: nothing
	 */
	public void invertBinaryTree(TreeNode root) {
		TreeNode tempTreeNode = new TreeNode(1);

		if (root.left != null) {
			tempTreeNode = root.left;
			if (root.right != null) {
				root.left = root.right;
				root.right = tempTreeNode;
			} else {
				root.right = tempTreeNode;
				root.left = null;
			}
		} else {
			if (root.right != null) {
				root.left = root.right;
				root.right = null;
			} else {
				return;
			}
		}
		invertBinaryTree(root.left);
		invertBinaryTree(root.right);
	}

	/* ---------------------------------------------------------------------- */
	
	/**
	 * ��ӡ��������ǰ�����
	 * @param n
	 */
	public void preOrder(TreeNode n) {
		if (n != null) {
			System.out.print(n.val + ",");
			preOrder(n.left);
			preOrder(n.right);
		}
	}

	/**
	 * ��ӡ���������������
	 * @param n
	 */
	public void inOrder(TreeNode n) {
		if (n != null) {
			inOrder(n.left);
			System.out.print(n.val + ",");
			inOrder(n.right);
		}
	}
}

/**
 * Definition for ListNode.
 * 
 * @author hxy
 *
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

/**
 * Definition of TreeNode:
 */
class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}