import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Test {

	@org.junit.Test
	public void test() throws Exception{
		Solution sol = new Solution();
		
		sol.src = "case2.txt";
		
				
		BufferedReader br = new BufferedReader(new FileReader("case2answer.txt"));
		String[] ans = br.readLine().split(" ");
		
		String[] teststr = sol.calc().split(" ");
		assertArrayEquals(ans, teststr);
	}

}
