package ProblemA;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	
	

	@Test
	public void test() throws Exception {
	
		Solution sol = new Solution();
		
		sol.str = "input_a1.txt";
		assertEquals("YES", sol.calc());
	}
	
	
	@Test
	public void test1() throws Exception {
	
		Solution sol = new Solution();
		
		sol.str = "input_a2.txt";
		assertEquals("NO", sol.calc());
	}

}
