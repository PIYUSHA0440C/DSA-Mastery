# 240. Search a 2D Matrix II (Medium)

## 📝 Problem Statement
Write an efficient algorithm that searches for a `target` value in an `m x n` integer matrix. The matrix has the following properties:
- Integers in each row are sorted in ascending order from left to right.
- Integers in each column are sorted in ascending order from top to bottom.

## 💡 Intuition & Approach
The key to an efficient search in this specific matrix is selecting the right starting point. If we start at the top-right (or bottom-left) corner, every move we make reduces the search space linearly.

### 🛠️ The Strategy:
1. **Starting Point:** Begin at the top-right corner (`row = 0`, `col = n - 1`).
2. **Comparison Logic:**
   - If `matrix[row][col] == target`: Found it! Return `true`.
   - If `matrix[row][col] < target`: Since the row is sorted, every element to the left is even smaller. We must move **down** (`row++`) to find larger values.
   - If `matrix[row][col] > target`: Since the column is sorted, every element below is even larger. We must move **left** (`col--`) to find smaller values.
3. **Termination:** If the pointers go out of bounds, the target does not exist in the matrix.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗺 + 𝗻) - In the worst case, we traverse from the top-right to the bottom-left, taking at most $m + n$ steps.
* **Space Complexity:** 𝙊(𝟭) - No extra data structures are used.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Start at top-right corner
        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                // Current value too small, move to next row (larger values)
                row++;
            } else {
                // Current value too large, move to previous column (smaller values)
                col--;
            }
        }

        return false;
    }
}
