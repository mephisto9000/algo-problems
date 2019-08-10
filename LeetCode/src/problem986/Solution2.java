package problem986;

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        
        int j = 0;
        List<int[]> ans = new LinkedList<>();
        
        for (int i = 0; i < A.length; i++) {  
            if (j < 0)
                j = 0;
            while(j < B.length && B[j][0] <= A[i][1]) {
                
                                                
                int tmp[] = new int[]{Math.max(B[j][0],A[i][0]), Math.min(B[j][1], A[i][1])};
                
                if (tmp[0] <= tmp[1]) {
                    ans.add(tmp);
                }
                
                j++;    
            }
            j--;
        }
        
        int[][] ansArr = ans.toArray(new int[0][2]);
        return ansArr;
                        
    }
}