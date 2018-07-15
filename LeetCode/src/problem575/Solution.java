package problem575;

class Solution {
    public int distributeCandies(int[] candies) {
        
        Set<Integer> s = new HashSet();
        
        for (int i = 0; i < candies.length; i++) {
                s.add(candies[i]);
        }
                    
        int v = s.size();
        return v > candies.length/2 ? candies.length/2 : v;
            
        
    }
}