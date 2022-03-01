class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    bfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void bfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] == true || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;
        bfs(grid, visited, i + 1, j);
        bfs(grid, visited, i, j + 1);
        bfs(grid, visited, i - 1, j);
        bfs(grid, visited, i, j - 1);
    }
    
    
}