package problem21;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode dummyHead = new ListNode(0);
        ListNode ptr = dummyHead;
        while(l1!=null || l2 != null) {
            if (l2 != null && (l1 == null || l2.val < l1.val)) {
                ptr.next = new ListNode(l2.val);
                l2 = l2.next;
            } else
            if (l1!= null && (l2 == null || l1.val <= l2.val)) {
                ptr.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            ptr = ptr.next;
            
        }
        
        return dummyHead.next;
        
    }
}