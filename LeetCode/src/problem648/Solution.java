package problem648;

class Solution {
    
    class Node
    {
        Node letters[];
        final int ALPHABET_NUM = 26;
        Character c;
        public boolean isTerminal = false;
        
        public Node()
        {
            letters = new Node[ALPHABET_NUM];
            for (int i = 0; i < ALPHABET_NUM; i++)
            {
                letters[i] = null; //overkill
            }
        }
        
        
    }
    
   
    public void insert(String word)
    {
        Node tmp = root;
        int n = word.length();
        for (int i = 0; i < n; i++)
        {
            int c = word.charAt(i) - 'a';
            
            if (tmp.letters[c] == null)
            {
                tmp.letters[c] = new Node();                
            }
            
            tmp = tmp.letters[c];
        }
        
        tmp.isTerminal = true;
    }
    
    public String search(String word)
    {
        Node tmp = root;
        
        int n = word.length();
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++)
        {
            if (tmp.isTerminal)
                break;
            
            int c = word.charAt(i) - 'a';
            
            if (tmp.letters[c]==null)
                break;
            
            sb.append(word.charAt(i));
            tmp = tmp.letters[c];
            
        }
        
        if (!tmp.isTerminal)
            return null;
        
        if (sb.length() == 0)
            return null;
        
        return sb.toString();
    }
    
    Node root;
    
    public String replaceWords(List<String> dict, String sentence) {
        
        
        String words[] = sentence.split(" ");
        
        root = new Node();
        
        Iterator<String> dit = dict.iterator();
        while(dit.hasNext())
        {
            String s = dit.next();
            insert(s);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < words.length; i++)
        {
            String r = search(words[i]);
            if (r!=null)
                sb.append(r);
            else
                sb.append(words[i]);
                //words[i] = r;
            sb.append(" ");    
        }
        
        return sb.toString().trim();
            
        
    }
}