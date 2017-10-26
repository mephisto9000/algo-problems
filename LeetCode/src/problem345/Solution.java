package problem345;

class Solution {
    public String reverseVowels(String s) {        
       
        char[] varr = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};           
	
        Set<Character> vset = new HashSet<Character>(); //Arrays.asList(varr));
        for (int i = 0; i < varr.length; i++)
            vset.add(varr[i]);
         
        List<Integer> vpos = new LinkedList();
        
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (vset.contains(c))
            {
                vpos.add(i);
            }
        }
        
        StringBuffer sb = new StringBuffer();
        Object vposarr[] = vpos.toArray();
        int z = vposarr.length - 1;
        
        for (int i = 0; i < s.length(); i++)
        {
             char c = s.charAt(i);
            if (!vset.contains(c))
            {
                sb.append(c);
            }
            else
            {
                int idx = (Integer) vposarr[z];
                sb.append(s.charAt(idx));
                z--;
            }
        }
        
        return sb.toString();
        
        
    }
}