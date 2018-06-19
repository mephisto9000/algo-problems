package problem68;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		String w[] = {"This", "is", "an", "example", "of", "text", "justification."};
		List<String> ans = sol.fullJustify(w, 16);
		
		List<String> exp = Arrays.asList( "This    is    an",
				   "example  of text",
				   "justification.  ");
		
		Assert.assertEquals(w, exp);
	}

}
