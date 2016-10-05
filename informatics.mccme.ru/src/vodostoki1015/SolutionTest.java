package vodostoki1015;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() throws Exception{
		
		
		Solution sol = new Solution();
		sol.src = "input1015_1.txt";
		
		assertEquals(4, sol.calc());
	}

}
