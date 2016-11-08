package problem165;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() throws Exception {
		Solution sol = new Solution();
		sol.src = "input_165_1.txt";
		String res = sol.calc();
		
		assertEquals("YES\n1", res);
	}

}
