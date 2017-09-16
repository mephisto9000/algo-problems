package problem122;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		
		Solution sol = new Solution();
		
		int[] prices = {
				1,
				2,
				3,
				4,
				5,
				3,
				0,
				4,
				
		};
		
		int ans = sol.maxProfit(prices);
		assertEquals(8,ans);
	}
	
	
	@Test
	public void test1() {
		
		Solution sol = new Solution();
		
		int[] prices = {
				10,
				3,
				0,
				1
				
		};
		
		int ans = sol.maxProfit(prices);
		assertEquals(1,ans);
	}

}
