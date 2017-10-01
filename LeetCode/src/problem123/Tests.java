package problem123;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class Tests {

	@Test
	@Ignore
	public void test1() {
		

		Solution sol = new Solution();
		
		int nums[] = {1,2,4};
		int ans = sol.maxProfit(nums);
		int exp = 3;
		
		assertEquals(exp, ans);
	}
	
	@Test
	public void test2() {
		

		Solution sol = new Solution();
		
		int nums[] = {1,4,2};
		int ans = sol.maxProfit(nums);
		int exp = 3;
		
		assertEquals(exp, ans);
	}
	
	@Test
	@Ignore
	public void test3() {
		

		Solution sol = new Solution();
		
		int nums[] = {2,1};
		int ans = sol.maxProfit(nums);
		int exp = 0;
		
		assertEquals(exp, ans);
	}
	
	@Test
	@Ignore
	public void test4() 
	{
		Solution sol = new Solution();
		
		int nums[] = {2,1,2,0,1};
		int ans = sol.maxProfit(nums);
		int exp = 2;
		
		assertEquals(exp, ans);
		
	}
	
	
	@Test
	@Ignore
	public void test5() 
	{
		Solution sol = new Solution();				
		int nums[] = {6,1,3,2,4,7};
		int ans = sol.maxProfit(nums);
		int exp = 7;
				
		assertEquals(exp, ans);
				
	}

}
