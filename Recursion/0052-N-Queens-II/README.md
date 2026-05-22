# 52. N-Queens II (Hard)

## 📝 Problem Statement
The $n$-queens puzzle is the problem of placing $n$ queens on an $n \times n$ chessboard such that no two queens attack each other. Given an integer $n$, return the number of distinct valid configurations.

## 💡 Intuition & Approach
This is a textbook constraint satisfaction problem solved optimally using **Backtracking**. Since each row must contain exactly one queen, we can frame our search row by row, eliminating the need to ever check horizontal collisions.

### 🛠️ The Strategy:
1. **Row-by-Row Placement:** Start at row `0` and attempt to place a queen in each column `col` from `0` to `n - 1`.
2. **Safety Validation (`isSafe`):** Before committing a queen to `board[row][col]`, scan upwards to ensure no threats exist:
   - **Vertically Up:** Check column `col` across previous rows.
   - **Diagonally Left:** Move up and left simultaneously (`row - i`, `col - i`).
   - **Diagonally Right:** Move up and right simultaneously (`row - i`, `col + i`).
3. **State Reversal (Backtrack):** If the position is safe, mark it `true`, and recursively transition to `row + 1`. Once that path is thoroughly searched, reset `board[row][col] = false` to evaluate alternative column branches.
4. **Base Case Validation:** If our recursion reaches `row == n`, a complete, valid configuration has been achieved. Return `1` to accumulate into the total solution count.

## 📊 Complexity Analysis
* **Time Complexity:** $O(N!)$ - While the upper bound of a raw grid search is higher, checking constraints prunes sub-trees aggressively. There are $N$ choices for the first row, at most $N-2$ for the second, and so on.
* **Space Complexity:** $O(N^2)$ - Due to the allocation of the $N \times N$ boolean tracking board, alongside an $O(N)$ recursive call stack depth.

## 💻 Implementation (Java)
```java
class Solution {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return queens(board, 0, n);
    }

    private int queens(boolean[][] board, int row, int n) {
        // Base case: All rows filled successfully means one valid layout found
        if (row == n) return 1;

        int count = 0;
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = true;          // Make move
                count += queens(board, row + 1, n); // Recurse
                board[row][col] = false;         // Undo move (Backtrack)
            }
        }

        return count;
    }

    private boolean isSafe(boolean[][] board, int row, int col, int n) {
        // 1. Check straight vertical column upwards
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }

        // 2. Check upper-left diagonal
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) return false;
        }

        // 3. Check upper-right diagonal
        int maxRight = Math.min(row, n - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) return false;
        }

        return true;
    }
}
