import static org.junit.Assert.*;

import org.junit.Test;

public class MyTest {

	@Test
	public void test() throws Exception{
		
		Solution sol = new Solution();
		
		sol.src = "test0.txt";
		
		
		int ans = sol.calc();
		
		assertEquals(6, ans);
	}
	
	
	@Test
	public void test9() throws Exception{
		
		Solution sol = new Solution();
		
		sol.src = "test9.txt";
		
		
		int ans = sol.calc();
		
		assertEquals(1093490, ans);
	}

}
