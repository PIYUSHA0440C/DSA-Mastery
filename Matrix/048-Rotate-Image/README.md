# 48. Rotate Image (Medium)

## 📝 Problem Statement
You are given an `n x n` 2D matrix. Rotate the image by 90 degrees clockwise **in-place**. You cannot allocate another matrix to perform the rotation.

## 💡 Intuition & Approach
Rotating a matrix by 90 degrees clockwise is mathematically equivalent to performing two simpler transformations:
1. **Transpose the matrix:** Switch rows with columns (swap `matrix[i][j]` with `matrix[j][i]`).
2. **Reverse each row:** Flip the elements of each row horizontally.

### 🛠️ The Strategy:
1. **Transpose:** 
   - Iterate through the upper triangle of the matrix (where `j > i`).
   - Swap `matrix[i][j]` with `matrix[j][i]`.
2. **Horizontal Reflection (Reverse):**
   - Iterate through each row.
   - Use two pointers (or a loop up to `n/2`) to swap elements from the left and right sides.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻²) - We visit every element of the matrix twice (once for transpose, once for reverse). Since there are $n^2$ elements, this is optimal.
* **Space Complexity:** 𝙊(𝟭) - All operations are performed in-place on the existing matrix.

## 💻 Implementation (Java)
```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // Step 1: Transpose (Rows becomes Columns)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp; 
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
