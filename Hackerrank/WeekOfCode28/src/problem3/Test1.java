package problem3;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test1 {

	@Test
	public void test0() throws Exception{
		Solution sol = new Solution();
		sol.src = "p3t0.txt";
		assertEquals(3, sol.calc());
	}
	
	@Test
	public void test1() throws Exception{
		Solution sol = new Solution();
		sol.src = "p3t1.txt";
		assertEquals(51, sol.calc());
	}
	
	
	@Test
	public void test2() throws Exception{
		Solution sol = new Solution();
		sol.src = "p3t2.txt";
		assertEquals(2, sol.calc());
	}

}
