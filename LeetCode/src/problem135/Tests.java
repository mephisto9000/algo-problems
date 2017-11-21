package problem135;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		int rats[] = {1,2};
		int ans = sol.candy(rats);
		
		int exp = 3;
		
		assertEquals(exp,ans);
	}

}
