# 79. Word Search (Medium)

## 📝 Problem Statement
Given an `m x n` grid of characters and a string `word`, return `true` if the word exists in the grid. The word can be constructed from letters of sequentially adjacent cells (horizontally or vertically). The same letter cell may not be used more than once in a single path.

## 💡 Intuition & Approach
This problem is solved using **DFS (Depth First Search)** combined with **Backtracking**. Since we need to check all possible paths starting from every cell, we explore the neighbors recursively.

### 🛠️ The Strategy:
1. **Grid Traversal:** Iterate through every cell in the board. If the cell matches the first letter of the word, start the DFS.
2. **Recursive DFS:**
   - **Base Case:** If `idx` equals the word length, we've found the entire word.
   - **Boundary & Match Checks:** If the current coordinates are out of bounds or the character doesn't match `word.charAt(idx)`, return `false`.
3. **In-place Marking:** - Temporarily change the current cell to `#` to mark it as visited. This prevents the algorithm from using the same cell twice in the same path.
4. **Directional Exploration:** Recursively check all four directions (Up, Down, Left, Right).
5. **Backtrack:** Restore the original character to the cell before returning so that other potential paths can use it.

## 📊 Complexity Analysis
* **Time Complexity:** $O(N \cdot 3^L)$ - Where $N$ is the number of cells on the board and $L$ is the length of the word. At each step, we have 3 directions to explore (excluding the one we just came from).
* **Space Complexity:** $O(L)$ - The maximum depth of the recursion stack is the length of the word.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int idx) {
        if(idx == word.length()) return true;

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#'; // Mark as visited

        boolean found = dfs(board, word, i + 1, j, idx + 1) ||
                        dfs(board, word, i - 1, j, idx + 1) ||
                        dfs(board, word, i, j + 1, idx + 1) ||
                        dfs(board, word, i, j - 1, idx + 1);
        
        board[i][j] = temp; // Backtrack: restore original value

        return found;
    }
}
