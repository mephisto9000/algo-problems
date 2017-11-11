package problem514;

class Solution {
    
    class Node
    {
        public Node right;
        public Node left;
        
        public char val;
        public int idx;
        
        public Node(char val, int idx)
        {
            this.val = val;
            this.idx = idx;
        }
    }
    
    String ring;
    String key;
    int n;
    
     Map<String, Integer> memo;
    
    public int findRotateSteps(String ring, String key) {
        
        Node head = null;
        Node tail = null;
        this.ring = ring;
        this.key = key;
        n = key.length();
        
        memo = new HashMap();
        
        for (int i = 0; i < ring.length(); i++)
        {
            char c = ring.charAt(i);
            if (head == null)
            {
                head = new Node(c, i);
                tail = head;
            }
            else
            {
                 Node tmp = new Node(c, i);
                tmp.left = tail;
                tail.right = tmp;
                tail = tmp;
            }
        }
        head.left = tail;
        tail.right = head;
        
        int steps = rec(0, head);
        
        steps += n;
        return steps;
    }
    
    int rec(int idx, Node node)
    {
        if (idx >= n)
            return 0;
        
        String memoKey = idx+"_"+node.idx;
        if (memo.containsKey(memoKey))
            return memo.get(memoKey);
        
        char keyLetter = key.charAt(idx) ;
        if (node.val == keyLetter)
            return rec(idx+1, node);
        
        boolean left_turn = false;
        boolean right_turn = false;
        Node ln = node;
        Node rn = node;
        int lcnt = 0;
        int rcnt = 0;
        while(!left_turn || !right_turn)
        {
            if (!left_turn)
            {
                if (ln.val != keyLetter)
                {
                    lcnt ++;
                    ln = ln.left;
                }
                else
                {
                  left_turn = true;
                }                
                
            }
            
            if (!right_turn)
            {
                if (rn.val != keyLetter)
                {
                    rcnt ++;
                    rn = rn.right;
                }
                else
                {
                    right_turn = true;
                }
            }
        }
        
        int ans1 = lcnt + rec(idx + 1, ln);
        int ans2 = rcnt + rec(idx + 1, rn);
        
        memo.put(memoKey,Math.min(ans1, ans2));
        return memo.get(memoKey);
        
    }
}