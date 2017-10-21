package problem86;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        
        if (head == null )
            return head;
        
        ListNode beforeh = null; //new ListNode()
        ListNode beforet = null;
        
        ListNode afterh = null;
        ListNode aftert = null;
        
        while(head != null)
        {
            if (head.val < x)
            {
                //left
                if (beforeh == null)
                {
                    beforeh = new ListNode(head.val);
                    beforet = beforeh;
                }
                else
                {
                    beforet.next = new ListNode(head.val);
                    beforet = beforet.next;
                }
            }
            else
            {
                //right
                if (afterh == null)
                {
                    afterh = new ListNode(head.val);
                    aftert = afterh;
                }
                else
                {
                    aftert.next = new ListNode(head.val);
                    aftert = aftert.next;
                }
            }            
            
            head = head.next;
        }
        
        if (beforeh != null)
        {
            beforet.next = afterh;        
            return beforeh;
        }
        else
        {
            return afterh;
        }
        
    }
}