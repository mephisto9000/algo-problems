package problem2_7;

import codingInterviewLinkedList.Node;

public class Problem7 {
	
	public boolean process(Node n)
	{
		int count = 0;
		
		if (n == null)
			return false;
		
		if (n!=null && n.next == null)
			return true;
		
		Node head = n;		
		Node reverse = null;
		
		while(n!=null)
		{
			count++;
			Node x = new Node(n.data);
			
			x.next = reverse;
			reverse = x;
			n = n.next;
			
		}
		
		n = head;
		
		for (int i = 0; i < count; i++)
		{
			if (n.data != reverse.data)
				return false;
			
			n = n.next;
			reverse = reverse.next;
		}
		
		return true;
		
	}

}
