package problem773;

class Solution {
    
    class Node {
        
        int config[][];
        int move;
                
        public Node(int config[][], int move) {
            this.config = config;
            this.move = move;
        }
        
        List<Node> mutate() {
            int zi = -1;
            int zj = -1;
            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 3; j++) {
                    if (config[i][j]==0) {
                       zi = i;
                       zj = j; 
                        break;
                    }
                }
            
            List<Node> ans = new ArrayList<>();
            if (zi == 0) {
                int[][] newCfg = copyConfig();
                newCfg[zi][zj] = newCfg[1][zj];
                newCfg[1][zj] = 0;
                ans.add(new Node(newCfg, move+1));
            } else {
                int[][] newCfg = copyConfig();
                newCfg[zi][zj] = newCfg[0][zj];
                newCfg[0][zj] = 0;
                ans.add(new Node(newCfg, move+1));
            }
            
            if (zj > 0) {
                int[][] newCfg = copyConfig();
                newCfg[zi][zj] = newCfg[zi][zj-1];
                newCfg[zi][zj-1] = 0;
                ans.add(new Node(newCfg, move+1));
            }
            
            if (zj < 2) {
                int[][] newCfg = copyConfig();
                newCfg[zi][zj] = newCfg[zi][zj+1];
                newCfg[zi][zj+1] = 0;
                ans.add(new Node(newCfg, move+1));
            }
            
            return ans;
            
        }
        
        int[][] copyConfig() {
            int copy[][] = new int[2][3];            
            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 3; j++)
                    copy[i][j] = config[i][j];            
            return copy;
        }
        
        @Override
        public int hashCode() {
            int v = 0;
            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 3; j++)
                    v = v*10 + config[i][j];
            
            return v;
        }
        
        @Override 
        public boolean equals(Object o) {
            Node otherNode = (Node) o;
            
            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 3; j++)
                    if (config[i][j]!=otherNode.config[i][j])
                        return false;
            return true;
        }
    }
    
    public int slidingPuzzle(int[][] board) {
        
        Node src = new Node(board, 0);
        int destCfg[][] = {{1,2,3}, {4,5,0}};
        
        Node dest = new Node(destCfg, 0);
                    
        Queue<Node> q = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        q.add(src);
        visited.add(src);
        
        while(!q.isEmpty()) {
            Node tmp = q.poll();
            if (tmp.equals(dest))
                return tmp.move;
            
            List<Node> nextOperations = tmp.mutate();
            for(Node nextTmp : nextOperations) {
                if (!visited.contains(nextTmp)) {
                    visited.add(nextTmp);
                    q.add(nextTmp);
                }
            }
        }            
        return -1;                
    }
}