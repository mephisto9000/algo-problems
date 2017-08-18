package problem83;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        
        if (head == null)
            return null;
        
        ListNode node = head.next;
        ListNode prev = head;
        while (node != null)
        {
            if (prev.val != node.val)
                prev = node;
            else
                prev.next = node.next;
            
            
            node = node.next;
        }
            
        return head;
        
    }
}
