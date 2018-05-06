package problem133;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        cloned = new HashMap();        
        return cloneNode(node);
    }
    
    Map<Integer, UndirectedGraphNode> cloned;
    UndirectedGraphNode cloneNode(UndirectedGraphNode node) {
        if (cloned.containsKey(node.label)) {
            return cloned.get(node.label);
        }
        
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        cloned.put(node.label, newNode);
                
        for (UndirectedGraphNode tmpNode : node.neighbors) {
            newNode.neighbors.add(cloneNode(tmpNode));
        }
        return newNode;
    }
    
}