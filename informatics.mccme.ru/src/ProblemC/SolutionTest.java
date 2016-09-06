package ProblemC;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	
	

	@Test
	public void test() throws Exception {
	
		Solution sol = new Solution();
		
		sol.str = "input_c1.txt";
		assertEquals(3, sol.calc());
	}
	
	 

}
