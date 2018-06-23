package problem817;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        
        Set<Integer> gset = new HashSet(); //Arrays.asList(G));
        for (int i =0; i < G.length; i++)
            gset.add(G[i]);
        boolean found = false;
        int ans = 0;
        while(head!=null) {
            if (gset.contains(head.val)) {
                if (!found) {
                    found = true;
                    ans++;
                }
            } else {
                if (found) {
                    found = false;
                }
            }
            head = head.next;
        }
        
        return ans;
        
    }
}