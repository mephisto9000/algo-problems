package problem142;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if (head == null)
            return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        boolean started = false;
        while(fast!=null)
        {
            if (started)
            {
                if (fast == slow)
                    break;
            }    
                if (fast.next != null && fast.next.next!=null)
                    fast = fast.next.next;
                else
                    return null;
                    
                slow = slow.next;
            
                
            started = true;
        }
        
        
        
        if (fast == null)
            return null;
        
        slow = head;
        while(slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        
        return fast;
    }
}