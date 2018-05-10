package problem324;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		int nums[] = {4,5,5,6};
		sol.wiggleSort(nums);
		
		int exp[] = {5,6,4,5};
		
		sol.printArray(nums);
		Assert.assertArrayEquals(nums, exp);
	}

}
