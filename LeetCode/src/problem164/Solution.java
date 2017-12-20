package problem164;

class Solution {
    
    class Hole
    {
        List<Integer> numList;
        public int max = Integer.MIN_VALUE;;
        public int min = Integer.MAX_VALUE;
        
        public Hole()
        {
            numList = new LinkedList();
        }
        
        public void addNum(int v)
        {
            numList.add(v);
            if (v < min)
                min = v;
            
            if (v > max)
                max = v;
        }
        
    }
    
    Hole holes[];
    int n;
    
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        n = nums.length;
        holes = new Hole[n];
        for (int i = 0; i < n; i++)
            holes[i] = new Hole();
        
        int gmax = Integer.MIN_VALUE;
        int gmin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
        {
            if (nums[i]> gmax)
                gmax = nums[i];
            
            if (nums[i] < gmin )
                gmin = nums[i];                
        }
        
        int round = (gmax - gmin)*2/n;
        if (round == 0)
            round ++;
        
        for (int i = 0; i < n; i++)
        {
            int idx = (nums[i] - gmin) /round;            
            holes[idx].addNum(nums[i]);
        }
        
        int offset = 1;
        int i = 0;
                
        int ans = 0;
        while(i < n && i + offset < n)
        {
            if (holes[i].max == Integer.MIN_VALUE && holes[i].min == Integer.MAX_VALUE)
            {
                i++;                
                offset = 1;
                continue;
            }
            
            if (holes[i+offset].max == Integer.MIN_VALUE && holes[i+offset].min == Integer.MAX_VALUE)
            {
                offset ++;
                continue;
            }
            
            int x = holes[i+offset].min - holes[i].max;
            if (x > ans)
                ans = x;
            
            i++;
        }
        
        return ans;
    }
}