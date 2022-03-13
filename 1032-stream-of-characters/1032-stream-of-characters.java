class StreamChecker {
    
    class Node {
        Node[] children;
        boolean isEnd;
        Node() {
            children = new Node[26];
        }
    }

    public void insert(String word) {
        Node cur = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            if (cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new Node();
            }
            cur = cur.children[ch - 'a'];
        }
        cur.isEnd = true;
    }

    Node root;
    StringBuilder str;

    public StreamChecker(String[] words) {
        root = new Node();
        for (String word : words) {
            insert(word);
        }
        str = new StringBuilder();
    }
    
    public boolean query(char letter) {
        str.append(letter);
        Node cur = root;
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (cur.children[ch - 'a'] == null) {
                return false;
            }
            cur = cur.children[ch - 'a'];
            if (cur.isEnd) return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */