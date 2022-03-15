class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(grid, i, j, vis);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j, boolean[][] vis) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || vis[i][j] == true || grid[i][j] == '0') return;
        vis[i][j] = true;
        dfs(grid, i + 1, j, vis);
        dfs(grid, i - 1, j, vis);
        dfs(grid, i, j + 1, vis);
        dfs(grid, i, j - 1, vis);
    }
    
}