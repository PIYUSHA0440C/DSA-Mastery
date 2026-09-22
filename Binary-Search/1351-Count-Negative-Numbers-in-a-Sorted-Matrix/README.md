# 1351. Count Negative Numbers in a Sorted Matrix (Easy)

## 📝 Problem Statement

Given an `m x n` matrix where each row and column is sorted in non-increasing order, return the total number of negative numbers in the matrix.

## 💡 Intuition & Approach

Since every row is sorted, all negative numbers in a row form a continuous section at the end. We can use binary search to find the first negative number in each row.

### 🛠️ The Strategy:

1. Process each row independently.
2. Use binary search to find the first index containing a negative number.
3. If the first negative is at index `idx`, then all elements from `idx` to the end of the row are negative.
4. Add `row_len - idx` to the total count.
5. If no negative number exists, `idx` remains equal to `row_len`, contributing `0`.
6. Repeat for every row.

## 📊 Complexity Analysis

- **Time Complexity:** O(m log n), where `m` is the number of rows and `n` is the number of columns.
- **Space Complexity:** O(1)

## 💻 Implementation (Java)

```java
class Solution {
    public int countNegatives(int[][] grid) {
        int len = grid.length;
        int row_len = grid[0].length;
        int count = 0;

        for(int i = 0; i < len; i++){
            int left = 0, right = row_len - 1, idx = row_len;

            while(left <= right) {
                int mid = left + (right - left) / 2;

                if(grid[i][mid] < 0) {
                    idx = mid;
                    right = mid - 1;

                } else {
                    left = mid + 1;
                }
            }

            count += (row_len - idx);
        }

        return count;
    }
}
```
