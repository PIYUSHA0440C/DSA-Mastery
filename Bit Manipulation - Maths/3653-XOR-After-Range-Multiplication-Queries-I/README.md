# 3653. XOR After Range Multiplication Queries I (Medium)

## 📝 Problem Statement
You are given an array `nums` and a series of queries `[li, ri, ki, vi]`. For each query, multiply every $k^{th}$ element starting from index $l$ up to $r$ by $v$ (modulo $10^9 + 7$). After all queries, return the bitwise XOR sum of the final array.

## 💡 Intuition & Approach
The problem asks for a series of point-updates within a specific range and pattern. Since the constraints are relatively small ($N, Q \le 1000$), a direct simulation is the most straightforward and efficient path.

### 🛠️ The Strategy:
1. **Query Processing:** Iterate through each query in the `queries` array.
2. **Step-based Traversal:** Use a `while` loop starting at `idx = l`. In each step, perform the multiplication and then increment the index by `k` (`idx += k`).
3. **Modular Arithmetic:** To handle large numbers:
   - Convert the current `nums[idx]` to `long` to avoid overflow during multiplication with `v`.
   - Apply the modulo $10^9 + 7$ before casting back to `int`.
4. **Final XOR Sum:** After all queries are processed, iterate through the modified `nums` array and compute the cumulative XOR using the `^` operator.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗤 × (𝗡/𝗞)) - In the worst case ($k=1$), it is $O(Q \times N)$, which is $10^6$ operations.
* **Space Complexity:** 𝙊(𝟭) - We modify the input array in place and use a few extra variables.

## 💻 Implementation (Java)
```java
class Solution {
    final int mod = 1000000007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];

            int idx = l;
            // Apply the multiplication to every k-th element in range [l, r]
            while (idx <= r) {
                long temp = nums[idx];
                nums[idx] = (int)((temp * v) % mod);
                idx += k;
            }
        }

        // Calculate the XOR sum of the entire array
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }
}
