package problem271;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        
        Iterator<String> it = strs.iterator();
        
        StringBuffer sb = new StringBuffer();
        
          
        while(it.hasNext()) {
            
            String s = it.next();
           
            
            sb.append(s);
            //if (it.hasNext()) {
                sb.append('\uffff');
            // }
        }
        
        return sb.toString();
        
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        
        List<String> ans = new LinkedList();
        
        if (s.length() == 0)
            return ans;
        
        
        StringBuffer sb = new StringBuffer();
        
        int first = -1; //string.indexOf("is");
        int second = -1;
        
        do {
            first = second+1;
            second = s.indexOf('\uffff', second + 1);
            String s1 = s.substring(first, second);
            ans.add(s1);
        } 
        while( second < s.length() - 1);
        return ans;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));