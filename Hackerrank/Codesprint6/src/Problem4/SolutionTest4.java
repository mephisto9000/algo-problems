package Problem4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SolutionTest4 {

	@Before
	public void setUp() throws Exception {
	}

	
	@Test	
	public void test0() throws Exception{
		Solution sol = new Solution();
		sol.src = "P4input1.txt";
		
		String s = sol.calc();
		
		assertEquals("YES", s);
	}
	
	@Test
	public void test1() throws Exception{
		Solution sol = new Solution();
		sol.src = "P4input3.txt";
		
		String s = sol.calc();
		
		assertEquals("NO\nYES\nYES\nNO", s);
	}
	
	
	@Test
	public void test2() throws Exception{
		Solution sol = new Solution();
		sol.src = "P4input2.txt";
		
		String s = sol.calc();
		
		assertEquals("NO\nYES\nNO", s);
	}

}
