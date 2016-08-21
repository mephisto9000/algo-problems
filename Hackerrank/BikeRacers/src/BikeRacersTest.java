import static org.junit.Assert.*;

import org.junit.Before;
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
		int expected = 19069;
		try {
			assertEquals(expected, (int) sol.calc().doubleValue());
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
		int expected = 40000;
		try {
			assertEquals(expected, (int) sol.calc().doubleValue());
			System.out.println("test0 pass");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Exception e = "+e.toString());
		}
		
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
		sol.setFilename("input2.txt");
		int expected = 28010;
		try {
			assertEquals(expected, (int) sol.calc().doubleValue());
			System.out.println("test2 pass");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Exception e = "+e.toString());
		}
		
	}

}
