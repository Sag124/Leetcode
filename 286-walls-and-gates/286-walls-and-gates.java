class Solution {
    public void wallsAndGates(int[][] rooms) {
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        int max = Integer.MAX_VALUE;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int r = cur[0] + dir[0];
                int c = cur[1] + dir[1];
                
                if (r >= 0 && c >= 0 && r < rooms.length && c < rooms[0].length && rooms[r][c] == max) {
                    queue.add(new int[]{r,c});
                    rooms[r][c] = 1 + rooms[cur[0]][cur[1]];
                }
            }
        }
        
        
        
        
    }
}