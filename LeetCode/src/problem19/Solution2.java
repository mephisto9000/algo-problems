package problem19;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dad = null;
        ListNode tmp = head;
        int cnt = 0;
        
        while(tmp != null) {
            cnt ++;
            if (cnt > n) {
                if (dad == null)
                    dad = head;
                else
                    dad = dad.next;
                
            }
                
            tmp = tmp.next;
        }
        
        if (dad == null)
            return head.next;
         
        dad.next = dad.next.next;
             
        return head;
        
        }
}