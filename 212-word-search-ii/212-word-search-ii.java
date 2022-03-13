class Solution {
    
    class Node {
        Node[] children;
        String str;
        
        Node() {
            children = new Node[26];
            str = null;
        }
    }
    
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new Node();
            }
            cur = cur.children[ch - 'a'];
        }
        cur.str = word;
    }
    
    public Node root;
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        root = new Node();
        
        for (String word : words) {
            insert(word);
        }
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, root, ans, visited);
            }
        }
        return ans;
    }
    
    public void dfs(char[][] board, int i, int j, Node root, List<String> ans, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] == true) return;
        
        if (root.children[board[i][j] - 'a'] == null) return;
        Node child = root.children[board[i][j] - 'a'];
        
        if (child.str != null) {
            ans.add(child.str);
            child.str = null;
        }
        
        visited[i][j] = true;
        dfs(board, i + 1, j, child, ans, visited);
        dfs(board, i - 1, j, child, ans, visited);
        dfs(board, i, j + 1, child, ans, visited);
        dfs(board, i, j - 1, child, ans, visited);
        visited[i][j] = false;
        
    }
}