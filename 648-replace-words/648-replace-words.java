class Solution {
    
    class Node {
        Node[] children;
        boolean isEnd;
        Node() {
            children = new Node[26];
        }
    }
    
    private Node root;
    
    public void insert(String word) {
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
    
    public String prefixSearch(String word, Node root) {
        Node cur = root;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.children[ch - 'a'] == null) return null;
            sb.append(ch);
            cur = cur.children[ch - 'a'];
            if (cur.isEnd) {
                return sb.toString();
            }
        }
        return null;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Node();
        for (String str : dictionary) {
            insert(str);
        }
        
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String prefix = prefixSearch(words[i], root);
            
            if (prefix != null) {
                words[i] = prefix;
            }
        }
        return String.join(" ", words);
    }
}