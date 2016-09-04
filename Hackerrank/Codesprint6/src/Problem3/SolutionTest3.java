package Problem3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest3 {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws Exception {
		Solution sol = new Solution();
		sol.src = "P3input1.txt";
		
		String ans = sol.calc();
		
		assertEquals("414", ans);
		
	}

}
