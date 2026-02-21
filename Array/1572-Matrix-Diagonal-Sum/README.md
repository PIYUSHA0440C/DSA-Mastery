# 1572. Matrix Diagonal Sum (Easy)

## 📝 Problem Statement
Given a square matrix `mat`, return the sum of the matrix diagonals. Include all elements on the primary diagonal and the secondary diagonal, ensuring that elements belonging to both (the center element in odd-sized matrices) are only counted once.

## 💡 Intuition & Approach
A square matrix of size $n \times n$ has two main diagonals:
1. **Primary Diagonal:** Elements where row index equals column index `(i, i)`.
2. **Secondary Diagonal:** Elements where row index plus column index equals $n - 1$, or `(i, n - 1 - i)`.

### 🛠️ The Strategy:
1. **Single Pass:** Loop through the rows from `0` to `n-1`.
2. **Summing:** In each iteration `i`, add `mat[i][i]` (primary) and `mat[i][n-1-i]` (secondary) to the total.
3. **The Intersection:** If the matrix dimension is odd (e.g., $3\times3$, $5\times5$), the diagonals intersect at exactly one middle element. Since we added both diagonals in the loop, this middle element was added twice.
4. **Correction:** Subtract the middle element `mat[n/2][n/2]` once if $n$ is odd.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We only traverse the length of the matrix once.
* **Space Complexity:** 𝙊(𝟭) - No extra space is used except for the sum variable.

## 💻 Implementation (Java)
```java
class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            // Add primary diagonal element
            sum += mat[i][i];
            // Add secondary diagonal element
            sum += mat[i][n - 1 - i];
        }

        // If n is odd, subtract the middle element that was added twice
        if (n % 2 != 0) {
            sum -= mat[n / 2][n / 2];
        }

        return sum;
    }
}
