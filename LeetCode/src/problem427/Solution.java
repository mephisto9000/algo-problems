package problem427;

/*
//Definition for a QuadTree node.
class Node {
 public boolean val;
 public boolean isLeaf;
 public Node topLeft;
 public Node topRight;
 public Node bottomLeft;
 public Node bottomRight;

 public Node() {}

 public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
     val = _val;
     isLeaf = _isLeaf;
     topLeft = _topLeft;
     topRight = _topRight;
     bottomLeft = _bottomLeft;
     bottomRight = _bottomRight;
 }
};
*/
class Solution {
 int[][] grid;
 
 public Node construct(int[][] grid) {
     this.grid = grid;
     int n =  grid.length;
     return build(0,0, n);
 }

 Node build(int i1, int j1, int n) {
     Node ans = null;
     if (n==1)
         ans = new Node(grid[i1][j1]!=0, true, null, null, null, null);
     else {
         int m =  n>>1;
         Node n1,n2,n3,n4 = null;
         n1 = build(i1, j1,  m); //top left
         n2 = build(i1+m, j1, m); // bottom left
         n3 = build(i1, j1+m,  m); // top right
         n4 = build(i1+m, j1+m,  m); // bottom right

         if (n1.isLeaf && n2.isLeaf && n3.isLeaf && n4.isLeaf && n1.val == n2.val && n2.val == n3.val && n3.val == n4.val)
             ans = new Node(n1.val, true, null, null, null, null);
         else
             ans = new Node(false, false, n1, n3, n2, n4);
     }
     return ans;
 }
}