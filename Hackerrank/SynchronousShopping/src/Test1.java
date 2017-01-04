import static org.junit.Assert.*;

import org.junit.Test;

public class Test1 {

	@Test
	public void test0() throws Exception{
	
		Solution sol  =new Solution();
		sol.src = "test1.txt";
		
		assertEquals(30, sol.calc());
	}
	
	@Test
	public void test5() throws Exception{
		
		Solution sol  =new Solution();
		sol.src = "test5.txt";
		
		assertEquals(2989, sol.calc());
	}
	
	
	@Test
	public void test30() throws Exception{
		
		Solution sol  =new Solution();
		sol.src = "test30.txt";
		
		assertEquals(2922, sol.calc());
	}

}
