# 2352. Equal Row and Column Pairs (Medium)

## 📝 Problem Statement

Given an `n x n` integer matrix, count the number of pairs `(ri, cj)` where row `ri` and column `cj` contain exactly the same elements in the same order.

## 💡 Intuition & Approach

Use a HashMap to store the frequency of each row, represented as a `List<Integer>`.

Java lists support content-based equality and hashing, so they can be used as HashMap keys to compare entire rows and columns.

- Traverse each row and convert it into a list.
- Store each row in the HashMap with its frequency.
- Traverse each column and convert it into a list in top-to-bottom order.
- Look up the column list in the HashMap and add its matching row frequency to the answer.

Using frequencies ensures that duplicate rows and columns are counted correctly.

## 🛠️ The Strategy:

1. Initialize a HashMap to store row lists and their frequencies.
2. Convert every row into a list and update its frequency.
3. Convert every column into a list.
4. Retrieve the frequency of each column from the HashMap.
5. Add the matching frequency to the total pair count.
6. Return the total number of equal row-column pairs.

## 📊 Complexity Analysis

Let `n` be the dimension of the square matrix.

- **Time Complexity:** O(n²) expected. Creating all row and column lists takes O(n²) total, and HashMap operations take expected O(n) per list for hashing and equality checks, across 2n lists.
- **Space Complexity:** O(n²), for storing n row lists, each containing n elements, in the HashMap.

## 💻 Implementation (Java)

```java
class Solution {
    public int equalPairs(int[][] grid) {
        int pairs = 0;

        int len = grid.length;
        Map<List<Integer>, Integer> rowCounts = new HashMap<>();

        for (int r = 0; r < len; r++) {
            List<Integer> row = new ArrayList<>();

            for (int c = 0; c < len; c++) row.add(grid[r][c]);

            rowCounts.put(row, rowCounts.getOrDefault(row, 0) + 1);
        }

        for (int c = 0; c < len; c++) {
            List<Integer> col = new ArrayList<>();

            for (int r = 0; r < len; r++) col.add(grid[r][c]);

            pairs += rowCounts.getOrDefault(col, 0);
        }

        return pairs;
    }
}
```
