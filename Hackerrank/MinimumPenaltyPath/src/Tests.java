import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() throws Exception{
		
		Solution sol = new Solution();
		sol.src = "test0.txt";
		
		
		assertEquals(3,sol.calc());
		//asser  
	}
	
	
	@Test
	public void test1() throws Exception{
		
		Solution sol = new Solution();
		sol.src = "test1.txt";
		
		
		assertEquals(7,sol.calc());
		//asser  
	}
	
	
	@Test
	public void test2() throws Exception{
		
		Solution sol = new Solution();
		sol.src = "testDisc1.txt";
		
		
		assertEquals(10,sol.calc());
		//asser  
	}

}
