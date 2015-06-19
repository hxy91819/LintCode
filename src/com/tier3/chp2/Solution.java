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
	 * 因为Java不能操作引用，故此函数无法在LintCode上通过
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
	 * 计算在一个 32 位的整数的二进制表式中有多少个 1.
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
	 * 查找斐波纳契数列中第 N 个数。
	 * 
	 * 所谓的斐波纳契数列是指：
	 * 
	 * 前2个数是 0 和 1 。 第 i 个数是第 i-1 个数和第i-2 个数的和。 斐波纳契数列的前10个数字是：
	 * 
	 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
	 * 
	 * 使用递归的方法，在计算大序号时效率极低，使用递推，计算速度很快。
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
	 * 单例 是最为最常见的设计模式之一。对于任何时刻，如果某个类只存在且最多存在一个具体的实例，那么我们称这种设计模式为单例。例如，对于 class
	 * Mouse (不是动物的mouse哦)，我们应将其设计为 singleton 模式。
	 * 
	 * 你的任务是设计一个 getInstance 方法，对于给定的类，每次调用 getInstance 时，都可得到同一个实例。
	 * 
	 * @return: The same instance of this class every time
	 */
	public static Solution getInstance() {
		return solution;
	}

	/**
	 * 翻转一个链表
	 * 
	 * @param head
	 *            : The head of linked list.
	 * @return: The new head of reversed linked list.
	 */
	public ListNode reverse(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode tmpNode = head;// 当前操作节点

		ArrayList<ListNode> arrayListNode = new ArrayList<ListNode>();

		// 将链表内容存储到arrayListNode
		while (true) {
			if (tmpNode == null) {
				break;
			}

			arrayListNode.add(new ListNode(tmpNode.val));

			tmpNode = tmpNode.next;
		}

		int size = arrayListNode.size();

		// 再次循环设置next
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
	 * 假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）。
	 * 
	 * 你需要找到其中最小的元素。
	 * 
	 * 你可以假设数组中不存在重复的元素。
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
	 * 打印二叉树的前序遍历
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
	 * 打印二叉树的中序遍历
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