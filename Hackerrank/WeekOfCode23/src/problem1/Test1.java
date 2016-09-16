package problem1;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test1 {

	@Test
	public void test1() throws Exception {

		Solution sol = new Solution();
		sol.src = "P1T0.txt";
		
		assertEquals("No\nYes", sol.calc());
	}

}
