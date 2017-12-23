package problem354;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test1() {
		

			//[[2,100],[3,200],[4,300],[5,500],[5,400],[5,250],[6,370],[6,360],[7,380]]
		Solution sol = new Solution();
		
		int env[][] = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
		int ans = sol.maxEnvelopes(env);
		
		assertEquals(5, ans);
	}

}
