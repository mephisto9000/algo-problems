package problem312;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		int nums[] = {7,9,8,0,7,1,3,5,5,2,3,3};
		int ans = sol.maxCoins(nums);
		
		assertEquals(1717, ans);
	}
	
	
	@Test
	public void test1() {
		Solution sol = new Solution();
		
		int nums[] = {8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2};
		int ans = sol.maxCoins(nums);
		
		assertEquals(3414, ans);
	} 

}

 