# 1582. Special Positions in a Binary Matrix (Easy)

## 📝 Problem Statement
Given an `m x n` binary matrix, return the number of special positions. A position `(i, j)` is **special** if `mat[i][j] == 1` and all other elements in row `i` and column `j` are 0.

## 💡 Intuition & Approach
To avoid redundant checks, we first perform a global scan to count how many `1`s exist in each row and each column.

### 🛠️ The Strategy:
1. **Pre-compute Counts:** Create two arrays, `row[]` and `col[]`.
   - Traverse the matrix once. If `mat[i][j] == 1`, increment `row[i]` and `col[j]`.
2. **Identify Special Positions:** Traverse the matrix a second time.
   - A position `(i, j)` is special ONLY if:
     - `mat[i][j] == 1`
     - `row[i] == 1` (This is the only '1' in its row)
     - `col[j] == 1` (This is the only '1' in its column)



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗺 × 𝗻) - We traverse the matrix twice.
* **Space Complexity:** 𝙊(𝗺 + 𝗻) - To store the counts for each row and column.

## 💻 Implementation (Java)
```java
class Solution {
    public int numSpecial(int[][] mat) {
        int rLen = mat.length, cLen = mat[0].length;
        int[] rowCount = new int[rLen];
        int[] colCount = new int[cLen];

        // First pass: Count 1s in each row and column
        for(int i = 0; i < rLen; i++){
            for(int j = 0; j < cLen; j++){
                if(mat[i][j] == 1){
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        // Second pass: Check if a 1 is the only 1 in its row and column
        int ans = 0;
        for(int i = 0; i < rLen; i++){
            for(int j = 0; j < cLen; j++){
                if(mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1){
                    ans++;
                }
            }
        }

        return ans;
    }
}
