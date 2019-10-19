package problem1228;

class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int diff = (arr[n-1] - arr[0]) / n;
        for (int i = 0; i < arr.length-1; i++) {
            int v = arr[i+1] - arr[i];
            
            if (diff != v ) {
                return arr[i] + diff;
            }                        
        }
                
        return arr[0];        
    }
}