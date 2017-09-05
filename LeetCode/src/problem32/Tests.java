package problem32;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		int ans = sol.longestValidParentheses("()()");
		
		assertEquals(4,ans);
	}
	
	@Test
	public void test1() {
		Solution sol = new Solution();
		
		int ans = sol.longestValidParentheses("(()");
		
		assertEquals(2,ans);
	}
	
	
	@Test
	public void test2() {
		Solution sol = new Solution();
		
		int ans = sol.longestValidParentheses("()(()");
		
		assertEquals(2,ans);
	}

}
