package problem229;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		int[] nums = {1,2};
		Object[] exp = {1,2};
		List<Integer> ans = sol.majorityElement(nums);
		
		assertEquals(exp, ans.toArray());
		
	}

}
