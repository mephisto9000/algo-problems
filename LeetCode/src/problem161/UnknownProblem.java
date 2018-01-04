package problem161;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class UnknownProblem {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int l1 = 0;
        int l2 = 0;
        
        ListNode tmp = headA;
        while(tmp!=null)
        {
            tmp = tmp.next;
            l1++;
        }
        
         tmp = headB;
        while(tmp!=null)
        {
            tmp = tmp.next;
            l2++;
        }
        
        return rec(headA, headB, l1, l2, 0,0);
        
        
        
    }
    
    ListNode rec(ListNode a, ListNode b, int l1, int l2, int cl1, int cl2)        
    {
        while(true)
        {
        while(l1 - cl1 != l2 - cl2)
        {
            if (l1 - cl1 > l2 - cl2)
            {
                a = a.next;
                cl1 ++;
            }
            else
            {
                b = b.next;
                cl2 ++;
            
            }
        }
        
        if(a == null || b == null)
            return null;
        
        if (a == b)
            return a;
        
            //return rec(a.next, b.next, l1, l2, (cl1+1), (cl2+1));
            a = a.next;
            b = b.next;
            cl1++;
            cl2++;
        }
        
    }
    
}