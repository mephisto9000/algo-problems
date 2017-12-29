package problem582;

class Solution {
    
    class Node
    {
        public int pid;
        public int ppid;
        public List<Node> children;
        
        public Node(int pid, int ppid)
        {
            this.pid = pid;
            this.ppid = ppid;
            children = new LinkedList();
        }
        public void addChild(Node node)
        {
            this.children.add(node);
        }
        
    }
    
    Map<Integer, Node> map;
    List<Integer> ans;
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        map = new HashMap();
        ans = new LinkedList();
        
        Iterator pit = pid.iterator();
        Iterator ppit = ppid.iterator();
        
        while(pit.hasNext())
        {
            int tpid = (Integer)pit.next();
            int tppid = (Integer) ppit.next();
            
            Node node = new Node(tpid, tppid);
            map.put(tpid, node); 
        }
        
        pit = pid.iterator();
        ppit = ppid.iterator();
        while(pit.hasNext())
        {
            int tpid = (Integer)pit.next();
            int tppid = (Integer) ppit.next();
            
            if (tppid != 0)
            {
                Node dad = map.get(tppid);
                Node kid = map.get(tpid);
                dad.addChild(kid);
            }
        }
        
        rec(map.get(kill));
        return ans;
                        
    }
    
    void rec(Node root)
    {
        if (root == null)
            return ;
        
        ans.add(root.pid);
        
        Iterator it = root.children.iterator();
        while(it.hasNext())
        {
            Node c = (Node) it.next();
            rec(c);
        }
    }
}