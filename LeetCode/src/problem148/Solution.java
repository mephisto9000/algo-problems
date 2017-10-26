package problem148;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        
        if (head == null)
            return null;
        
        List<Integer> l = new LinkedList<Integer>();
        
        while(head != null)
        {
            l.add(head.val);
            head = head.next;
        }
        
        Collections.sort(l);
        
        Iterator it = l.iterator();
        ListNode h = null;
        ListNode t = null;
        while(it.hasNext())
        {
            int v = (Integer) it.next();
            
            if (h == null)
            {
                h = new ListNode(v);
                t = h;
            }
            else
            {
                ListNode temp = new ListNode(v);
                t.next = temp;
                t = temp;
            }
        }
        
        return h;
            
        
    }
}