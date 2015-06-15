package com.tier3.chp2;

import junit.framework.TestCase;

import com.tier3.chp2.Solution;

public class SolutionTest extends TestCase {
	Solution sol;

	@Override
	protected void setUp() throws Exception {
		sol = new Solution();
	}

	public void testreplaceBlank() {
		String s = "Mr John Smith";
		char[] string = s.toCharArray();
		
		System.out.println(sol.replaceBlank(string, 13));
		
		System.out.println(string);//ÐÐ²»Í¨
	}
	
	public void testcountOnes(){
//		System.out.println(sol.countOnes(1));
	}
	
}

