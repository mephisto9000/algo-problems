
package problem2_2;

import codingInterviewLinkedList.Node;

public class Problem2 {

	public Node kToLast(Node l, int k)
	{
		Node head = l;
		int kk = 0;
		
		if (l == null)
			return null;
		
		l = l.next;
		
		while (l!=null)
		{
			if (kk < k)
				kk++;
			else
				head = head.next;
			l = l.next;
		}
		
		if (kk < k)
			return null;
		else
			return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node n = new Node(1);
		n.appendToTail(2);
		n.appendToTail(3);
		
		Problem2 p = new Problem2();
		
		Node n1 = p.kToLast(n, 1);
		
		if (n1 == null)
			System.out.println("null =(");
		else
			System.out.println(n1.data);
			
		

	}

}
