# 3740. Minimum Distance Between Three Equal Elements I (Easy)

## 📝 Problem Statement
Given an array `nums`, find a "good tuple" $(i, j, k)$ such that $nums[i] == nums[j] == nums[k]$. The distance of this tuple is defined as $|i - j| + |j - k| + |k - i|$. Return the minimum possible distance, or -1 if no such tuple exists.

## 💡 Intuition & Approach
The mathematical formula $|i - j| + |j - k| + |k - i|$ can be simplified. If we assume $i < j < k$:
- $|i - j| = j - i$
- $|j - k| = k - j$
- $|k - i| = k - i$
Total distance = $(j - i) + (k - j) + (k - i) = 2 \times (k - i)$.

### 🛠️ The Strategy:
1. **Brute Force (for small N):** Since the constraints are very small ($N \le 100$), an $O(N^3)$ approach is feasible.
2. **Triple Loop:** - Iterate with $i$ from $0$ to $n-1$.
   - Iterate with $j$ from $i+1$ to $n-1$, checking if $nums[i] == nums[j]$.
   - Iterate with $k$ from $j+1$ to $n-1$, checking if $nums[j] == nums[k]$.
3. **Minimize Distance:** When a triplet is found, calculate $2 \times (k - i)$ and update the minimum answer.
4. **Base Case:** If the minimum answer remains at `MAX_VALUE`, return -1.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻³) - Triple nested loops over the input array.
* **Space Complexity:** 𝙊(𝟭) - No extra data structures used beyond a few variables.

## 💻 Implementation (Java)
```java
class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if (n <= 2) return -1;
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    for (int k = j + 1; k < n; k++) {
                        if (nums[j] == nums[k]) {
                            // Simplified formula: 2 * (max_index - min_index)
                            ans = Math.min(ans, 2 * (k - i));
                        }
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
