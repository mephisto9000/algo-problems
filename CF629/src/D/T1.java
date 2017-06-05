package D;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class T1 {

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void test0() throws Exception{
		

		Solution sol = new Solution();
		
		sol.src = "test0.txt";
		
		long ans = (long)sol.calc();
		
		assertEquals(3983, ans);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test1() throws Exception{
		

		Solution sol = new Solution();
		
		sol.src = "test1.txt";
		
		long ans = (long)sol.calc();
		
		assertEquals(110, ans);
	}

}
