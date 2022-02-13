class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    bfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public void bfs(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || visited[i][j] == true || grid[i][j] == '0')         {
            return;
        }
        visited[i][j] = true;
        bfs(grid, i - 1, j, visited);
        bfs(grid, i, j + 1, visited);
        bfs(grid, i, j - 1, visited);
        bfs(grid, i + 1, j, visited);
        
        
        
    }
}