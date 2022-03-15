class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && vis[i][j] == false) {
                    ans = Math.max(ans, area(grid,vis,i,j));
                }
            }
        }
        
        return ans;
    }
    
    public int area(int[][] grid, boolean[][] vis, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || vis[i][j] == true) return 0;
        vis[i][j] = true;
        return 1 + area(grid, vis, i + 1, j) + area(grid, vis, i, j + 1) + area(grid, vis, i - 1, j) + area(grid, vis, i, j - 1);
    }
}