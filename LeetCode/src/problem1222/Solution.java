package problem1222;

class Solution {
    
    Set<Integer> q;
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        q = new HashSet<>();
        
        for(int i = 0; i < queens.length; i++) {
            q.add(queens[i][0]*10+queens[i][1]);
            
        }
        
        
    List<List<Integer>> ans = new LinkedList<>();       
    for (int i = 0; i <= 8; i++) {
        if (testAdd(ans, king[0], king[1]+i)) {
            break;
        }
    }
        
    for (int i = 0; i <= 8; i++) {
        if (testAdd(ans, king[0]+i, king[1])) {
            break;
        }
    }
        
    for (int i = 0; i <= 8; i++) {
        if (testAdd(ans, king[0], king[1]-i)) {
            break;
        }
    }
        
    for (int i = 0; i <= 8; i++) {
        if (testAdd(ans, king[0]-i, king[1])) {
            break;
        }
    }
        
    for (int i = 0; i <= 8; i++) {
        if (testAdd(ans, king[0]-i, king[1]-i)) {
            break;
        }
    }
        
    for (int i = 0; i <= 8; i++) {
        if (testAdd(ans, king[0]+i, king[1]+i)) {
            break;
        }
    }    
        
    for (int i = 0; i <= 8; i++) {
        if (testAdd(ans, king[0]-i, king[1]+i)) {
            break;
        }
    }
        
    for (int i = 0; i <= 8; i++) {
        if (testAdd(ans, king[0]+i, king[1]-i)) {
            break;
        }
    }
        
    return ans;
        
    }
    
    boolean testAdd(List<List<Integer>> ans, int i, int j ) {
        if (i < 0 || i >= 8 || j < 0 || j >= 8)
            return true;
        
        int v = (i*10 + j);
        
        if (q.contains(v)) {
            List<Integer> tmp = new LinkedList();
            tmp.add(i);
            tmp.add(j);
            ans.add(tmp);
            return true;
        }
        
        return false;
    }
    
}