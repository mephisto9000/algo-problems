package problem364;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depth = height(nestedList, 0);
        
        //System.out.println("depth == "+depth);
        return rec(nestedList, depth);
    }
    
    int rec(List<NestedInteger> list, int depth) {
        int ans = 0;
        for (NestedInteger n : list) {
            if (n.isInteger()) {
                ans += depth * n.getInteger();
            }
            else {
                ans += rec(n.getList(), depth - 1);
            }
                
        }
        
        return ans;
    }
    
    int height(List<NestedInteger> nestedList, int inDepth){
        int depth = inDepth + 1;
        for (NestedInteger n : nestedList) {
            int tmpDepth = 0;
            if (n.isInteger())
                tmpDepth = inDepth+1;
            else {
                tmpDepth = height(n.getList(), inDepth+1);
                
            }
            depth = Math.max(depth, tmpDepth);
        }
        
        return depth;
    }
}