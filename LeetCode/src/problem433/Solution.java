package problem433;

class Solution {    
    String mtx[][];    
    private class Node {
        public String val;
        public int id;        
        public int dist;
        
        public Node(String val, int id) {
            this.val = val;
            this.id = id;
            dist = -1;
        }
    }
    
    public int minMutation(String start, String end, String[] bank) {
        int l = bank.length;
        mtx = new String[l][l];
        int idx = 0;        
        Node nodes[] = new Node[l];       
        Queue<Node> q = new LinkedList();
        int dist = 0;
        
        if (start.equals(end))
            return 0;
        
        for (String m : bank) {
            Node tmp = new Node(m, idx);
            
            if (diff(start, m)==1) {
                tmp.dist = 1;
                q.add(tmp);         
            }
            nodes[idx++] = tmp;
        }
        
        boolean reached = false;
        while(!q.isEmpty()) {
            Node node = q.poll();
            
            if (node.val.equals(end)) {
                return node.dist;
            }
            
            for (int i = 0; i < l; i++) {
                if (!nodes[i].val.equals(node.val) && nodes[i].dist == -1 && diff(nodes[i].val, node.val)==1)  {
                    nodes[i].dist = node.dist + 1;
                    q.add(nodes[i]);
                }
            }
            
        }
        
        return -1;
        
        
    }
    
    int diff(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i)!=b.charAt(i))
                cnt++;
            
        return cnt;
    }
}