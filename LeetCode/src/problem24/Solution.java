package problem24;


 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        
        ListNode top = head;
        
        boolean move = false;
        
        ListNode prev = null; 
        
        while (top!= null && top.next != null) 
        {
            
            
            ListNode a = top;
            ListNode b = top.next;
            
            ListNode next = b.next;
            
            if (prev != null)
                prev.next = b;
            else
            {
                head = b;
                prev = b;
                
                
            }
            
            b.next = a;
            a.next = next;
            
            top = next;
            prev = a;
            
            
             
        }
        
        return head;
        
    }


}
