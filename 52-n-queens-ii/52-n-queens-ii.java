class Solution {
    List<List<String>> result;
    int[][] board;
    public int totalNQueens(int n) {
        result = new ArrayList<>();
        board = new int[n][n];
        backtrack(0);
        return result.size();
    }
    
    public void backtrack(int row) {
        
        if (row == board.length) {
            List<String> li = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 1) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
             }
            result.add(li);
        }
        
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                backtrack(row + 1);
                board[row][col] = 0;
            }
        }
    }
    
    public boolean isSafe(int[][] board, int row, int col) {
        //vertical
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        // anti diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        // diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        return true;
    }
}