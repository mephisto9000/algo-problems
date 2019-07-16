package problem2;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ansr = merge(l1, l2);
        return (ansr);
        
    }
    
    ListNode merge(ListNode l1, ListNode l2) {
        
        int carry = 0;
        ListNode head = null;
        ListNode tail = null;
        while(l1!=null || l2!=null) {
            int v = carry;
            carry = 0;
            if (l1!=null) {
                v+=l1.val;
                l1 = l1.next;
            }
            
            if (l2!=null) {
                v+=l2.val;
                l2 = l2.next;
            }
            
            if (v >=10) {
                carry = v/10;
                v = v%10;
            }
            ListNode tmp = new ListNode(v);
            if (tail == null) {
                tail = tmp;
                head = tmp;
            } else {
                tail.next = tmp;
                tail = tmp;
            }
                        
        }
        
        if (carry > 0) {
            ListNode tmp = new ListNode(carry);
            tail.next = tmp;
        }
        return head;
    }
        
    
}