package problem134;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int sum = 0;
        int idx = -1;
                
        int minGas = 0;
        int minCityIdx = 0;
        
        for (int i = 0; i < gas.length; i++) {
            sum+= gas[i] - cost[i];
            
            if (sum <= minGas) {
                minCityIdx = i;
                minGas = sum;
            }
        }
        
        if (sum < 0)
            return -1;
        
        
        if (minCityIdx == gas.length-1)
            return 0;
        return minCityIdx+1;
        
    }
}