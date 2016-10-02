import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() throws Exception {
		Solution sol = new Solution();
		sol.src = "input0.txt";
		
		
		//System.out.println(sol.calc());
		assertEquals(2, sol.calc());
	}
	
	@Test
	public void test16() throws Exception {
		Solution sol = new Solution();
		sol.src = "input16.txt";
		
		
		//System.out.println(sol.calc());
		assertEquals(50, sol.calc());
	}

}
