package problem692;

class Solution {
    
    class Node implements Comparable
    {
        public String val;
        public int count;       
        
        public Node(String val)
        {
            this.val = val;
            count = 1;
        }
        
        @Override
        public int compareTo(Object o1)
        {
            Node other = (Node) o1;
            
            if (other.count - this.count != 0)
                return  (other.count - this.count);
            else
            {
                
                return this.val.compareTo(other.val); /*
                int c1 = 0;
                
                //for (Integer i : this.val.length())
                for (int i = 0; i < this.val.length(); i++)
                {
                    c1 = c1*10 + (this.val.charAt(i) - ('a' - 1));
                }
                
                int c2 = 0;
                //for (Integer i : other.val.length())
                for (int i = 0; i < other.val.length(); i++)
                {
                    c2 = c2 * 10 + (other.val.charAt(i) - ('a' - 1));
                }
                
                return c1 - c2; */
            }
        }
        
    }
    
    Map<String, Integer> keyMap;
    List<Node> nodes;
    int n;
    
    public List<String> topKFrequent(String[] words, int k) {
        nodes = new ArrayList();
        keyMap = new HashMap();
        n = 0;
        
        for (String w: words)
        {
            if (!keyMap.containsKey(w))
            {                
                nodes.add(new Node(w));                
                keyMap.put(w, n++);
            }
            else
            {
                int idx = keyMap.get(w);
                nodes.get(idx).count++;
            }
        }
        
        List<String> ans = new LinkedList();                  
        Collections.sort(nodes);
        Iterator<Node> it = nodes.iterator();
        while(it.hasNext())
        {
            ans.add(it.next().val);
            if (ans.size() == k)
                break;
        }
                          
        return ans;                  
        
    }
}