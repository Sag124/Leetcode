class MapSum {
    
    class Node {
        Node[] children;
        boolean isEnd;
        int score;
        
        Node() {
            children = new Node[26];
            isEnd = false;
            score = 0;
        }
    }
    
    private Node root;
    HashMap<String, Integer> map;

    public MapSum() {
        map = new HashMap<>();
        root = new Node();
    }
    
    public void insert(String key, int val) {
        int delta = (val - map.getOrDefault(key, 0));
        map.put(key, val);
        
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new Node();
            }
            cur = cur.children[ch - 'a'];
            cur.score += delta;
        }
        cur.isEnd = true;
        
    }
    
    public int sum(String prefix) {
        Node cur = root;
        int ans = 0;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (cur.children[ch - 'a'] == null) {
                return 0;
            } 
            cur = cur.children[ch - 'a'];
            
        }
        return cur.score;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */