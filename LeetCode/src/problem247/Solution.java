package problem247;

class Solution {
    
    public List<String> findStrobogrammatic(int n) {
        Queue<String> ans = new LinkedList();
        return new LinkedList(rec(0, n, ans));
    }
    
    Queue<String> rec(int curSize, int n, Queue<String> ans) {
        if (curSize >=n)
            return ans;
        curSize+=2;
        if (curSize == 2) {
            if (n % 2 == 0) {
                if (n != 2)
                ans.add("00");
                ans.add("11");
                ans.add("88");
                ans.add("96");  
                ans.add("69");
            } else {
                ans.add("0");
                ans.add("1");
                ans.add("8");
            }
        }
        else {
            
            int t = ans.size();
            for (int i = 0; i < t; i++) {
                String s = ans.poll();
                ans.add("1"+s+"1");
                if (curSize < n)
                    ans.add("0"+s+"0");
                ans.add("8"+s+"8");
                ans.add("9"+s+"6");
                ans.add("6"+s+"9");
            }
        }
                        
        return rec(curSize, n, ans);
    }
}