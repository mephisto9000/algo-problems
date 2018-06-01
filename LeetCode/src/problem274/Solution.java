package problem274;

class Solution {
    public int hIndex(int[] citations) {
        
        Arrays.sort(citations);
        int max = 0;
        int n = citations.length;
        for (int i = n-1; i >= 0; i--) {
            if (citations[i] >= n-i)
                max =n-i;
        }
        
        return max;
        
        
    }
}