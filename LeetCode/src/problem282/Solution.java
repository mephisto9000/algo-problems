package problem282;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    int target;
    int n;
    Set<String> ans;
     
    long[] nums;
    String num;
    
    public List<String> addOperators(String num, int target) {
        ans = new HashSet();
        this.num = num;
        if (num == null || num.isEmpty())
            return new LinkedList();
        this.target = target;
        
        n = num.length();
        List<Integer> tmp = new ArrayList();
        nums = new long[n];
        for (int i = 0; i < num.length(); i++)
        {
            int v = num.charAt(i)-'0';
            
            nums[i] = v;
        }
        StringBuffer sb = new StringBuffer();

        if (String.valueOf(target).equals(num))
        	ans.add(num);
        		
        for (int i =n-1; i>=1; i--)
        {
            int v = Integer.parseInt(num.substring(0, i));
            
            sb.append(v);
            rec(i, 0, v, sb);
            sb.setLength(0);
        }
                                     
        return new LinkedList(ans);
    }
    
    void rec(int idx, long sum, long lastNum, StringBuffer sb)
    {
        if (idx >= n)
        {
             
            if (sum + lastNum == target)
            {
            	String check = sb.toString().replaceAll("[-+*]","");
            	if (check.equals(num))            	
            		ans.add(sb.toString());
            }
            return ;
        }
        
        String cache = sb.toString();
        
        sb.append("+"+nums[idx]);
        rec(idx + 1, sum + lastNum, nums[idx], sb);
        
        long t = nums[idx];
        if (t != 0)
        for (int i = 2; i<n; i++)
        {
        	if (idx + i -1 >=n)
        		break;
        	sb.append(nums[idx + i -1]);
        	t = t*10 + nums[idx+i-1];
        	rec(idx+i, sum+lastNum, t, sb);        	
        }
        
        sb.setLength(0); 
        sb.append(cache);
        
        sb.append("-"+nums[idx]);
        rec(idx+1, sum+lastNum, -nums[idx], sb);
        t = -nums[idx];
        if (t != 0)
        for (int i = 2; i<n; i++)
        {
        	if (idx + i -1 >=n)
        		break;
        	sb.append(nums[idx + i -1]);
        	t = t*10 - nums[idx+i-1];
        	rec(idx+i, sum+lastNum, t, sb);        	
        }

        sb.setLength(0); 
        sb.append(cache);
        
        sb.append("*"+nums[idx]);
        rec(idx+1, sum, lastNum  * nums[idx], sb);
        t = nums[idx];
        if (lastNum  * nums[idx] != 0)
        for (int i = 2; i<n; i++)
        {
        	if (idx + i -1 >=n)
        		break;
        	sb.append(nums[idx + i -1]);
        	t = t*10 + nums[idx+i-1];
        	rec(idx+i, sum,  lastNum  * t, sb);        	
        }
        
        sb.setLength(0); 
        sb.append(cache);
        
         
                                 
    }
     
}