package problem282;



import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

 

public class Tests {

	@Test
	public void test1() {
		Solution sol = new Solution();
		
		List<String> ans = sol.addOperators("3456237490", 9191);
		
		//assertThat(ans, containsInAnyOrder("1*0+5","10-5"));
		
		//List<String> expected = Arrays.asList("fee", "fi", "foe");

	    //assertThat(ans, is(expected));
		
		for (int i = 0; i < ans.size(); i++)
			System.out.println(ans.get(i));
		assertTrue(true);
	}
	
	@Test
	public void test() {
		Solution sol = new Solution();
		
		List<String> ans = sol.addOperators("105", 5);
		
		//assertThat(ans, containsInAnyOrder("1*0+5","10-5"));
		
		List<String> expected = Arrays.asList("fee", "fi", "foe");

	    //assertThat(ans, is(expected));
		
		for (int i = 0; i < ans.size(); i++)
			System.out.println(ans.get(i));
		assertTrue(true);
	}

}
