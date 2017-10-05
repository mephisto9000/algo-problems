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
    
    ListNode deep;
    
    public ListNode reverseList(ListNode head) {
        
        if (head == null)
            return null;
        
        ListNode end = rev(head);
        end.next = null;
       
        return deep;
    }
    
    
    public ListNode rev(ListNode node)
    {
        if (node == null)
            return null;
        
        deep = node;
       
        
        ListNode n = rev(node.next);
        
        if (n!= null)
            n.next = node;
        
        return node;
    }
}