# 3741. Minimum Distance Between Three Equal Elements II (Medium)

## 📝 Problem Statement
Given an array `nums`, find the minimum distance of a "good tuple" $(i, j, k)$ where $nums[i] == nums[j] == nums[k]$. 
The distance formula is $|i - j| + |j - k| + |k - i|$. 
With $N$ up to $10^5$, an $O(n)$ or $O(n \log n)$ solution is required.

## 💡 Intuition & Approach
From the previous version, we know that for $i < j < k$, the distance simplifies to $2 \times (k - i)$. To minimize this, we need the "outer" elements of the triplet to be as close as possible.

### 🛠️ The Strategy:
1. **Index Mapping:** Use a `HashMap<Integer, List<Integer>>` to store the indices of every number. Since we traverse the array linearly, the indices in each list will already be sorted.
2. **Sliding Window of 3:** For each unique number that appears at least 3 times:
   - Iterate through its list of indices.
   - For every group of three consecutive indices $(idx[i], idx[i+1], idx[i+2])$, calculate the distance: $2 \times (idx[i+2] - idx[i])$.
3. **Global Minimum:** Track the smallest distance found across all numbers.
4. **Why consecutive?** If we pick indices that are further apart than "consecutive" in the list, $(k - i)$ will only increase, thus increasing the total distance.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the array once to build the map, and then iterate through the total number of indices exactly once more.
* **Space Complexity:** 𝙊(𝗻) - To store all indices in the HashMap.

## 💻 Implementation (Java)
```java
class Solution {
    public int minimumDistance(int[] nums) {
        // Map each number to the list of indices where it appears
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int result = Integer.MAX_VALUE;

        // Iterate through each number's indices
        for (List<Integer> list : map.values()) {
            if (list.size() < 3) continue;

            // Check only consecutive triplets in the sorted index list
            for (int i = 0; i <= list.size() - 3; i++) {
                int currentDist = 2 * (list.get(i + 2) - list.get(i));
                result = Math.min(result, currentDist);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
