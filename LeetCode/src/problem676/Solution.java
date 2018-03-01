package problem676;

class MagicDictionary {    
    Set<String> origSet;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        origSet = new HashSet();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        
        for (int i = 0; i < dict.length; i++)
        {                        
            String s = dict[i];            
            origSet.add(s);                         
        }
                        
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {

        for (int i = 0; i < word.length(); i++)
        {
             String s1 = word.substring(0, i);
             String s2 = word.substring(i+1, word.length());
            
             for (int j = 0; j < 26; j ++)                         
             {
                char c =  'a';
                c+= j;
                 String s3 = s1 +c+s2;
                         
                 if (origSet.contains(s3) && (!s3.equals(word)))
                	 return true;
             }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */