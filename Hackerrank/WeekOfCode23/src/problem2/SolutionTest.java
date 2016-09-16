package problem2;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class SolutionTest {
	
	

	
	@Test
	public void test0() throws Exception {
	
		Solution sol = new Solution();
		sol.src = "P2T0.txt";
		int v = sol.calc();
		
		assertEquals(3,v);
	}
	
	
	@Test
	public void test1() throws Exception {
	
		Solution sol = new Solution();
		sol.src = "P2T1.txt";
		int v = sol.calc();
		
		assertEquals(2,v);
	}
	
	
	
	
	
	@Test
	public void test2() throws Exception {
	
		Solution sol = new Solution();
		sol.src = "P2T2.txt";
		int v = sol.calc();
		
		assertEquals(0,v);
	}
	@Test
	public void test3() throws Exception {
	
		Solution sol = new Solution();
		sol.src = "P2T3.txt";
		int v = sol.calc();
		
		assertEquals(24,v);
	}

}
