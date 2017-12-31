package problem29;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	
	@Test
	public void test() {
		Solution sol = new Solution();
		
		int ans = sol.divide(2147483647, 3);
		int exp = 715827882;
		
		assertEquals(exp, ans);
	}
	
	@Test
	public void test1() {
		Solution sol = new Solution();
		
		int ans = sol.divide(-2147483648, 2);
		int exp = -1073741824;
		
		assertEquals(exp, ans);
	}
	
	
	@Test
	public void test3() {
		Solution sol = new Solution();
		
		int ans = sol.divide(-2147483648, -3);
		int exp = 715827882;
		
		assertEquals(exp, ans);
	}
	
	@Test
	public void test4() {
		Solution sol = new Solution();
		
		int ans = sol.divide(1004958205, -2137325331);
		int exp = 0;
		
		assertEquals(exp, ans);
	}
	//1004958205
	//-2137325331

}

