package problem6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
	
	String src = null;
	
	
	public class Node
	{
		public Node next;
		public Node prev;
		
		public char val;
		
		
		public Node(char c)
		{
			next = null;
			prev = null;
			val = c;
			
		}
		
		public Node addNew(char c)
		{
			Node newNode = new Node(c);
			next = newNode;
			
			newNode.prev = this;
			
			return newNode;
		}
	}
	
	public int[] calc() throws Exception
	{
		BufferedReader br = null; 
		
		if (src == null)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(src));
		
		int q = Integer.parseInt(br.readLine());
		
		int [] ans = new int[q];
		for (int i = 0; i < q; i++)
		{
			String s = br.readLine();
			
			
			Node head = new Node(s.charAt(0));
			Node tail = head;
			
			//order chars as a reference
			//for (int j = 1; j < s.length(); j++)
			char[] ref =  new char[s.length()]; //s.toCharArray();
			
			ref[0] = s.charAt(0);
			for (int j = 1; j < s.length(); j++)
			{
				char c = s.charAt(j);
				ref[j] = c;
				
				tail = tail.addNew(c); 
			}
			
			int ansTmp = 0;
			
			Arrays.sort(ref);
			
			head.prev = tail;
			tail.next = head;
			
			for (int j = 1; j < s.length(); j++)
			{
				char c0 = s.charAt(j- 1); //ref[j]
				char c1 = s.charAt(j);
				
				if (c0 > c1) 								
					ansTmp ++;
			}
			
			ans[i] = ansTmp;
			   
			/*
			for (int j = 0; j < s.length(); j++)
			{
				
				if (head == null)
					break;
					
				char c = ref[j];
				
				if (ref[j] == head.val)
				{
					head = head.next;
					System.out.println("here "+c);
					continue;
				}
				
				
				System.out.println(" expect "+c+" found "+head.val);
				
				//char c = ref[j];
				
				ansTmp++;
				
 
				Node tmpHead = head;
				Node tmpTail = tail;
				while(tmpHead != tmpTail)
				{
  					System.out.println("here !!!!");
					if (tmpHead.val == c)
					{
						//tmpTail2.next = head;
						
						//Node t = tmpHead;
						
						
						 
						tmpHead =  tmpHead.next;
						tmpHead.prev = tmpHead.prev.prev;
						
						head = tmpHead;//.next;
						break;
					}
					
					if (tmpTail.val == c)
					{
						
						
						//Node t = tmpTail;
						
						
						 
						tmpTail =  tmpTail.prev;
						tmpTail.next = tmpTail.next.next;
						
						head = tmpTail.next;  // or prev ???
						break;
					}
					
					tmpHead = tmpHead.next;
					tmpTail = tmpTail.next;
					
						
				}
				
				
				
				ans[i] = ansTmp;
			}  */
		}
		
		return ans;
		
	}

	public static void main(String[] args) throws Exception{

		Solution sol = new Solution();
		
		int[] arr = sol.calc();
		
		for (int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}

	}

}
