# 73. Set Matrix Zeroes (Medium)

## 📝 Problem Statement
Given an `m x n` integer matrix, if an element is `0`, set its entire row and column to `0`. This must be done **in-place**.

## 💡 Intuition & Approach
The challenge is to mark rows and columns for zeroing without using extra memory that would be overwritten as we process the matrix.

### 🛠️ The Strategy (O(1) Space):
1. **Initial Markers:** Use the first row and first column as "trackers" to store whether that row or column should eventually be zeroed.
2. **First Row/Col Check:** Since we are using the first row and column as trackers, we must first check if they *themselves* contain any zeros and store that in two boolean variables (`firstRowZero`, `firstColZero`).
3. **Marking:** Iterate through the rest of the matrix (starting at `(1,1)`). If `matrix[i][j] == 0`, set `matrix[i][0] = 0` and `matrix[0][j] = 0`.
4. **Transforming:** Iterate through the matrix again and use the markers in the first row/column to set internal elements to zero.
5. **Final Step:** Zero out the first row and first column if the boolean variables from step 2 are true.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗺 × 𝗻) - We traverse the matrix a few times.
* **Space Complexity:** 𝙊(𝟭) - No extra data structures used; we use the matrix itself for storage.

## 💻 Implementation (Java)
```java
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // 1. Check if first row/col need to be zeroed
        for (int i = 0; i < m; i++) if (matrix[i][0] == 0) firstColZero = true;
        for (int j = 0; j < n; j++) if (matrix[0][j] == 0) firstRowZero = true;

        // 2. Use first row/col as markers for the rest
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 3. Set zeros based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 4. Zero out first row/col if needed
        if (firstColZero) for (int i = 0; i < m; i++) matrix[i][0] = 0;
        if (firstRowZero) for (int j = 0; j < n; j++) matrix[0][j] = 0;
    }
}
