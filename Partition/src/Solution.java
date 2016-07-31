import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	public void calc() throws Throwable
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[]arr = br.readLine().split(" ");
		
		int pivot = Integer.parseInt(arr[0]);
		
		List<Integer> valsLess = new LinkedList<Integer>();
		List<Integer> valsMore = new LinkedList<Integer>();
		
		for (int i = 1; i < n; i++)
		{
			int v = Integer.parseInt(arr[i]);
			
			if (v < pivot)
				valsLess.add(v);
			
			if (v > pivot)
				valsMore.add(v);
		}
		
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < valsLess.size(); i++)
		{
			sb.append(valsLess.get(i));
			sb.append(" ");
		}
		
		sb.append(pivot);
		sb.append(" ");
		
		for (int i = 0; i < valsMore.size(); i++)
		{
			sb.append(valsMore.get(i));
			sb.append(" ");
			
		}
		
		String s = sb.toString().trim();
		
		System.out.println(s);
		
		
	}
	
	
	public static void main(String[] args) throws Throwable{

		Solution sol = new Solution();
		sol.calc();

	}

}
