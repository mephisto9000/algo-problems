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
        
        int cnt = 0;
        ListNode l = head;
        ArrayList<ListNode> nodes = new ArrayList();
        while(l != null)
        {
            nodes.add(l);
           // nodes.get(cnt).next = null;
            l = l.next;
            cnt ++;
        }
        
        //ListNode nodes[] = new ListNode[cnt];
        l = head;
        int ofst = 0;
        for (int i = 2; i <= cnt; i++)
        {
            int idx = ofst;
            if (i % 2 == 0)
            {
                idx = cnt - ofst -1;
                ofst ++;
            }
           // idx --;
            l.next = nodes.get(idx);
            l = l.next;
            
            l.next = null;
        }
        
        
        
    }
}