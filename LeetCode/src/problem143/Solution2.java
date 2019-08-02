package problem143;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        
        Deque<ListNode> deque = new ArrayDeque<ListNode>();
        
        ListNode tmp = head;
        while(tmp!=null) {
            deque.add(tmp);
            tmp = tmp.next;
        }
        
        ListNode tail = null;
        while(!deque.isEmpty()) {
            tmp = deque.pollFirst();
            if (tail == null)
                tail = tmp;
            else {                
                tail.next = tmp;
                tail = tmp;
            }
            
            if (!deque.isEmpty()) {
                tmp = deque.pollLast();
                tail.next = tmp;
                tail = tmp;
            }
        }
        if (tail != null)
            tail.next =null;
        
    }
}