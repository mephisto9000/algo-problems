package problem206;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  ListNode last = null;
    public ListNode reverseList(ListNode head) {
      
    //return reverseListIteratively(head);
    reverseRec(null, head);
    return last;
        
    }
  
  void reverseRec(ListNode prev, ListNode head) {
    
    if (head == null)
      return;
    
    last = head;
    ListNode next = head.next;
    head.next = prev;
    reverseRec(head, next);
    
    
  }
  
  
  ListNode reverseListIteratively(ListNode head) {
    ListNode prev = null;
    while(head!=null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    
    return prev;
  }
}

