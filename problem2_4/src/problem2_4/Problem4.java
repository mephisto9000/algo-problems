package problem2_4;

import codingInterviewLinkedList.Node;

public class Problem4 {
	
	public Node process (Node head, int x)
	{
		Node list1 = null;
		Node list2 = null;
		
		Node list1tail = null;
		
		
		if (head == null)
			return null;
		
		while(head != null)
		{
			Node a = new Node(head.data);
			
			if (head.data < x)
			{
				if (list1 == null)
					list1tail = a;
				a.next = list1;
				list1 = a;
			}
			else
			{
				a.next = list2;
				list2 = a;
			}
			
			head = head.next;
		}
		
		if (list1!= null && list1tail != null)
		{
			list1tail.next = list2;
			return list1;			
		}
		else
		{
			return list2;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = new Node (3);
		n.appendToTail(10);
		n.appendToTail(5);
		n.appendToTail(7);
		n.appendToTail(-1);
		n.appendToTail(0);
		
		Problem4 p = new Problem4();
		Node x = p.process(null, -10);
		
		while (x != null)
		{
			System.out.println(x.data);
			x = x.next;
		}
	}

}
