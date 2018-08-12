package problem876;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        
        int cnt = 0;
        ListNode tmp = head;
        while(tmp!=null) {
            cnt++;
            tmp = tmp.next;
        }
        
        for (int i = 0; i < cnt / 2; i++)
            head = head.next;
        
        return head;
        
    }
}