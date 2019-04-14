package problem685;

class Solution {
    
    class Node {
        public int vertex;                 
        public List<Edge> edges;
        Node[] parent;
        
        public Node(int vertex) {
            this.vertex = vertex;
            edges = new ArrayList<>();
            parent = new Node[2];
        }
       
    }
  
  class Edge {
    public Node from;
    public Node to;
    int idx;
    boolean visited = false;
    public Edge(Node from, Node to, int idx) {
      this.from = from;
      this.to = to;
      this.idx = idx;
    }
  }
  
  HashMap<Integer, Node> nodeMap;
  List<Edge> edgeList;
  boolean visited[];
  boolean mode2parents = false;
 
  public int[] findRedundantDirectedConnection(int[][] edges) {
    int n = edges.length;

    nodeMap = new HashMap<>();
    edgeList = new ArrayList<>();
    //int possibl
    for (int i = 0; i < n; i++) {
      int[] edge = edges[i];
      Node from = nodeMap.getOrDefault(edge[0], new Node(edge[0]));
      Node to = nodeMap.getOrDefault(edge[1], new Node(edge[1]));
          
      nodeMap.put(edge[0], from);
      nodeMap.put(edge[1], to);
      Edge e = new Edge(from, to, i);
      from.edges.add(e);
      edgeList.add(e);

      if (to.parent[0]==null)
        to.parent[0] = from;
      else {
        to.parent[1] = from;
        mode2parents = true;
      }
      
     }
    
    visited = new boolean[edgeList.size()];
         
    for (int i = n-1; i >= 0; i--) {
      Arrays.fill(visited, false);
      Edge e = edgeList.get(i);
      Edge ansEdge = dfs(e, e);
      if (ansEdge!=null) {
        if (mode2parents==false)
          return new int[] {ansEdge.from.vertex, ansEdge.to.vertex};
        else
          if (e.to.parent[1]!=null)
            return new int[] {ansEdge.from.vertex, ansEdge.to.vertex};
      }
    }
    
    
    for (int i = n-1; i >= 0; i--) {
      
      Edge e = edgeList.get(i);
      
      if (e.to.parent[1] != null)
        return new int[] {e.from.vertex, e.to.vertex};
    } 
    
    return null;
     
    }
    
  Edge dfs(Edge e, Edge src) {
     if (e==src && visited[e.idx])
       return e;
    if (visited[e.idx])
      return null;
    visited[e.idx] = true;
    Edge ans = null;
    for (Edge ne: e.to.edges) {
      Edge inn = dfs(ne, src);
      if (inn != null)
        return inn;
 
    }
    return null;
  }
    
    
}