import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
	
	String src = null;
	
	int[] arr;
	
	public String calc() throws Exception
	{
		BufferedReader br = null;
		
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		String[] vals = br.readLine().split(" ");
		
		int n = Integer.parseInt(vals[0]);
		long k = Long.parseLong(vals[1]);
		
		vals = br.readLine().split(" ");
		
		arr = new int[n];
		
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(vals[i]);
		
		
		long p = 0;
		for (int i = 0; i < n; i++)
		{
			int maxI = i;
			
			for (int j = i+1; j < n; j++)
			{
				if (arr[maxI] < arr[j])
				{
					maxI = j;
				}
				
 
			}
			
			if (p < k && maxI != i)
			{
				swap(i, maxI);
				p++;
			}
			
			if (p >= k)
				break;
		}
		
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < n; i++)
		{
			sb.append(arr[i]);
			sb.append(' ');
		}
		
		return sb.toString().trim();
		
	}
	
	void swap(int i, int j)
	{
		int v = arr[j];
		arr[j] = arr[i];
		arr[i] = v;
	}
	

	public static void main(String[] args) throws Exception{

		Solution sol = new Solution();
		
		String s = sol.calc();
		System.out.println(s);

	}

}
