package problem328;

class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if (head == null || head.next == null || head.next.next == null)
            return head;
        
        ListNode oddList = null;        
        ListNode evenList = null;
        
        ListNode runner = head;
        ListNode evenHead = head.next;
        
        int c = 1;
        
        while(runner != null)
        {
            if (c % 2 != 0)
            {
                //odd
                if (oddList == null)
                    oddList = runner;
                else
                {
                    oddList.next = runner;
                    oddList = oddList.next;                
                }
            }
            else
            {
                //even
                if (evenList == null)
                    evenList = runner;
                else
                {
                    evenList.next = runner;                
                    evenList = evenList.next;
                }
            }
            
            c++;
            runner = runner.next;
        }
        
        if (c % 2 == 0)
        	evenList.next = null;
        
        oddList.next = evenHead;
        
        return head;
        
    }
}