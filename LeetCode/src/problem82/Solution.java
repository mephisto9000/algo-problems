package problem82;

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
        
        ListNode node = head;
        ListNode prevNode = null;
        int dv = Integer.MIN_VALUE;
        boolean started = false;
        while (node != null)
        {
            
            if (node.next!= null && node.val == node.next.val)
            {
                dv = node.val;
                started = true;
            }
            
            if (node.val == dv && started)
            {
                if (node == head)
                    head = node.next;
                
                if (prevNode != null)
                    prevNode.next = node.next;
                
                
                
            }
            else           
                prevNode = node;
            node = node.next;
        }
        
        return head;
    }
}