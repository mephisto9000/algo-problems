import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
	
	int[] nums = {1,2,5,10,20,50, 100};
	int num_size = 6;
	int n;
	
	Set answers;
	int total = 0;

	public void calc() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		n = Integer.parseInt(br.readLine());
		answers = new HashSet();
		
		List<Integer> perms = new LinkedList<Integer>();
		
		//rec(0, perms, 0, num_size);
		rec2(0, 0, num_size);
		
		System.out.println(total);
	}
	
	
	public int rec2(int idx, int sum, int num_idx)
	{
		/*//if (idx > num_size)
		{
			if (sum == n)
			{
				total ++;
				return 0;
			}
			else
			{
				//perms.remove(idx - 1);		
				return -1;
			} 
		} */
		
		if (sum > n)
		{
			//perms.remove(idx-1);
			return -1; //overfit
		}
		
		if (sum == n)
		{
			
			total ++;						
			return 0; 
		}
		
		for (int i = num_idx; i >=0; i--)
		{
			int sum2 = sum + nums[i];
			
			rec2(idx+1, sum2, i);
			
		}
		return 0;
		
		
	}
	
	public int rec(int idx, List<Integer> perms, int sum, int max_num_size)
	{
		
		//printList(perms);
		/*
		if (idx > num_size)
		{
			
			
			
				//printList(perms);
			
			
			if (sum == n)
			{
				printList(perms);
			}
			else
			{
				//perms.remove(idx - 1);		
				return -1;
			} 
		} */
		
		if (sum > n)
		{
			//perms.remove(idx-1);
			return -1; //overfit
		}
		
		if (sum == n)
		{
			
			printList(perms);
			
			//perms.remove(idx-1);
			return 0; 
		}
		
		
		{
			//rec(idx+1, perms)
			//perms.add(e)
			for (int i = 0; i <= max_num_size; i++ )
			{
				perms.add(nums[i]);
				int newSum = sum + nums[i];
				rec(idx+1, perms, newSum,   i);
				
				perms.remove(idx);
			}
		}
		
		return 0;
	}
	
	public void printList(List<Integer> perms)
	{
		//for (i)
		
		
		if (perms.size() == 0)
			return;
		
		if (answers.contains(perms))
			return;
		
		answers.add(perms);
		total ++;
		
		StringBuffer sb = new StringBuffer();
		
		sb.append('(');
		
		int z = 0;
		for (Integer val : perms)
		{
			if (z > 0)
				sb.append(',');
			sb.append(val);
			z++;
		}
		
		sb.append(')');
		
		System.out.println(sb.toString());
		
	}
	
	public static void main(String[] args) throws Exception {
		
		Solution sol = new Solution();
		
		sol.calc();

	}

}
