package problem953;

class Solution {
    
    Map<Character, Integer> ordMap = new HashMap();
    
    class WordComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
                for (int i = 0; i < a.length(); i++) {
                    if (i >= b.length())
                        break;
                    char ac = a.charAt(i);
                    char bc = b.charAt(i);
                    if (ac!=bc)
                        return ordMap.get(ac)-ordMap.get(bc);
                }
            
                return a.length()-b.length();
        }
    }
    public boolean isAlienSorted(String[] words, String order) {
        
        for (int i = 0; i < order.length(); i++)
            ordMap.put(order.charAt(i), i);
        
        PriorityQueue<String> pr = new PriorityQueue(new WordComparator());
        for (String s : words) {
            pr.add(s);
        }
        
        for (int i = 0; i < words.length; i++) 
            if (!words[i].equals(pr.poll()))
                return false;
        return true;    
    }
}