package problem904;

class Solution {
    Map<Integer, Integer> occurences;
    public int totalFruit(int[] tree) {       
        occurences = new HashMap();        
        int max = 0;
        int localMax = 0;        
        int leftIdx = 0;
        int rightIdx = 0;
        
        while(true) {
            int v = occurences.getOrDefault(tree[rightIdx], 0);
            occurences.put(tree[rightIdx++], v+1);
            
             while(occurences.size() > 2) {
                int vl = occurences.get(tree[leftIdx])-1;
                if (vl == 0) 
                    occurences.remove(tree[leftIdx]);
                 else
                    occurences.put(tree[leftIdx], vl);
                    
                leftIdx++;                    
            }
            
            localMax = (rightIdx - leftIdx);
            if (localMax > max)
                max = localMax;
            
            if (rightIdx == tree.length)
                break;            
        }        
        
        return max;
    }
}