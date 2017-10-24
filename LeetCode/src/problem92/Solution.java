package problem92;



/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) { val = x; }
* }
*/
class Solution {
   
   ListNode d = null;
   ListNode s = null;
   
   public ListNode reverseBetween(ListNode head, int m, int n) {
       
        if (head == null || head.next == null || m == n)             
            return head;
        
        ListNode dh = new ListNode (-1);
        
        dh.next = head;
       
        ListNode r = rec(dh, 0, m,   n);
        
        s.next = d;
       return dh.next;
       
   };
   
   public ListNode rec(ListNode head, int idx, int m, int n)
   {
       if (head == null)
           return null;
       
       if (idx < m)
       {
           head.next = rec(head.next, idx+1, m, n);
           return head;
       }
       
      
       if (idx == m)
           s = head;
       
       if (idx == n)
           d = head.next;
       
       if (idx > n)
       {
           return null;
       }
           
       
       if (idx >= m && idx <= n)
       {
       	
       	ListNode next = head.next;
           ListNode deep = rec(head.next, idx + 1, m, n);
           
           if (deep != null)
               next.next = head;
           else
               deep = head;
           
           //if (idx == m)
          //     head.next = d;
           return deep;
       }
       
       return null;
       
   }
}