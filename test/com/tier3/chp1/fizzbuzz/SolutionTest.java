package com.tier3.chp1.fizzbuzz;

import com.tier3.chp1.fizzbuzz.Solution;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
	Solution sol;

	@Override
	protected void setUp() throws Exception {
		sol = new Solution();
	}

	public void testgetStringOfHisConfig() {
		System.out.println(sol.fizzBuzz(15));
	}
}
