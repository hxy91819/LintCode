package com.tier3.chp2;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.tier3.chp2.Solution;

@SuppressWarnings("deprecation")
public class SolutionTest extends TestCase {
	Solution sol;

	@Override
	protected void setUp() throws Exception {
		sol = new Solution();
	}

	public void testreplaceBlank() {
		String s = "Mr John Smith";
		char[] string = s.toCharArray();
		
		Assert.assertEquals(17, sol.replaceBlank(string, 13));
	}
	
	public void testcountOnes(){
		Assert.assertEquals(1, sol.countOnes(1));
	}
	
	public void testfibonacci(){
		Assert.assertEquals(1836311903, sol.fibonacci(47));
	}
	
	public void testgetInstance(){
		Solution solution1 = Solution.getInstance();
		Solution solution2 = Solution.getInstance();
		Assert.assertEquals(solution1, solution2);
	}
	
	public void testreverse(){
		ListNode head = new ListNode(1);
		ListNode first = new ListNode(2);
		ListNode second = new ListNode(3);
		head.next = first;
		first.next = second;
		second.next = null;
		
		ListNode ret = sol.reverse(head);
		
		Assert.assertEquals(3, ret.val);
		Assert.assertEquals(2, ret.next.val);
		Assert.assertEquals(1, ret.next.next.val);
	}
	
	public void testfindMin(){
		int[] num = {4,5,6,7,0,1,2};
		
		Assert.assertEquals(0, sol.findMin(num));
	}
	
	public void testgetTreePreOrder(){
		TreeNode tree1 = new TreeNode(1);
		TreeNode tree2 = new TreeNode(2);
		TreeNode tree3 = new TreeNode(3);
		TreeNode tree4 = new TreeNode(4);
		TreeNode tree5 = new TreeNode(5);
		TreeNode tree6 = new TreeNode(6);
		
		tree1.left = tree2;
		tree1.right = tree3;
		
		tree2.left = tree4;
		tree2.right = tree5;
		
		tree3.left = tree6;
		
		sol.getTreePreOrder(tree1);
	}
}

