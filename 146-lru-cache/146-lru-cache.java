class LRUCache {
    
    static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node() {
            
        }
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }
    
    Node head = null;
    Node tail = null;
    HashMap<Integer, Node> map;
    int size = 0;
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
        }
        else if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }
    
    private void addLast(Node n) {
        if (size == 0) {
            head = tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        size++;
    }
    
    private void removeLast() {
        if (size == 0) {
            return;
        }
        else if (size == 1) {
            head = tail = null;
        } else {
            Node tp = tail.prev;
            tp.next = null;
            tail.prev = null;
            tail = tp;
        }
        size--;
    }
    
    private void remove(Node c) {
        if(size == 0) {
            return;
        }
        else if(c == head) {
            removeFirst();
        }
        else if(c == tail) {
            removeLast();
        }
        else {
            Node p = c.prev;
            Node n = c.next;

            p.next = n;
            n.prev = p;

            c.next = c.prev = null;

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