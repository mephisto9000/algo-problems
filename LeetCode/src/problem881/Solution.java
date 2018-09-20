package problem881;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int cnt = 0;
        int fast = people.length-1;
        for (int i = 0; i < people.length; i++) {
            
            if (people[i] == -1)
                continue;
            cnt ++;
            
            while(fast >= 0) {
                if (people[i] + people[fast] <= limit) {
                    people[fast] = -1;
                    fast--;
                    break;
                }
                else
                    fast--;
            }
        }
        return cnt;
        
    }
}