package problem291;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class Tests {

	
	@Test
	//@Ignore
	public void test() {
		Solution sol = new Solution();
		String pattern ="aba";
		String word = "redbluered";
		boolean ans = sol.wordPatternMatch(pattern, word);
		boolean exp = true;
		
		assertEquals(exp, ans);
	}
	
	@Test
	public void test2() {
		Solution sol = new Solution();
		String pattern ="abab";
		String word = "redblueredblue";
		boolean ans = sol.wordPatternMatch(pattern, word);
		boolean exp = true;
		
		assertEquals(exp, ans);
	}
	
	@Test
	 
	public void test1() {
		Solution sol = new Solution();
		String pattern ="abba";
		String word = "redbluebluered";
		boolean ans = sol.wordPatternMatch(pattern, word);
		boolean exp = true;
		
		assertEquals(exp, ans);
	}
	
	@Test
	public void tes31() {
		Solution sol = new Solution();
		String pattern ="aa";
		String word = "redblue";
		boolean ans = sol.wordPatternMatch(pattern, word);
		boolean exp = false;
		
		assertEquals(exp, ans);
	} 
	
	@Test
	public void tes41() {
		Solution sol = new Solution();
		String pattern ="ab";
		String word = "aa";
		boolean ans = sol.wordPatternMatch(pattern, word);
		boolean exp = false;
		
		assertEquals(exp, ans);
	}

}
