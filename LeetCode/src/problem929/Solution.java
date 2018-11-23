package problem929;

class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> uniques = new HashSet();
        
        for (String s: emails) { //}.length; i++) {
            StringBuffer sb = new StringBuffer();
            boolean ignore = false;
            
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c=='@') {
                    sb.append(s.substring(j));
                    break;
                }
                if (c =='+')
                    ignore = true;
                if (ignore || c =='.')
                    continue;
                sb.append(c);
            }            
            uniques.add(sb.toString());
        }
        
        for (String s : uniques)
            System.out.println(s);
        
        return uniques.size();
        
    }
}