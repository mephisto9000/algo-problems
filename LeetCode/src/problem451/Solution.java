package problem451;

class Solution {
    public String frequencySort(String s) {
        
        class Node  implements Comparable
        {
            public Character c;
            public int cnt;
            
            public Node(Character c)
            {
                this.c = c;
                cnt = 1;
            }
            
            public void inc()
            {
                cnt++;
            }
            
            public int compareTo(Object o)
            {
                Node x = (Node) o;                
                
                return x.cnt - cnt;
            }
            
        }
        
        Map<Character, Node> map = new HashMap();
        
        for (int i = 0; i < s.length(); i++)
        {
            Character c = s.charAt(i);
            if (map.containsKey(c))
            {
                Node x = map.get(c);
                x.inc();
            }
            else
            {
                Node x = new Node(c);
                map.put(c,x);
            }
        }
        
        Iterator it = map.entrySet().iterator();
        List<Node> nodes = new LinkedList();
        StringBuffer sb = new StringBuffer();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Node x = (Node) pair.getValue();
            
            nodes.add(x);
            
        
        }
        
        Collections.sort(nodes);
        
        Iterator<Node> nit = nodes.iterator();
        
        while(nit.hasNext())
        {
            Node x = nit.next();
            for (int i = 0; i< x.cnt; i++)
            {
                sb.append(x.c);
            }            
        }
        
        
        
        return sb.toString();
        
    }
}