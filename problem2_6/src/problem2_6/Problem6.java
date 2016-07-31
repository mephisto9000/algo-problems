package problem2_6;

import codingInterviewLinkedList.Node;

public class Problem6 {
	
	public Node process(Node n)
	{
		if (n == null)
			return null;
		
		
		Node slow = n;
		Node fast = n;
		
		int count = 0;
						
		while (true)
		{
			slow = slow.next;
			
			
			
			fast = fast.next;
			if (fast == null)
				return null;
			
						
			if (count != 0 && slow == fast)
				return findStartLoop(n, fast);
			
			fast = fast.next;
			if (fast == null)
				return null;
			
			if ( slow == fast)
				return findStartLoop(n, fast);
			
			count ++;
		}
		
		//return null;
				
	}
	
	public Node findStartLoop(Node start, Node inLoop)
	{
		 
		
		while(inLoop!=start)
		{
			start = start.next;
			inLoop = inLoop.next; 
		}
		
		
		return start;
		
	}

}
