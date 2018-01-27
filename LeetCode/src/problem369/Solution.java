package problem369;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
     
        
        if (process(head))
        {
            ListNode top = new ListNode(1);
            top.next = head;
            head = top;
        }
        return head;
    }
    
    public boolean process(ListNode root)
    {
        if (root == null)
            return true;
        
        if (process(root.next))
            {
                if (root.val <9)
                {
                    root.val ++;
                    return false;
                }
                else
                {
                    root.val = 0;
                    return true;
                }
            }
            
        return false;    
    }
}