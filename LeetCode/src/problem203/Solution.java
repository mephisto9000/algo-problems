package problem203;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode ans = head;
        ListNode left = head;
        ListNode right = null;
        
        while(head!=null)
        {
            
            if (head.val == val)
            {
                right = head.next;
                while(right!=null && right.val == val)
                    right = right.next;
                
                if (head != ans)
                    left.next= right;
                else
                {
                    head = right;
                    ans = right;
                    
                }
                
            }
            
            left = head;
            
            if (head!= null)
                head = head.next;           
            
        }
        
        return ans;
        
    }
}