package problem109;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    List<Integer> list;
    
    public TreeNode sortedListToBST(ListNode head) {
        
        list = new ArrayList();
        
        while(head != null)
        {
            list.add(head.val);
            head = head.next;
        }
        
        
        return rec(0, list.size()-1);
        
        
    }
    
    TreeNode rec(int start, int end)
    {
        TreeNode ans = null;
        if (start == end)
        {
            ans = new TreeNode(list.get(start));            
            return ans; 
        }
        
        if (start > end)
            return null;
        
        int mid = start + (end - start ) / 2;
        ans = new TreeNode(list.get(mid));
        ans.left = rec(start,  mid -1);
        ans.right = rec(mid + 1, end);
        
        return ans;
    }
    
    
}