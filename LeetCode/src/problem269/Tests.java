package problem269;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	
	@Test
	public void test() {
		Solution sol = new Solution();
		
		String words[] = {"wrt","wrf","er","ett","rftt"};
		
		String ans = sol.alienOrder(words);
		String exp = "wertf";
		
		assertEquals(exp, ans);
	}
	
	
	@Test
	public void test1() {
		Solution sol = new Solution();
		
		String words[] = {"z","x"};
		
		String ans = sol.alienOrder(words);
		String exp = "zx";
		
		assertEquals(exp, ans);
	}
	
	@Test
	public void test2() {
		Solution sol = new Solution();
		
		String words[] = {"z","x","z"};
		
		String ans = sol.alienOrder(words);
		String exp = "";
		
		assertEquals(exp, ans);
	
	} 
	
	@Test
	public void test3() {
		Solution sol = new Solution();
		
		String words[] = {"wrt","wrtkj"};
		
		String ans = sol.alienOrder(words);
		String exp = "wtrkj";
		
		assertEquals(exp, ans);
	
	}
	
	@Test
	public void test4() {
		Solution sol = new Solution();
		
		String words[] = {"ze","yf","xd","wd","vd","ua","tt","sz","rd",
		                  "qd","pz","op","nw","mt","ln","ko","jm","il",
		                  "ho","gk","fa","ed","dg","ct","bb","ba"};
		
		String ans = sol.alienOrder(words);
		String exp = "zyxwvutsrqponmlkjihgfedcba";
		
		assertEquals(exp, ans);
	
	}
	
	
	
	 

}
