package problem147;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return head;
        ListNode current = head;
        ListNode next = head.next;
        current.next = null;          
        int x = 0;                
        ListNode newHead = current;
        ListNode newTail = current;        
        while(current!=null) {            
            if (current.val < newHead.val) {
                current.next = newHead;
                newHead = current;
            } else
            {
                ListNode t = newHead;
                boolean found = false;
                while(t != newTail) {  
                    if (t.val <= current.val && t.next.val > current.val) {
                        ListNode after = t.next;
                        t.next = current;
                        current.next = after;
                        found = true;
                        break;
                    }
                    t = t.next;
                }
            
                if (!found ) {
                    newTail.next = current;
                    current.next = null;
                    newTail = current;
                }
            }
                        
            current = next;
            if (next!= null)
                next = next.next;
        }
        
        return newHead; 
    }
}