package problem76;

class Solution {
	  int i=0, j = 0, count = 0, cv;
	  char c;
	  Map<Character, Integer> tmap, smap;
	  Set<Character> used = new HashSet();
	  int scount,  tcount = 0;
	    public String minWindow(String s, String t) {      
	        int tlen = t.length(), slen = s.length();
	        tmap = new HashMap();
	        smap = new HashMap();
	        
	        for(int i = 0; i < tlen; i++) {
	          char c = t.charAt(i);
	          int v = tmap.getOrDefault(c, 0);
	          tmap.put(c, ++v);
	          used.add(c);
	        }
	      
	        String ans = "";
	        while(j < slen) {
	          
	          while(scount < tlen && j < slen) {          
	            help(s,j);
	            smap.put(c, ++cv);
	            j++;
	            getCnts();
	                        
	          }
	          
	          while(scount >= tcount) { 
	            if (ans.equals("") || ans.length() > (j-i))
	              ans = s.substring(i, j);
	            
	            help(s,i);
	            smap.put(c, --cv);

	            getCnts();
	            i++;
	          }	          
	        }	      
	      return ans;	        
	    }
	  
	  void help(String s, int where) {
	    c = s.charAt(where);
	    cv = smap.getOrDefault(c, 0);    
	  }
	  
	  void getCnts() {
	    scount = 0;
	    tcount = 0;
	    for (Character c : used) {
	      
	      int tx = tmap.getOrDefault(c,0);
	      int sx = smap.getOrDefault(c,0);
	      tcount += tx;
	      scount +=  (sx > tx? tx : sx) ;
	    }    
	  }
	}