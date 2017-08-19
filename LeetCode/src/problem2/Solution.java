package problem2;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int len1 = 0;
        int len2 = 0;
        ListNode tmp = l1;
        while(tmp!= null)
        {
            len1 ++;
            tmp = tmp.next;
        }
        tmp = l2;
        
        while(tmp!= null)
        {
            len2 ++;
            tmp = tmp.next;
        }
        
        
        ListNode tail = null; 
        ListNode head = null;
        int shift = 0;
        while(len1 >0 || len2 > 0 || shift > 0)
        {       
            if (tail == null)
                tail = new ListNode(0);
            else
            {
                tail.next = new ListNode(0);
                tail = tail.next;
            }
            
            if (len1 > 0 && len2 > 0)  
            {
                tail.val = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
                len1 --;
                len2 --;
            }
            else
            if (len1 > len2)
            {
                tail.val = l1.val;
                l1 = l1.next;
                len1 --;
            }
            else
            if (len2 > len1)
            {
                tail.val = l2.val;
                l2 = l2.next;
                len2 --;
            }
            
           
            
            tail.val += shift;
            shift = 0;
            
            if (tail.val >=  10 )
            {
                shift = (tail.val / 10);
                tail.val = tail.val % 10;
            }
            
            if (head == null)
                head = tail; 
            
        }
        
        return head;
        
        
        
    }
}