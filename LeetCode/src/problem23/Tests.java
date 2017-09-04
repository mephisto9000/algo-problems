package problem23;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class Tests {

	@Test
	@Ignore
	public void test() {
	
		ListNode l[] = new ListNode[1];
		
		ListNode l1 = new ListNode(0);
		
		l1.next = new ListNode(2);
		
		l1.next.next = new ListNode(5);
				
		
		l[0] = l1;
		Solution sol = new Solution();
		
		ListNode ans = sol.mergeKLists(l);
		
		StringBuffer sb = new StringBuffer();
		
		//ListNode a = null;
		while(ans != null)
		{
			sb.append(ans.val);
			sb.append('_');
			ans = ans.next;
		}
		
		assertEquals("0_2_5_", sb.toString());
		
		
		
		
	}
	
	
	@Test
	public void test1() {
	
		ListNode l[] = new ListNode[2];
		
		ListNode l1 = new ListNode(1);
		
		ListNode l2  = new ListNode(0);
		
		
				
		
		l[0] = l1;
		l[1] = l2;
		Solution sol = new Solution();
		
		ListNode ans = sol.mergeKLists(l);
		
		StringBuffer sb = new StringBuffer();
		
		//ListNode a = null;
		while(ans != null)
		{
			sb.append(ans.val);
			sb.append('_');
			ans = ans.next;
		}
		
		assertEquals("0_1_", sb.toString());
		
		
		
		
	}

}
