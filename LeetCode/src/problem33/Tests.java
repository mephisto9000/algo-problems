package problem33;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class Tests {

	@Test
	//@Ignore
	public void test1() {
		Solution sol = new Solution();
		
		int[] a = {1,3};
		
		int ans = sol.search(a, 3);
		
		assertEquals(1, ans);

	}
	
	@Test
	//@Ignore
	public void test12() {
		Solution sol = new Solution();
		
		int[] a = {3,1};
		
		int ans = sol.search(a, 1);
		
		assertEquals(1, ans);

	}
	
	@Test
	public void test2() {
		Solution sol = new Solution();
		
		int[] a = {4,5,6,7,8,1,2,3};
		
		int ans = sol.search(a, 8);
		
		assertEquals(4, ans);
	}
	 
	

}
