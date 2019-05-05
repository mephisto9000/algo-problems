package problem1029;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[]a, int[]b) {
                return (a[0]-a[1])-(b[0]-b[1]);
            }
            
        });
        
        int half = costs.length / 2;
        int sum = 0;
        for (int i = 0; i < costs.length; i++) {            
            if (i < half)
                sum += costs[i][0];
            else
                sum += costs[i][1];
        }
        
        return sum;
    }
    
}