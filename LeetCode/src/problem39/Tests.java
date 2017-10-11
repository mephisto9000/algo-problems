package problem39;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		
		Solution sol = new Solution();
		
		int nums[] = {2,5,8,4};
		List l = sol.combinationSum(nums, 10);
		
		assertEquals(5, l.size());
		
		
	}

}
