import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] vals = br.readLine().split(" ");
		
		int n = Integer.parseInt(vals[0]);
		int k = Integer.parseInt(vals[1]);
		
		String s = br.readLine();
		
		ArrayList ar = new ArrayList();
		
		int z = 0;		
		for (int i = 0; i < s.length(); i++)
		{
			if (ar.isEmpty())
				ar.add(1);
			
			if (s.charAt(i) == 1)
			{
				Integer it = (Integer) ar.remove(z);
				it++;
				ar.add(it);
			}
			else
			{
				ar.add(1);
			}
			
		}
		
		int dist = Math.floorDiv(k, 2);
		
		for (int i = 0; i < ar.size(); i++)
		{
			System.out.println(ar.get(i));
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < ar.size(); i++)
		{
			int tmp = 0;
			for (int j = i+1; j < ar.size(); j++)
			{
				tmp += (Integer) ar.get(j);
				
			}
			
			if (tmp < min)
				min = tmp;
		}
		
		System.out.println(min);
		
	}
	
	public static void main(String[] args) throws Exception {


		Solution sol = new Solution();
		
		sol.calc();

	}

}
