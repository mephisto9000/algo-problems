package Problem1;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test1 {

	@Test
	public void test() throws Exception {
		Solution sol = new Solution();
		
		sol.src = "t1.txt";
		
		assertEquals("2 2 2", sol.calc());
	}

}
