import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
	
	int[] numbers;
	List<Integer> fixpoints;
	
	List<Integer> result;
	
	
	
	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] vals = br.readLine().split(" ");
		
		numbers = new int[vals.length];
		
		for (int i = 0; i < vals.length; i++)
		{
			numbers[i] = Integer.parseInt(vals[i]);
		}
		
		fixpoints = new ArrayList<Integer>();
		fixpoints.add(0);
				
		Set<Integer> h = new HashSet<Integer>();
		h.add(0);
		for (int i = 1; i < n-1; i++)
		{
			//if (i-1 == 0 || i+1 == (n-1) || fixpoints.c)
			if (numbers[i-1] == numbers[i] || numbers[i+1] == numbers[i])
			{
				fixpoints.add(i);
				h.add(i);
			}
		}
		
		fixpoints.add(n-1);
		h.add(n-1);
		
		//for (int i = 0; i < fixpoints.size(); i++)
		//	System.out.print(fixpoints.get(i));
		
		
		
		int max = 0;
		
		
		result = new LinkedList<Integer>();
		for (int i = 0; i < n; i++)
		{
			
			//if (fixpoints.contains(i))
			if (h.contains(i))
			{
				result.add(numbers[i]);
				continue;
			}
			
			int tmp = distance(i, 0, fixpoints.size()-1);
			if (tmp > max)
			    	max = tmp;
			    	
		}
		
		//System.out.println("done");
		
		System.out.println(max);
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.size()-1; i++)
			//System.out.print(result.get(i)+ " ");
			{
			sb.append(result.get(i));
			sb.append(" ");
			}
		
		sb.append(result.get(result.size()-1));
		System.out.println(sb.toString());
		
	}
	
	public int distance(int idx, int start, int end)
	{
		
		//System.out.println("here! start = "+fixpoints.get(start)+"("+start+")"+"end = "+fixpoints.get(end)+"("+end+")"+" idx = "+idx);
		if (end - start <= 1)
		{
			int a = Math.abs(idx - fixpoints.get(start));
			int b = Math.abs(idx - fixpoints.get(end));
			//int v =  Math.min(Math.abs(idx - fixpoints.get(start)), Math.abs(idx - fixpoints.get(end)));
			int v;
			int newVal;
			if (a < b)
			{
				v = a;
				newVal = numbers[fixpoints.get(start)];
			}
			else
			{
				v = b;
				newVal = numbers[fixpoints.get(end)];
			}
			
			//System.out.println("start = "+fixpoints.get(start)+"end = "+fixpoints.get(end)+" idx = "+idx);
			
			result.add(newVal);
			return v;
		}
		
		int middle = (int)((end - start) / 2.0f + start);
		
		//System.out.println("middle == "+fixpoints.get(middle)+"("+middle+")");
		if (fixpoints.get(middle) >= idx)
			return distance(idx, start, middle);
		else
			return distance(idx, middle, end);	
					
	}

	public static void main(String[] args) throws Exception {

		Solution sol = new Solution();
		
		
			sol.calc();
		
		
		

	}

}
