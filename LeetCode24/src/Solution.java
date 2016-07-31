

 
public class Solution {
	
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	  
	  public ListNode createListNode(int v)
	  {
		  return new ListNode(v);
		  
	  }


	  
    public ListNode swapPairs(ListNode head) {
        
        ListNode top = head;
        
        boolean move = false;
        while (top!= null && top.next != null) //
        {
            ListNode tmp = top;
           // ListNode next = top.next.next;
            tmp.next = tmp.next.next;
            
            top = top.next;
            top.next = tmp;
            //top.next.next = next;
            
            if (move == false)
            {
                move = true;
                head =top;
            }
            
            
            top = tmp.next;
            
        }
        
        return head;
        
    
    }

	public static void main(String[] args) {
		

		//Solution.ListNode l1 = new Solution.ListNode(1);
		Solution sol = new Solution();
		
		ListNode l1 = sol.createListNode(1);
		l1.next = sol.createListNode(2);
		l1.next.next = sol.createListNode(3);
		//l1.next.next.next = sol.createListNode(4);
		
		l1 = sol.swapPairs(l1);
		
		
		while(l1 != null)
		{
			System.out.println(l1.val);
			l1 = l1.next;
		}
		
		
		
		
		

	}

}
