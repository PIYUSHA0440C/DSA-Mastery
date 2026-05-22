class Solution {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];

        return queens(board, 0, n);
    }

    private int queens(boolean[][] board, int row, int n){
        if(row == n) return 1;

        int count = 0;
        for(int col = 0; col < n; col++){
            if(isSafe(board, row, col, n)){
                board[row][col] = true;
                count += queens(board, row + 1, n);
                board[row][col] = false;
            }
        }

        return count;
    }

    private boolean isSafe(boolean[][] board, int row, int col, int n){
        for(int i = 0; i < row; i++){
            if(board[i][col]) return false;
        }

        int maxLeft = Math.min(row, col);
        for(int i = 1; i <= maxLeft; i++){
            if(board[row - i][col - i]) return false;
        }

        int maxRight = Math.min(row, n - col - 1);
        for(int i = 1; i <= maxRight; i++){
            if(board[row - i][col + i]) return false;
        }
        return true;
    }
}
