# 2615. Sum of Distances (Medium)

## 📝 Problem Statement
For each index `i` in an array `nums`, calculate the sum of $|i - j|$ for all `j` such that `nums[i] == nums[j]`.

## 💡 Intuition & Approach
The challenge is to calculate the sum of absolute differences efficiently. If we have a sorted list of indices where a number appears: $[p_0, p_1, ..., p_m]$, the distance for $p_i$ is:
$$\sum_{j=0}^{m} |p_i - p_j|$$

We can split this into two parts:
1. **Left side ($j < i$):** $(p_i - p_0) + (p_i - p_1) ... = (p_i \times i) - \text{PrefixSum}(i-1)$
2. **Right side ($j > i$):** $(p_{i+1} - p_i) + (p_{i+2} - p_i) ... = \text{SuffixSum}(i+1) - (p_i \times (m - 1 - i))$

### 🛠️ The Strategy:
1. **Map Grouping:** Use a `HashMap<Integer, List<Integer>>` to group indices for each unique value.
2. **Prefix Sum Logic:** For each list of indices:
   - Calculate the total sum of all indices in the group.
   - Iterate through the indices while maintaining a running `leftSum`.
   - Use the mathematical formula derived above to calculate the total distance in $O(1)$ for each index.
3. **Complexity:** This turns an $O(n^2)$ problem into $O(n)$.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the array once to build the map and once more (total across all groups) to calculate distances.
* **Space Complexity:** 𝙊(𝗻) - To store the indices in the HashMap and the result array.

## 💻 Implementation (Java)
```java
class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        Map<Integer, List<Integer>> mp = new HashMap<>();

        // Group indices by value
        for (int i = 0; i < n; i++) {
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Process each group of identical elements
        for (List<Integer> pos : mp.values()) {
            long totalSum = 0;
            for (int x : pos) totalSum += x;

            long leftSum = 0;
            int m = pos.size();

            for (int i = 0; i < m; i++) {
                int currentIdx = pos.get(i);
                long rightSum = totalSum - leftSum - currentIdx;

                // Mathematical distance calculation
                long leftDist = (long) currentIdx * i - leftSum;
                long rightDist = rightSum - (long) currentIdx * (m - i - 1);

                ans[currentIdx] = leftDist + rightDist;
                leftSum += currentIdx;
            }
        }
        return ans;
    }
}
