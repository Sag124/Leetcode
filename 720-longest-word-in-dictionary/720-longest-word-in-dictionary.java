class Solution {
    
    class Node {
            Node[] children;
            boolean isEnd;
            
            Node() {
                children = new Node[26];
                isEnd = false;
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
    
    String ans;
    
    public String longestWord(String[] words) {
        root = new Node();   
        ans = "";
        
        for (String word : words) {
            insert(word);
        }
        
        dfs(root, "");  
        
        return ans;
        
    }
    
    public void dfs(Node cur, String psf) {
        if (psf.length() > ans.length()) {
            ans = psf;
        }
        
        for (int i = 0; i < 26; i++) {
            if (cur.children[i] != null) {
                Node child = cur.children[i];
                if (child.isEnd == true) {
                  dfs(child, psf + (char)(i + 'a'));  
                } 
            }
        }
        
    }
}