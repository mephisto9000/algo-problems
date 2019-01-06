package problem460;

class LFUCache {

    int time;
    int size;
    int curSize;
    Map<Integer, Node> map;
    PriorityQueue<Node> pq;
    
    class Node {
        int freq;
        int key;
        int val;
        int lastTime;
                        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            freq = 0;
            lastTime = time;
        }
    }
    
    class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            if (a.freq == b.freq)
                return a.lastTime - b.lastTime;
            return a.freq - b.freq;
        }
    }
    
    public LFUCache(int capacity) {
        time = 0;
        size = capacity;
        curSize = 0;
        map = new HashMap();
        pq = new PriorityQueue(new NodeComparator());
    }
    
    public int get(int key) {
        time++;
        if (!map.containsKey(key))
            return -1;
        Node x = map.get(key);
        pq.remove(x);
        x.lastTime = time;
        x.freq++;
        pq.add(x);   
        return x.val;
    }
    
    public void put(int key, int value) {
        time++;
        if (size <= 0)
            return;
        Node x = new Node(key, value);
        if (!map.containsKey(key)) {                        
            if (curSize < size)
                curSize++;
            else {
                Node ox = pq.poll();
                map.remove(ox.key);
            }
        } else {
            Node ox = map.remove(key);
            pq.remove(ox);
            x.freq = ox.freq+1;
        }        
        map.put(key,x);
        pq.add(x);        
    }         
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */