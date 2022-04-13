class LRUCache {
    
    class Node {
        Node prev;
        Node next;
        int key;
        int value;
        
        Node() {
            
        }
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }
    
    // DLL
    Node head = null;
    Node tail = null;
    int size = 0;
    
    // HashMap
    HashMap<Integer, Node> map;
    int cap = 0;
    
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            addLast(n);
            return n.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.value = value;
            remove(n);
            addLast(n);
        
        } else {
            Node n = new Node(key, value);
            addLast(n);
            map.put(key, n);
            if (size > cap) {
                int rk = head.key;
                removeFirst();
                map.remove(rk);
            }
        }
    }
    
    private void removeFirst() {
        if (size == 0) {
            return;
        } else if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;    
        }
        
        size--;
    }
    
     private void removeLast() {
        if (size == 0) {
            return;
        } else if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;    
        }
        
        size--;
    }
    
    private void addLast(Node nn) {
        if (size == 0) {
            head = tail = nn;
        } else {
            tail.next = nn;
            nn.prev = tail;
            tail = nn;
        }
        size++;
    }
    
    private void remove(Node n) {
        if (size == 0) {
            return;
        } else if (n == head) {
            removeFirst();
        } else if (n == tail) {
            removeLast();
        }
        else {
            Node prev = n.prev;
            Node next = n.next;
            prev.next = next;
            next.prev = prev;
            n.next = null;
            n.prev = null;
            size--;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */