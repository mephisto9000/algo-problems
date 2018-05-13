package problem234;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    int h = 0;
    boolean isEven = false;
    public boolean isPalindrome(ListNode head) {
                
        ListNode it = head;
        
        while(it != null) {
            h++;
            it = it.next;
        }
        
        if (h <2 )
            return true;
        
        if (h % 2 == 0)
            isEven = true;
        
        
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        return rec(1, dummy);
        
    }
    
    boolean rec(int lh, ListNode head) {
        if (lh == Math.ceil(h /2.0f)) {
            if (isEven == false) {
                head.next = head.next.next;   
                return true;
            }} else
                            
        if (!rec(lh+1,head.next))    
            return false;
        if (head.next.val == head.next.next.val) {
            head.next = head.next.next.next;
            return true;
        }
        return false;
    }
    
    
}