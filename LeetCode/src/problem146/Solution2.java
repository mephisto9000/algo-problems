package problem146;

class LRUCache {
    
    class Node {
      public Node prev;
      public Node next;
      int key;
      int val;
      
      public Node(int key, int val) {
          this.key = key;
          this.val = val;
      }
      
  }
  
  int size;
  
  Node head;
  Node tail;
  Map<Integer, Node> map;

  public LRUCache(int capacity) {
      size = capacity;
      head = null;
      tail = null;
      
      map = new HashMap();
  }
  
  public int get(int key) {
      
      if (map.containsKey(key)) {
          Node x = remove(map.get(key));
          x.next = null;
          
          //Node x = new Node(key, old.val);
          if (tail != null) {
              tail.next = x;
              x.prev = tail;
          }
          tail  =x;
          if (head == null)
              head = x;
          return x.val;
      }
      else
          return -1;
      
  }
  
  Node remove(Node node) {
      
      if (node == null)
          return null;
      
      if (node.prev != null)
          node.prev.next = node.next;
      else
          head = head.next;
      
      if (node.next != null)
          node.next.prev = node.prev;
      else
          tail = tail.prev;
      
      return node;
  }
  
  public void put(int key, int value) {
      
      if (!map.containsKey(key)) {
          
      
      if (map.size() == size) {
          map.remove(head.key);
          remove(head);
      }
      }
         else        
          remove(map.get(key));
      Node x = new Node(key, value);
      map.put(key, x);
      
      if (tail != null) {
          tail.next = x;
          x.prev = tail;
      }
      tail = x;
      if (head == null)
          head = x;
  }
}

/**
* Your LRUCache object will be instantiated and called as such:
* LRUCache obj = new LRUCache(capacity);
* int param_1 = obj.get(key);
* obj.put(key,value);
*/