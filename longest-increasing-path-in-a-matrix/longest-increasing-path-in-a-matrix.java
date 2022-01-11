class Solution {
    
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    
    public int longestIncreasingPath(int[][] matrix) {    
        int ans = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] mem = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix,m,n,i,j,mem));
            }
        }
        return ans;
    }
    
    public int dfs(int[][] matrix, int m, int n, int i, int j, int[][] mem) {
        if (mem[i][j] > 0) return mem[i][j];
        int res = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] > matrix[i][j]) {
                res = Math.max(res, dfs(matrix,m,n,x,y, mem));
            }
        }
        mem[i][j] = res + 1;
        return res + 1;
    }
    
    
}