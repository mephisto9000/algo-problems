package problem487;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        ArrayList<Integer> arr = new ArrayList();
         
        for(int i = 0; i < nums.length; i++) {
            if (nums[i]==0) {
                arr.add(0);                
            }
            else {
                int v = 0;
                if (arr.size()>0 && arr.get(arr.size()-1)!=0)
                    v += arr.remove(arr.size()-1);
                arr.add(v+nums[i]);
            }
        }
        
        int max = 0;
        int prev = 0;
        
        for (int i = 0; i < arr.size(); i++) {
            int tot = prev;
            if (arr.get(i)==0)
                tot++;
            tot += arr.get(i);
            if (arr.size()>(i+1))
                tot += arr.get(i+1);
            if (max < tot)
                max = tot;
            prev = arr.get(i);
        }
        
        return max;
        
    }
}