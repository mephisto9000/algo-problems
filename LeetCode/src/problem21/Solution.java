package problem21;

public class Solution {
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
/*
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
*/

	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		ListNode ans = null;
		ListNode ansTail = null;
		
		
		while(l1!=null || l2!=null)
		{
			ListNode min ; ///= l1.x
			
			if (l1 != null && l2 != null)
			{
				//min = l1.val < l2.val ? l1 : l2;
				if (l1.val < l2.val)
				{
					min = new ListNode(l1.val);
					l1 = l1.next; 
				}
				else
				{
					min = new ListNode(l2.val);
					l2 = l2.next;
				}
			}
			else
			{
			if (l1 != null)
			{
				min = new ListNode(l1.val);
				l1 = l1.next;
			}
			else			
			{
				min = new ListNode(l2.val);
				l2 = l2.next;
			}
			}
			
			if (ans == null)
			{
				ans = min;
				ansTail = min;
			}
			else
			{
				ansTail.next = min;
				ansTail = ansTail.next;
			}
			
				
		}
		return ans;
	}

}
