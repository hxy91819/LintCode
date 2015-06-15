package com.tier3.chp1;

import com.tier3.chp1.Solution;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
	Solution sol;

	@Override
	protected void setUp() throws Exception {
		sol = new Solution();
	}

	public void testfizzBuzz() {
		System.out.println(sol.fizzBuzz(15));
	}
}
