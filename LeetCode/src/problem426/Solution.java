package problem426;

/*
//Definition for a Node.
class Node {
 public int val;
 public Node left;
 public Node right;

 public Node() {}

 public Node(int _val,Node _left,Node _right) {
     val = _val;
     left = _left;
     right = _right;
 }
};
*/
class Solution {
 Node left = null;
 Node right = null;
 
 public Node treeToDoublyList(Node root) {
         
   rec(root);   
   if (left != null) {
     left.left = right;
     right.right = left;
   }   
   return left;   
 }


void rec(Node root) {
  if (root == null) {
    return;
  }
  
  rec(root.left);
  
  if (right != null) {
    right.right = root;
    root.left = right;
    right = root;
  } else {
    right = root;
    left = root;
  }
  
  rec (root.right);
}
}