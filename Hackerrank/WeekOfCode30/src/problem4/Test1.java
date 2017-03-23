package problem4;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test1 {

	@Test
	public void test1() throws Exception{

		Solution sol = new Solution();
		sol.src = "p4t1.txt";
		int v = sol.calc();
		assertEquals(47, v);
		
	}

}
