package problem725;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        
        int size = 0;
        
        ListNode tmp = root;
        while(tmp!=null) {
            tmp = tmp.next;
            size++;
        }
        
        ListNode[] ans = new ListNode[k];
        int idx = 0;
        if (k >= size) {
            
            for (int i = 0; i < k; i++) {
                ans[i] = root;
                if (root!= null) {
                    tmp = root.next;
                    root.next = null;
                    root = tmp;
                }
                
            }
                
        } else {
            int clusterSize = (int) Math.floor(size / ((float) k));
            int remainder = size % k;
            
            for (int i = 0; i < k; i++) {
                int cs = clusterSize;
                if (remainder-- > 0)
                    cs++;
                
                ans[i] = root;
                for (int j = 1; j < cs; j++) {
                    root = root.next;
                }
                
                tmp = root.next;
                root.next = null;
                root = tmp;                                                
            }
        }
        
        return ans;
        
    }        
}