package problem2_5;

import codingInterviewLinkedList.Node;

public class Problem5 {
	
	public int process1(Node n1, Node n2)
	{
		int val = 0;
		int mul = 1;
		
		while (n1 != null || n2 != null)
		{
			int t = 0;
			if (n1 != null)
			{
				t += n1.data;
				n1 = n1.next;
			}
			
			if (n2 != null)
			{
				t += n2.data;
				n2 = n2.next;
			}
			
			val += t*mul;
			mul *= 10;
		}
		
		return val;
		
	}
	
	
	public int process2(Node n1, Node n2)
	{
		int sum1 = 0;
		int sum2 = 0;
		//int mul1 = 1;
		//int mul2
		
		while (n1 != null || n2 != null)
		{
			
			if (n1 != null)
			{
				sum1 *= 10;
				sum1 += n1.data;
				n1 = n1.next;
			}
			
			if (n2 != null)
			{
				sum2 *= 10;
				sum2 += n2.data;
				n2 = n2.next;
			}
						
		}
		
		return sum1 + sum2;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
