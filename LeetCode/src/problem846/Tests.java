package problem846;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		Solution sol = new Solution();
		assertTrue(sol.isNStraightHand(new int[] {2, 1}, 2));
	}

}
