import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	
	
	class Pair
	{
		public int val;
		public int quantity;
	}

	public void calc() throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input3.txt"));
		
		int n = Integer.parseInt(br.readLine());
		
		String vals[] = br.readLine().split(" ");
		
		int q[] = new int[n];
		
		for (int i = 0; i < n; i++)
			q[i] = Integer.parseInt(vals[i]);
		
		Arrays.sort(q);
		
		int v = 0;
		int p = 0;
		
		
		
		LinkedList<Integer> l = new LinkedList<Integer>();
		
		
		Queue qqq = new PriorityQueue();
		
		Stack<Pair> stack = new Stack<Pair>();
		
		for (int i = 0; i < n; i++)
		{
			l.add(q[i]);
			qqq.add(q[i]);
			
			
		}
		
		
		for (int i = n-1; i >=0; i--)
		{
			if (stack.size()>0)
			{
				Pair pair = stack.peek();
				
				if (pair.val == q[i])
					pair.quantity++;
				
				else
				{
					Pair newPair = new Pair();
					newPair.quantity = 1;
					newPair.val = q[i];
					stack.push(newPair);
				}
				
			}
			else
			{
				Pair newPair = new Pair();
				newPair.quantity = 1;
				newPair.val = q[i];
				stack.push(newPair);
			}
		}
			
		
		int happy = 0;
		int lastHappy = 0;
		
		
		for (int i = 1; i < l.size(); i++)
		{
			int vtx = l.get(i);
			
			if (stack.size()>0)
			{
			Pair pair = stack.peek();
			
			if (pair.val < vtx)
			{
				happy++;
				pair.quantity--;
				if (pair.quantity <=0)
					stack.pop();
			}
			}
		}
		/*
		while(true)
		{
			Iterator it = l.iterator();
			
			int last = 0;
			int idx = -1;
			
			lastHappy = happy;
			
			while (it.hasNext())
			{
				int val =  (Integer) it.next();
				idx ++;
				
				if (val > l.get(last))
				{
					l.remove(idx);
					l.remove(idx-1);
					happy ++;
					break;
				}
				last = idx;
			} 
			
			if (happy == lastHappy)
				break;
			
			
			
		}
		
		
		
		
		*/
		
		
		
		
		System.out.println(happy);
			
		
	}
	
	
	public static void main(String[] args) throws Exception {
		Solution sol = new Solution();
		
		sol.calc();

	}

}
