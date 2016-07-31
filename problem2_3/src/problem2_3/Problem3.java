package problem2_3;

import codingInterviewLinkedList.Node; 


public class Problem3 {

	public void process (Node list)
	{
		while (list.next != null)
		{
			list.data = list.next.data;
			
			if (list.next.next!=null)
			   list = list.next;
			else
			   list.next = null;
			
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node list = new Node(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(4);
		list.appendToTail(5);
		
		Node middle = list.next.next;
		
		
		Problem3 p3 = new Problem3();
		p3.process(middle);
		
		while (list!= null)
		{
			System.out.println(list.data);
			list = list.next;
		}
		

	}

}
