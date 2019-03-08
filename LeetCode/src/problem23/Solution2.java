package problem23;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
      if (lists == null || lists.length == 0)
        return null;
      
      PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
        @Override
        public int compare(ListNode a, ListNode b) {
          return a.val - b.val;
        }
      });
      
      for (int i = 0; i < lists.length; i++) {
        if (lists[i]!=null)
          pq.add(lists[i]);
      }
      
      ListNode dummy = new ListNode(0);
      ListNode last = dummy;
      while(pq.size() > 0) {
        ListNode top = pq.poll();
        if (top.next != null) {
          pq.add(top.next);
        }
        
        top.next = null;
        last.next = top;
        last = top;
        
      }
      return dummy.next;
    }
}