package problem54;

class Solution {
    
    boolean visited[][];
    int h,w;
    int mtx[][];
    int dir[];
    int dirnum;
    public List<Integer> spiralOrder(int[][] matrix) {
                
        List<Integer> ans = new LinkedList<>();
        h = matrix.length;
        if (h==0)
            return ans;
        w = matrix[0].length;
        mtx = matrix;
        dir = new int[] {0,1};
        dirnum = 0;
        
        visited = new boolean[h][w];
        
        int stop = 0;
        int posi = 0;
        int posj = -1;
       
        while(true) {
            stop = 0;
            for (int i = 0; i < 4; i++) {
                if (exists(posi+dir[0], posj+dir[1])) {
                    break;
                }
                changedir();
                stop++;
            }
            
            if (stop==4) {
                return ans;
            }
            
            while (exists(posi+dir[0], posj+dir[1])) {
                posi += dir[0];
                posj += dir[1];
                ans.add(mtx[posi][posj]);
                visited[posi][posj] = true;

            }
        }
                        
    }
    
    void changedir() {
        switch(dirnum) {
            case 0:
                dirnum = 1;
                dir = new int[]{1,0};
                break;
            case 1:
                dirnum = 2;
                dir = new int[]{0,-1};
                break;
            case 2:
                dirnum = 3;
                dir = new int[]{-1, 0};
                break;
            case 3:
                dirnum = 0;
                dir = new int[]{0,1};
                break;                
        }
        return;
    }
    
    boolean exists(int i, int j) {
        if (i<0 || j < 0 || i >= h || j >= w || visited[i][j])
            return false;
        return true;
    }
}