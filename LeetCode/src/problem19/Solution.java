package problem19;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        
        int pos = 0;
        ListNode dad = head;
        ListNode res = head;
        
        while(head != null)
        {
            if (pos > (n))
                {
                    dad = dad.next;
                
                }
           
            pos++;
            head = head.next;
        }
        
        if (n ==  pos )
            res = res.next;
                
        if (dad != null && dad.next != null )                
                {
                    if (dad.next.next != null)
                        dad.next = dad.next.next;
               else
                {
                    dad.next = null;
                }
                }
             
        return res;
        
        }
}