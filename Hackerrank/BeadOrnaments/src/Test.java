import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test0() throws Exception {
		

		Solution sol = new Solution();
		sol.src = "test0.txt";
		int[] ans =sol.calc();
		int[] check = {2, 4, 16, 9, 125};
		
		assertArrayEquals(check, ans);
	}
	@Test
	public void test2() throws Exception {
		

		Solution sol = new Solution();
		sol.src = "test2.txt";
		int[] ans =sol.calc();
		int[] check = {399140623,
						825293440,
						200080283,
						626239447,
						2,
						576,
						16807,
						60466176,
						15895884,
						73540699,
						125,
						350000000,
						262144,
						495820493,
						968500007,
						16807,
						207169496,
						511672491,
						490733568,
						123884397};
		
		assertArrayEquals(check, ans);
	}

}
