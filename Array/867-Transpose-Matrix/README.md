# 867. Transpose Matrix (Easy)

## 📝 Problem Statement
Given a 2D integer array `matrix`, return the transpose of the matrix. Transposing a matrix means flipping it over its main diagonal, switching the row and column indices.

## 💡 Intuition & Approach
The core of transposition is the transformation: `matrix[i][j]` becomes `transposed[j][i]`.

### 🛠️ The Strategy:
1. **Dimension Swap:** Identify the original row and column counts. The new matrix must have dimensions `original_col x original_row`.
2. **Nested Traversal:** Loop through the original matrix. 
3. **Index Mapping:** For every element at `(r, c)` in the original, place it at `(c, r)` in the new matrix. 
   - Note: Since we are creating a new matrix, this works perfectly for both square and rectangular matrices.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗺 × 𝗻) - We must visit every single element in the original matrix exactly once.
* **Space Complexity:** 𝙊(𝗺 × 𝗻) - We create a new matrix of the same total size to store the result.

## 💻 Implementation (Java)
```java
class Solution {
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        // Create new matrix with swapped dimensions
        int[][] trans = new int[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                // Map original rows to new columns and vice versa
                trans[i][j] = matrix[j][i];
            }
        }

        return trans;
    }
}
