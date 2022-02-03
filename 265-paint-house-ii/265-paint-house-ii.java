class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        
        int[][] dp = new int[n][k];
        
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = costs[0][i];
        }
        
        for (int i = 1; i < n; i++) {
            for (int c = 0; c < k; c++) {
                int min = Integer.MAX_VALUE;
                for (int pc = 0; pc < k; pc++) {
                    if (c == pc) continue;
                    min = Math.min(dp[i-1][pc], min);
                }
                dp[i][c] = min + costs[i][c];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int val : dp[dp.length - 1]) {
            min = Math.min(val, min);
        }
        
        return min;
    }
}