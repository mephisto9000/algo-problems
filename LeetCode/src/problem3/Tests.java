package problem3;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		
		Solution sol = new Solution();
		
		int ans = sol.lengthOfLongestSubstring("aab");
		int exp = 2;
		assertEquals(exp, ans);
	}
	
	@Test
	public void test1() {
		
		Solution sol = new Solution();
		
		int ans = sol.lengthOfLongestSubstring("abcabcbb");
		int exp = 3;
		assertEquals(exp, ans);
	}
	
	@Test
	public void test2() {
		
		Solution sol = new Solution();
		
		int ans = sol.lengthOfLongestSubstring("bbbbb");
		int exp = 1;
		assertEquals(exp, ans);
	}
	@Test
	public void test3() {
		
		Solution sol = new Solution();
		
		int ans = sol.lengthOfLongestSubstring("pwwkew");
		int exp = 3;
		assertEquals(exp, ans);
	}
	
	

}
