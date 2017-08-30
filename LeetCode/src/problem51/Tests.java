package problem51;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		
		Solution sol = new Solution();
		
		List<List<String>> ans = sol.solveNQueens(10);
		
		for (int i = 0; i < ans.size(); i++ )
		{
			List<String> l = ans.get(i);
			
			for (int j = 0; j < l.size(); j++)
			{
				System.out.println(l.get(j));
			}
			
			System.out.println();
		}
		
		System.out.println(ans.size());
		
	}

}
