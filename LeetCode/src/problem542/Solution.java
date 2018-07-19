package problem542;

class Solution {
    
    int outmtx[][];
    int mtx[][];
    int w,h;
    
    class Pair {
        int i;
        int j;
        int val;
        public Pair(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
    
    public int[][] updateMatrix(int[][] matrix) {
        mtx = matrix;
        h = mtx.length;
        w = mtx[0].length;
        outmtx = new int [h][w];
        
        Queue<Pair> q = new LinkedList();
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++) {
                outmtx[i][j] = -1;
                if (mtx[i][j] == 0) {
                    Pair p = new Pair(i,j,0);
                    q.add(p);
                    outmtx[i][j] = 0;
                }
            }
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
            
            if (outmtx[p.i][p.j]== -1)
                outmtx[p.i][p.j] = p.val;           
            
            testCreate(1,0, p, q);
            testCreate(-1,0, p, q);
            testCreate(0,1, p, q);
            testCreate(0,-1, p, q);            
            
        }
        
        return outmtx;        
    }
    
    void testCreate(int i_off, int j_off, Pair root, Queue<Pair> q) {
        if (root.i+i_off< 0 || root.i+i_off >= h || root.j+j_off < 0 || root.j+j_off >= w || outmtx[root.i+i_off][root.j+j_off]!=-1)
            return;
        
        Pair v = new Pair(root.i+i_off, root.j+j_off, root.val + 1);        
        if (v != null)
            q.add(v);
    }
}