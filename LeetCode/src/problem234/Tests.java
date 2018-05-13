package problem234;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		ListNode ln = new ListNode(0);
		ListNode ln2 = new ListNode(0);
		ln.next = ln2;
		ln2 = ln;
		ln = new ListNode(1);
		ln.next = ln2;
		boolean ans = sol.isPalindrome(ln);
		
		assertFalse(ans);				
	}

}
