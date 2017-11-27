package problem85;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	
	@Test
	public void test() {
		
		char arr[][] = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		Solution sol = new Solution();
		
		int ans = sol.maximalRectangle(arr);
		int exp = 6;
		assertEquals(exp,ans);
	}
	
	/*
	@Test
	public void test1() {
		
		char arr[][] = {{'1','1'}};
		Solution sol = new Solution();
		
		int ans = sol.maximalRectangle(arr);
		int exp = 2;
		assertEquals(exp,ans);
	}
	
	@Test
	public void test2() {
		
		char arr[][] = {{'1','0'}};
		Solution sol = new Solution();
		
		int ans = sol.maximalRectangle(arr);
		int exp = 1;
		assertEquals(exp,ans);
	}
	
	@Test
	public void test3() {
		
		char arr[][] = {{'0','1'},{'0','1'}};
		Solution sol = new Solution();
		
		int ans = sol.maximalRectangle(arr);
		int exp = 2;
		assertEquals(exp,ans);
	}
	
*/
}
