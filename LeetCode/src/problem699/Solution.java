package problem699;

class Solution {
    
    private class Square {
        int posLeft;
        int posRight;
        int height;
        
        public Square(int id, int posLeft, int posRight, int side) {            
            this.posLeft = posLeft;
            this.posRight = posRight;            
            this.height = side;
        }
    }
        
    int tree[];                 
    int update(int l, int r, int h) {
        
        int max = 0;
        for (int i = l; i <= r; i++)
            max = Math.max(tree[i], max);
        max += h;
        for (int i = l; i <= r; i++)
            tree[i] = max;
        return max;
    } 
    
         
    public List<Integer> fallingSquares(int[][] positions) {
                                
        ArrayList<Square> sqList= new ArrayList();
        
        Set<Integer> compressed = new HashSet();
        
        for (int i = 0; i<positions.length; i++) {
            compressed.add(positions[i][0]);
            compressed.add(positions[i][0]+positions[i][1]-1);
        }
        
        List<Integer> complist = new ArrayList(compressed);
        Collections.sort(complist);
        Map<Integer, Integer> indexMap = new HashMap();
        for (int i = 0; i < complist.size(); i++)
            indexMap.put(complist.get(i), i);
        
        for (int i = 0; i < positions.length; i++) {   
            
            int lb = indexMap.get(positions[i][0]);
            int rb = indexMap.get(positions[i][0]+positions[i][1]-1);
            sqList.add(new Square(i, lb, rb, positions[i][1])); 
        }
                         
        List<Integer> ans = new LinkedList();
        
        tree = new int[positions.length*2];
        int max = 0; 
        for (int i = 0; i < sqList.size(); i++) {
            Square s = sqList.get(i);            
            max = Math.max(max, update(s.posLeft, s.posRight, s.height));             
            ans.add(max); 
        }
        return ans;
        
    }
}