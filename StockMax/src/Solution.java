import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Solution {
	
	int totalDays;
	int[] price;
		
	
	int totalStock;
	
	
	public Solution(int totalDays)
	{
		super();
		
		this.totalDays = totalDays;
		this.price = new int[totalDays];
		
		totalStock = 0;
	}
	
	
	
	public void addShare(int index, int val)
	{
		price[index] = val;
		totalStock += val;
	}
	
	public long calc()
	{
				
		//int result = rec(0, 0);
		long result = greedy();
		return result;
	}
	
	public long greedy()
	{
		long myStock = 0;//BigInteger.valueOf(0);
		
		//BigInteger myCash = BigInteger.valu//
		long myCash = 0;
		
		//List maxList = new LinkedList();
		int val = Integer.MIN_VALUE;
		//Queue q = new Queue();
		Stack maxStack = new Stack();
		
		boolean keep = false;
		
		for (int i = 0; i < totalDays; i++)
		{
			if (price[i] > val)
			{
				val = price[i];
				keep = true;
			}
			
			
			if (price[i] < val  || i == totalDays - 1)
			{
				
				if (keep)
				{
				while ( !maxStack.isEmpty() && (Integer)maxStack.peek() < val)
				{
					maxStack.pop();
				}
				maxStack.push(val);
				}
				
				val = price[i];
			}
		}
		
		Stack<Integer> reverseStack = new Stack<Integer>();
		
		while (!maxStack.isEmpty())
			reverseStack.push((Integer)maxStack.pop());
		
		
		 keep = false;
		for (int i = 0; i < totalDays; i++)
		{
			if (reverseStack.size()>=1)
			{
				if (price[i] <  reverseStack.peek())
				{
					myStock ++;
					myCash -= price[i];
					//keep = true;
					 
				} else
				{
					//if (keep == true)
					{
					myCash += price[i] * myStock;
					myStock = 0;
					reverseStack.pop();
					keep = false;
					}
				}
				
				//if (price[i] >=)
			}
		}
		
		
		
		//return Math.abs(myCash);
		if (myCash > 0)
			return myCash;
		else
			return 0;
	}
	/*
	public int rec (int day, int myStock)
	{
		int max = 0;
		
		int tmp = 0;
		
		if (day >= totalDays )
			return 0;
		
		
		if (myStock > 0 && memo[day].size()>= myStock)
			return memo[day].get(myStock-1); //[myStock];

		//case 1 - buy
		tmp = -price[day] + rec(day+1, myStock+1);
			if (tmp > max)
				max = tmp;
			
		//case 2,3 - no buy, no sell .... or
		for (int sellCount = 0; sellCount <= myStock; sellCount++ )
		{
		    tmp = sellCount*price[day] + rec(day + 1, myStock - sellCount);
		    if (tmp > max)
		    	max = tmp;
		}
		memo[day].add(max);

		
		return max;
			
	} */
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int t = Integer.parseInt(s); // testcases
		
		StringTokenizer st;
		
		for (int i = 0; i < t; i++)
		{
			
			
			int digits = Integer.parseInt(br.readLine());
			
			Solution sol = new Solution(digits);
			
			s = br.readLine();
			
			st = new StringTokenizer(s);
			
			for (int j = 0; j < digits; j++)
			{
				int share = Integer.parseInt(st.nextToken());
				sol.addShare(j, share);
				
			}
			System.out.println (sol.calc());
		}
	}

}
