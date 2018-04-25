package problem744;

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
       
        boolean visited[] = new boolean[26];
        for (int i = 0; i < letters.length; i++)
            visited[letters[i]-'a'] = true;
        
        target ++;
        while(true) {
             if (target == 'z' + 1)
                target = 'a';
            if (visited[target-'a'])
                return target;
            
            target ++;
           
                
        }
         
    }
}