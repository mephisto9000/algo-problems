package problem593;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class Tests {

	
	@Test
	 
	public void test() {
		Solution sol = new Solution();
		
		int p1[] = {1,0};
		int p2[] = {-1,0};
		int p3[] = {0,1};
		int p4[] = {0,-1};
		
		assertTrue(sol.validSquare(p1, p2, p3, p4));
		
		
	}
	
	
	@Test
	public void test1() {
		Solution sol = new Solution();
		
		int p1[] = {0,0};
		int p2[] = {1,1};
		int p3[] = {1,0};
		int p4[] = {0,1};
				 
		assertTrue(sol.validSquare(p1, p2, p3, p4));
		
		
	} 
	
	@Test
	public void test2() {
		Solution sol = new Solution();
		
		int p1[] = {0,0};
		int p2[] = {1,1};
		int p3[] = {1,0};
		int p4[] = {1,1};
				 
		assertFalse(sol.validSquare(p1, p2, p3, p4));
		
		
	}

}
