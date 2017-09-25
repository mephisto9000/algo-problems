package problem45;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Solution sol = new Solution();
		
		int[] nums = {2,3,1,1,4};
		int exp = 2;
		assertEquals(exp, sol.jump(nums));
	}
	
	
	 

}
