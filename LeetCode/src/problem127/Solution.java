package problem127;

class Solution {    
    
    String start;
    String end;
    
    int n;
    class Node
    {
        String val;        
        int idx;
        public int dist;
        List<Node> neighbours;
        
        public Node(String val, int idx)
        {
            this.val = val;
            this.idx = idx;
            dist = 0;
            neighbours = new LinkedList<Node>();
        }               
        void addNode(Node node)
        {
            neighbours.add(node);
        }
    }
    
    Node[] nodes;
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       
        n = wordList.size();
        start = beginWord;
        end = endWord;
        nodes = new Node[wordList.size()+1];
        Iterator it = wordList.iterator();        
        nodes[0] = new Node(start, 0);
        for (int i = 0; i < n; i++)
        {
            nodes[i+1] = new Node((String)it.next(), i+1);
        }
        n++;
        for (int i = 0 ; i < n; i++)
        {
            for (int j = i; j < n; j++)
            {
                Node a = nodes[i];
                Node b = nodes[j];
                
                if (calcDiff(a.val, b.val) == 1)
                {
                    a.addNode(b);
                    b.addNode(a);
                }
            }
        }
        
        boolean visited[] = new boolean[n];
        Arrays.fill(visited,false);
        
        Queue<Node> q = new LinkedList();
        q.add(nodes[0]);
        visited[0] = true;
        
        
        while(!q.isEmpty())
        {
            Node node = q.poll();
            
            if (node.val.equals(end))
                return node.dist+1;            
                    
            for (Node tmp : node.neighbours)
            {
                if (visited[tmp.idx])
                    continue;
                visited[tmp.idx] = true;
                tmp.dist = node.dist +1;
                q.add(tmp);
            }
        }
        
        return 0;        
        
    }
    
    int calcDiff(String s1, String s2)
    {
        int ans = 0;
        for (int i = 0;  i < s1.length(); i++)
            if (s1.charAt(i)!=s2.charAt(i))
                ans ++;
        
        return ans;
    }
}