package problem670;

class Solution {
    public int maximumSwap(int num) {
            
      char[] arr = Integer.toString(num).toCharArray();      
      int[] maxRight = new int[arr.length];
      
      maxRight[arr.length-1] = arr.length-1;
            
      for (int i = arr.length-2; i>=0; i--) {
        if (arr[i] > arr[maxRight[i+1]]) {
          maxRight[i] = i;
        } else {
          maxRight[i] = maxRight[i+1];
        }
      }
      
      for (int i = 0; i < arr.length;i++) {
        if (arr[maxRight[i]] > arr[i]) {
          char t = arr[maxRight[i]];
          arr[maxRight[i]] = arr[i];
          arr[i] = t;
          break;
        }
      }
      
      return Integer.valueOf(String.valueOf(arr));
        
    }
}