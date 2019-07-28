package problem399;

class Solution {    
class Node {    
    String key;    
    Map<Node, Double> paths;
    
    public Node(String key) {
        this.key = key;
        paths = new HashMap<>();
    }
    
    void addPath(Node node, double val) {
        paths.put(node, val);
    }
    
    @Override
    public int hashCode() {
        return key.hashCode();
    }
    
    @Override
    public boolean equals(Object o) {
        return this.key.equals(((Node) o).key);
    }
}   
            
public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    
    Map<String, Node> graph = new HashMap<>();
    
    int en = equations.size();
    int qn = queries.size();
    
    for (int i = 0; i < en; i++) {
        String src = equations.get(i).get(0);
        String dst = equations.get(i).get(1);
        
        Node sNode = graph.getOrDefault(src, new Node(src));
        Node dNode = graph.getOrDefault(dst, new Node(dst));
        
        graph.put(src, sNode);
        graph.put(dst, dNode);
        
        double val = values[i];
        
        sNode.addPath(dNode, val);
        dNode.addPath(sNode, 1/val);
                        
    }
    
    double ans[] = new double[qn];
    
    for (int i = 0; i < qn; i++) {
        String src = queries.get(i).get(0);
        String dst = queries.get(i).get(1);
        
        if (!graph.containsKey(src)||!graph.containsKey(dst)) {
            ans[i] = -1;
            continue;
        }
                    
        Queue<String> q = new  ArrayDeque<>();
        Map<String, Double> visited = new HashMap<>();        
        q.add(src);
        visited.put(src, 1.0d);
        
        double dist = -1;
        while(!q.isEmpty()) {
            String s = q.poll();
            Node node = graph.get(s);
            double price = visited.get(node.key);
            
            if (s.equals(dst)) {
                dist = visited.get(s);
                break;
            }
            
            Set<Node> keys = node.paths.keySet();
            for (Node nextNode: keys) {
                if (visited.containsKey(nextNode.key))
                    continue;
                visited.put(nextNode.key, price * node.paths.get(nextNode));
                q.add(nextNode.key);
            }
        }
        ans[i] = dist;
    }    
    return ans;                
    }
}