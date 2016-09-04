package Problem5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest5 {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws Exception{
		Solution sol = new Solution();
		sol.src = "P5input1.txt";
		
		String ans = sol.calc();
		//assertEquals("2 3 7\n-1\n5 4\n1 8", ans);
		assertEquals("2 3 7\n-1\n5 4\n1 8", ans);
		
	}

}
