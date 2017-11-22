package problem502;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		int k = 2;
		int W = 0;
		int Profits[] = {1,2,3};
		int Capital[] = {0,1,1};
		
		int ans = sol.findMaximizedCapital(k, W, Profits, Capital);
		int exp = 4;
		
		assertEquals(exp, ans);
	}
	
	 
			@Test
			public void test1() {
				Solution sol = new Solution();
				
				int k = 1;
				int W = 0;
				int Profits[] = {1,2,3};
				int Capital[] = {1,1,2};
				
				int ans = sol.findMaximizedCapital(k, W, Profits, Capital);
				int exp = 0;
				
				assertEquals(exp, ans);
			}

}
