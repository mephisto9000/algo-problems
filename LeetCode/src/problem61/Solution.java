package problem61;



/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) { val = x; }
* }
*/
class Solution {
   public ListNode rotateRight(ListNode head, int k) {
       
       ListNode cur = head;
       ListNode newHead = null;
       
       ListNode shiftNode = head;
       int len = 0;
       
 
       
       
       if (head == null || head.next == null || k == 0)
           return head;
       
       
       while(cur.next != null)
       {
           cur = cur.next;
           len ++;
       }
       len++;
       cur.next = head;
       
       cur = head;
       
       int i = 0;
       
       k = k % len;
       
       while(i < (len-k-1))
       {
       	cur = cur.next;
       	i++;
       }
       
       newHead = cur.next;//.next;
       cur.next = null;
        
       
       
       
           
       return newHead;
       
   }
}