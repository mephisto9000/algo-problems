package Problem2;

import static org.junit.Assert.*;

import org.junit.Test;

public class P2Test {

	@Test
	public void test1() throws Exception {
		//fail("Not yet implemented");
		
		
		Solution sol = new Solution();
		
		sol.src = "P2T1.txt";
		
		String ans = sol.calc();
		
		assertEquals("Yes",ans);
	}
	
	
	@Test
	public void test2() throws Exception {
		//fail("Not yet implemented");
		
		
		Solution sol = new Solution();
		
		sol.src = "P2T2.txt";
		
		String ans = sol.calc();
		
		assertEquals("Yes",ans);
	}
	
	@Test
	public void test3() throws Exception {
		//fail("Not yet implemented");
		
		
		Solution sol = new Solution();
		
		sol.src = "P2T3.txt";
		
		
		
		String ans = sol.calc();
		
		assertEquals("No",ans);
	}
	
	@Test
	public void test4() throws Exception {
		//fail("Not yet implemented");
		
		
		Solution sol = new Solution();
		
		sol.src = "P2T4.txt";
		
		;
		
		String ans = sol.calc();
		
		assertEquals("Yes",ans);
	}
	
	
	//aba abaa 2
	
	@Test
	public void test5() throws Exception {
		//fail("Not yet implemented");
		
		
		Solution sol = new Solution();
		
		sol.src = "P2T5.txt";
		
		;
		
		String ans = sol.calc();
		
		assertEquals("No",ans);
	}

}
