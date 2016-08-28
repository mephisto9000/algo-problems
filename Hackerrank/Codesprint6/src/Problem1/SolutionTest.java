package Problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws Exception {
		Solution sol = new Solution();
		sol.src = "P1input1.txt";
		
		int ans = sol.calc();
		
		assertEquals(5, ans);
		
		
	}

}
