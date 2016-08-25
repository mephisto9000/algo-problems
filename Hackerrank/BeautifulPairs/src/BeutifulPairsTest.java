import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BeutifulPairsTest {

	Solution sol;
	
	@Before
	public void setUp() throws Exception {
		
		//String args[] = {"input1.txt"};
		sol = new Solution();
	}

	@Test
	public void test1() {
		sol.fname = "input1.txt";
		try {
			int v = sol.calc();
			assertEquals(3, v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("error");
		}
		
		
		
	}
	
	
	@Test
	public void test4() {
		sol.fname = "input4.txt";
		try {
			int v = sol.calc();
			assertEquals(999, v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("error");
		}
		
		
		
	}

}
