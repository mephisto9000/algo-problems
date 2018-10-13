package problem787;

import java.util.LinkedList;
import java.util.Queue;

class Solution {    
    int flights[][];
    boolean visited[];
    int k;
    
    int max = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {               
    	this.flights = flights;
    	k = K;
    	visited = new boolean[n];    	
        rec(src, dst, 0, 0);          
        return max == Integer.MAX_VALUE?-1:max;
    }
    
    void rec(int cityIdx, int dst, int stops, int price) {
    	if (cityIdx == dst) {
    		if (price < max)
    			max = price;
    		return ;
    	}
    		
    	if (price > max || visited[cityIdx])
    		return;    	
    	visited[cityIdx] = true;    	
    	int sum = 0;    	
    	if (stops <= k) {
    		for (int i = 0; i < flights.length; i++) {
    			int from = flights[i][0];
    			int to = flights[i][1];
    			int priceFlight = flights[i][2];
    			if (from == cityIdx)
    				rec(to, dst, stops+1, price + priceFlight);
    		}
    	}    		
    	visited[cityIdx] = false;
    }
}