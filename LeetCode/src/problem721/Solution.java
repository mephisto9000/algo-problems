package problem721;

class Solution {
    
    
    Map<String, List<Set<String>>> catalog;
    
    
    class Catalog {
       
        String name;
        Set<String> emails;
        public Catalog(String name) {
            
            this.name = name;
            emails = new HashSet();
        }
        
        public void addEmail(String email) {
            emails.add(email);
        }
            
    }
    
   
    
    Map<String, Catalog> emailToCatalog;
    List<Catalog> catalogs;
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        catalog = new HashMap();
        catalogs = new LinkedList();
        
        emailToCatalog = new HashMap();
        
        for (List<String> account:accounts) {
            String name = account.get(0);
            
            List<Catalog> cats = new LinkedList();
            for (int i = 1; i < account.size(); i++) {
               String email = account.get(i);
                
               if (emailToCatalog.containsKey(email) && !cats.contains(emailToCatalog.get(email))) {
                    cats.add(emailToCatalog.get(email));
                   
               } 
               
            }
            Catalog cat = null;
            if (cats.size() == 0) {
                cat = new Catalog(name);
                catalogs.add(cat);
            } else {
                
                for (Catalog tmp: cats) {
                    if (cat == null)
                        cat = tmp;
                    else
                        cat = mergeCats(cat, tmp);
                }
            }
            
            mergeToCatalog(cat, account);
                
        }
        
        List<List<String>> ans = new LinkedList();
        for (Catalog cat : catalogs) {
            List<String> catList = new LinkedList();
            
            catList.add(cat.name);
            
            List<String> emailList = new LinkedList();
            Iterator<String> iter = cat.emails.iterator();
            while (iter.hasNext()) {
                emailList.add(iter.next());
            }
            Collections.sort(emailList);
            catList.addAll(emailList);
            ans.add(catList);
            
        } 
        return ans;
            
        
    }
    
    void mergeToCatalog(Catalog cat, List<String> account) {
        for (int i = 1; i < account.size(); i++) {
            String email = account.get(i);
            emailToCatalog.put(email, cat);
            cat.addEmail(email);
        }
    }
    
    Catalog mergeCats(Catalog c2, Catalog c1) {
         Iterator<String> iter = c2.emails.iterator();
            while (iter.hasNext()) {
                String email = iter.next();
                c1.addEmail(email);
                emailToCatalog.put(email, c1);
            }
        
        catalogs.remove(c2);
        
        return c1;
    }
}