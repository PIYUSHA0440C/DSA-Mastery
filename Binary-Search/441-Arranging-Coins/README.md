# 441. Arranging Coins (Easy)

## 📝 Problem Statement

Given `n` coins, arrange them into a staircase where the `ith` row contains exactly `i` coins. The last row may be incomplete. Return the number of complete rows that can be formed.

## 💡 Intuition & Approach

For `k` complete rows, the total number of coins required is:

`k * (k + 1) / 2`

We can use binary search to find the largest `k` whose required number of coins is less than or equal to `n`.

### 🛠️ The Strategy:

1. Set the binary search range from `1` to `n`.
2. Calculate the middle row count using binary search.
3. Calculate the number of coins required for `mid` complete rows.
4. If the required coins equal `n`, return `mid`.
5. If the required coins are less than `n`, search for a larger number of rows.
6. If the required coins are greater than `n`, search for fewer rows.
7. When the search ends, `end` represents the maximum number of complete rows possible.
8. Use `long` for calculations to prevent integer overflow.

## 📊 Complexity Analysis

* **Time Complexity:** O(log n)
* **Space Complexity:** O(1)

## 💻 Implementation (Java)

```java
class Solution {
    public int arrangeCoins(int n) {
        long start = 1, end = n;

        while(start <= end) {
            long mid = start + (end - start) / 2;

            long coins_needed = mid * (mid + 1) / 2;

            if (coins_needed == n) return (int) mid;
            else if (coins_needed < n) start = mid + 1;
            else end = mid - 1;
        }

        return (int) end;
    }
}
```
