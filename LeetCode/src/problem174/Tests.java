package problem174;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class Tests {

	@Test	
	public void test() {
		Solution sol = new Solution();
		
		int[][] map = {{0,-3}};
		int ans = sol.calculateMinimumHP(map);
		int exp = 4;
		
		assertEquals(exp, ans);
	}
	
	
			
	@Test
	public void test1() {
		Solution sol = new Solution();				
		int[][] map = {{0,5},{-2,-3}};
		int ans = sol.calculateMinimumHP(map);
		int exp = 1;
				
		assertEquals(exp, ans);
	}
	
	@Test
	public void test2() {
		Solution sol = new Solution();				
		int[][] map = {{0,0,0},{1,1, -1}};
		int ans = sol.calculateMinimumHP(map);
		int exp = 1;
				
		assertEquals(exp, ans);
	}

}
