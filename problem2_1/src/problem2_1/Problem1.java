package problem2_1;

import java.util.LinkedList;
import java.util.HashSet;
import java.util.List;
import codingInterviewLinkedList.Node;

public class Problem1 {
	
	LinkedList<Integer> l;
	HashSet<Integer> hs;
	
	
	
	public Node process(Node list)
	{
		hs = new HashSet<Integer>();
		Node head = list;
		
		if (list!= null)
			hs.add(list.data);
		
		 while (list != null )
		{
			
			if (list.next != null)
			{
			
				
			Integer val  = list.next.data;
			while (val != null && hs.add(val)==false)
			{
				//if (list.next!= null)
					list.next = list.next.next;
					
					if (list.next == null)
						val = null;
					else
						val = list.next.data;
						
			}
			}
									
			
			list = list.next;
		}

		return head;
	}
	
	public Node processWithNoBuffer (Node list)
	{
		Node head = list;
		
		while (list!=null)
		{
			Node sList = list;
			while(sList != null && sList.next != null)
			{
				if (sList.next.data == list.data)
				{
					sList.next = sList.next.next;
				}
				
				sList = sList.next;
			}
			
			list = list.next;
		}
		
		return head;
	}
	
	
	public List<Integer> process(List<Integer> list)
	{
		l = (LinkedList<Integer>) list;
		hs = new HashSet<Integer>();

		for (int i = 0; i < l.size(); i++)
		{
			Integer val  = l.get(i);

			if (hs.add(val)==false)
			{
				l.remove(i);
				i--;
			}
		}

		return l;
	}
	
	
	public List<Integer> processWithNoBuffer(List<Integer> list)
	{
		l = (LinkedList<Integer>) list;
		
		for (int i = 0; i < l.size(); i++)
		{
			Integer val = l.get(i);
			
			for (int j = i+1; j < l.size(); j++)
			{
				Integer val1 = l.get(j);
				if (val == val1)
				{
					l.remove(j);
					j--;
				}
			}
		}
		
		return l;
	}

	public static void main(String[] args) {
	
		
		Node n = new Node(1);
		n.appendToTail(1);
		n.appendToTail(3);
		n.appendToTail(3);
		n.appendToTail(5);
		n.appendToTail(1);
		n.appendToTail(7);
		
		

		
		Problem1 p = new Problem1();
		Node out_l = p.processWithNoBuffer(n);
		
		while (out_l != null)
		{
			System.out.println(out_l.data);
			
			out_l = out_l.next; 
		}
		
		/*
		 * the output is :
		 	1
			5
			0
			10
		 */

	}
}
