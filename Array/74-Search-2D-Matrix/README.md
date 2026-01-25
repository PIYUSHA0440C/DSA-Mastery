# Search a 2D Matrix (LeetCode 74)

## 📝 Problem Description
You are given an $m \times n$ integer matrix with the following properties:
1. Each row is sorted in non-decreasing order.
2. The first integer of each row is greater than the last integer of the previous row.

Given a `target`, return `true` if it exists in the matrix, otherwise `false`.



## 💡 Intuition
The matrix is structured such that it behaves like a single, long sorted array. However, we can also think of it as a collection of sorted ranges. By checking the end of each row, we can quickly determine which row might contain our target.

## 🚀 Approach: Optimized Row Search
1. **Identify the Row:** Iterate through the rows and compare the `target` with the last element of the current row (`matrix[i][n]`).
2. **Scan the Row:** If the target is less than or equal to the last element, the target *must* be in this row if it exists at all.
3. **Linear Search:** Iterate through that specific row. If found, return `true`.
4. **Early Exit:** If we finish the row and haven't found the target, return `false` (since the next row starts with even larger values).

## 📊 Complexity Analysis
- **Time Complexity:** **O(m + n)** - We check $m$ rows and then up to **n** columns.
- **Space Complexity:** **O(1)** - In-place search with no extra data structures.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length - 1; 

        for (int i = 0; i < m; i++) {
            if (matrix[i][n] >= target) {
                for (int j : matrix[i]) {
                    if (j == target) {
                        return true;
                    }
                }
                return false; 
            }
        }
        return false;
    }
}
