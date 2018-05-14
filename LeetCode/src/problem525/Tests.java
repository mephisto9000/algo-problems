package problem525;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		int nums[] = {0,1,0,1};
		int ans = sol.findMaxLength(nums);
		assertEquals(4,ans);
	}

}
