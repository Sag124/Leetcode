class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int[][] dirs = new int[][] {{1, 0},{0,1},{-1,0},{0, -1}};
        
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int new_row = cur[0] + dir[0];
                int new_col = cur[1] + dir[1];
                
                if (new_row >= 0 && new_col >= 0 && new_row < mat.length && new_col < mat[0].length && mat[new_row][new_col] == -1) {
                    queue.add(new int[]{new_row, new_col});
                    mat[new_row][new_col] = mat[cur[0]][cur[1]] + 1;
                }
            }
        }
        
        return mat;
        
    }
}