package problem406;

class Solution {
    
    class Person implements Comparable<Person>{
        int h;
        int q;
        public Person(int h, int q) {
            this.h = h;
            this.q = q;
        }
        
        @Override
        public int compareTo(Person p) {
            if (h < p.h) 
                return -1;
            if (h > p.h)
                return 1;
            return q - p.q;
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        
        List<Person> plist = new ArrayList();
        for (int i = 0; i < people.length; i++) {
            Person p = new Person(people[i][0], people[i][1]);
            plist.add(p);
        }
        
        Collections.sort(plist);
        
        int[][] ans = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < plist.size(); j++) {
                Person p = plist.get(j);
                int cnt = 0;
                for (int x = 0; x < i; x++) {
                    if (ans[x][0] >= p.h)
                        cnt++;
                }
                
                if (p.q == cnt) {
                    ans[i][0] = p.h;
                    ans[i][1] = p.q;
                    plist.remove(j);
                    break;
                }
            }
        }
        
        return ans;
    }
}