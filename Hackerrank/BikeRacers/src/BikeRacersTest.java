import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BikeRacersTest {
	Solution sol ;
	
	

	@Before
	public void setUp() throws Exception {
		
		sol = new Solution();
	}

	
	@Test
	public void test1() {
		System.out.println("test1");
		sol.setFilename("input1.txt");
		long expected = 19069;
		try {
			assertEquals(expected, sol.calc() );
			System.out.println("test1 pass");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Exception e = "+e.toString());
		}
		
	}
	
	@Test
	public void test0() {
		System.out.println("test0");
		sol.setFilename("input0.txt");
		long expected = 40000;
		try {
			assertEquals(expected,  sol.calc());
			System.out.println("test0 pass");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Exception e = "+e.toString());
		}
		
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
		sol.setFilename("input2.txt");
		int expected = 28010;
		try {
			assertEquals(expected, sol.calc());
			System.out.println("test2 pass");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Exception e = "+e.toString());
		}
		
	}
	
	

	
	
	
	@Test
	public void test10() {
		System.out.println("test10");
		sol.setFilename("input10.txt");
		long expected = 64163812;
		try {
			assertEquals(expected, sol.calc());
			System.out.println("test10 pass");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Exception e = "+e.toString());
		}
		
	} 
	
	@Test
	public void test4() {
		System.out.println("test4");
		sol.setFilename("input4.txt");
		long expected = 42565;
		try {
			assertEquals(expected, sol.calc());
			System.out.println("test4 pass");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Exception e = "+e.toString());
		}
		
	} 
	
	@Test
	public void test5() {
		System.out.println("test5");
		sol.setFilename("input5.txt");
		long expected = 51311849;
		try {
			assertEquals(expected, sol.calc());
			System.out.println("test5 pass");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Exception e = "+e.toString());
		}
		
	} 

}
