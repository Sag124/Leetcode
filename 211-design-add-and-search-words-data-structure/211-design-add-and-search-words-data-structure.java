class WordDictionary {
    
    private class Node{
        Node[] children;
        boolean isEnd;
        
        Node() {
            children = new Node[26];
        }
        
        public boolean find(String word, int index) {
        
        if (index == word.length()) {
            return isEnd;
        }
        
        if (word.charAt(index) == '.') {
            for (Node child : children) {
                if (child != null && child.find(word, index+1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (children[word.charAt(index) - 'a'] == null) {
                return false;
            } else {
                return children[word.charAt(index) - 'a'].find(word, index+1);
            }
        }
    }
    }
    
    final private Node root;

    public WordDictionary() {
        root = new Node();      
    }
    
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new Node();
            }
            cur = cur.children[ch - 'a'];
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        return root.find(word, 0);
    }
    
    
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */