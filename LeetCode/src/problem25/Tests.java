package problem25;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		
		Solution sol = new Solution();
		
		
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(6);
		ListNode a7 = new ListNode(7);
		ListNode a8 = new ListNode(8);
		ListNode a9 = new ListNode(9);
		
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;
		a7.next = a8;
		a8.next = a9;
		
		
		ListNode z = sol.reverseKGroup(a1, 2);
		
		StringBuffer sb = new StringBuffer();
		
		while(z!=null)
		{
			sb.append(z.val);
			z = z.next;
		}
		
		assertEquals("214365879", sb.toString());
		
		
		
		
	}
	
	
	@Test
	public void test1() {
		
		Solution sol = new Solution();
		
		
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(6);
		ListNode a7 = new ListNode(7);
		ListNode a8 = new ListNode(8);
		ListNode a9 = new ListNode(9);
		
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;
		a7.next = a8;
		//a8.next = a9;
		
		
		ListNode z = sol.reverseKGroup(a1, 3);
		
		StringBuffer sb = new StringBuffer();
		
		while(z!=null)
		{
			sb.append(z.val);
			z = z.next;
		}
		
		assertEquals("32165478", sb.toString());
		
		
		
		
	}

}
