import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	
	
	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		
		
		List<Integer> a = new LinkedList<Integer>();
		List<Integer> b = new LinkedList<Integer>();
		
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			a.add(Integer.parseInt(s[i]));
		
		s = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			b.add(Integer.parseInt(s[i]));
		
		int ans = 0;
		for (int i = 0; i < a.size(); i++ )
			for (int j = 0; j < b.size(); j++ )
			{
				int max = (a.get(i) > b.get(j) ) ? a.get(i) : b.get(j);
				
				int min = (a.get(i) < b.get(j) ) ? a.get(i) : b.get(j);
				
				if (max % min > 0)
				{
					//System.out.println("{"+a.get(i) + "  "+b.get(j)+"}");
					
					a.remove(i);
					b.remove(j);
					//i--;
					//j--;
					ans ++;
					//break;
				}
			}
		
		System.out.println(ans);
	}

	public static void main(String[] args) throws Exception{

		Solution sol = new Solution();
		
		sol.calc();

	}

}
