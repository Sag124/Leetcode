class Solution {
    int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
    public int orangesRotting(int[][] grid) {
        // if (grid[0][0] == 0 && grid[0][1] != 1) return 0;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        // boolean[][] visited = new boolean[grid.length][grid[0].length];
        int step = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];  
                for (int[] dir : dirs) {
                    int row = dir[0] + x;
                    int col = dir[1] + y;
                    if (isValid(grid, row, col)) {
                        grid[row][col] = 0;     
                        fresh--;
                        queue.offer(new int[]{row,col});
                    }
                }
            }
            step++;
        }
        if (fresh == 0) {
            return step;
        }
        return -1;
    }
    
    private boolean isValid(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1;
    }
}