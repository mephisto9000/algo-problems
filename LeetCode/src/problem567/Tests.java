package problem567;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class Tests {

	@Test
	
	//@Ignore
	public void test() {
		Solution sol = new Solution();
		String s1 = "hello";
		String s2 = "ooolleoooleh";
		
		assertFalse(sol.checkInclusion(s1, s2));
	}
	
	@Test
	public void test1() {
		Solution sol = new Solution();
		String s1 = "abc";
		String s2 = "ccccbbbbaaaa";
		
		assertFalse(sol.checkInclusion(s1, s2));
	}
	
	

}
