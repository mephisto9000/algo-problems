package problem72;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class Tests {

	@Test
	 
	public void test() {
	Solution sol = new Solution();
	
		int ans = sol.minDistance("ab", "bc");
		int exp = 2;
		assertEquals(exp, ans);
	
	
	
	}
	
	
	@Test
	 
	public void test1() {
	Solution sol = new Solution();
	
		int ans = sol.minDistance("super", "duper");
		int exp = 1;
		assertEquals(exp, ans);
			
	}
	
	@Test
	public void test2() {
	Solution sol = new Solution();
	
		int ans = sol.minDistance("typhoon", "typo");
		int exp = 3;
		assertEquals(exp, ans);
			
	}
	
	@Test
	 
	public void test3() {
	Solution sol = new Solution();
	
		int ans = sol.minDistance("sparta", "spa");
		int exp = 3;
		assertEquals(exp, ans);
			
	}
	
	
	@Test
	 
	public void test4() {
	Solution sol = new Solution();
	
		int ans = sol.minDistance("sea", "eat");
		int exp = 2;
		assertEquals(exp, ans);
			
	}
	
	@Test
	 
	public void test5() {
	Solution sol = new Solution();
	
		int ans = sol.minDistance("sea", "ate");
		int exp = 3;
		assertEquals(exp, ans);
			
	}
	
	@Test
	 
	public void test6() {
	Solution sol = new Solution();
	
		int ans = sol.minDistance("food", "money");
		int exp = 4;
		assertEquals(exp, ans);
			
	}
	
	@Test
	 
	public void test7() {
	Solution sol = new Solution();
	
		int ans = sol.minDistance("mart", "karma");
		int exp = 3;
		
		assertEquals(exp, ans);
		
	}
	
}
