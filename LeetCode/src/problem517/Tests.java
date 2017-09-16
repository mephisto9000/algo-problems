package problem517;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {
	
	 

	@Test
	public void test() {
		

		Solution sol = new Solution();
		int machines[] = {0,0,11,5};
		
		int ans = sol.findMinMoves(machines);
		int exp = 8;
		assertEquals(exp,ans);
	}

	
	@Test
	public void test1() {
		

		Solution sol = new Solution();
		int machines[] = {9,1,8,8,9};
		
		int ans = sol.findMinMoves(machines);
		int exp = 4;
		assertEquals(exp,ans);
	}

}

//[9,1,8,8,9]
