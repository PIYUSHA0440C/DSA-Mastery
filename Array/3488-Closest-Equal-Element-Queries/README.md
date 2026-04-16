# 3488. Closest Equal Element Queries (Medium)

## 📝 Problem Statement
Given a circular array `nums` and a list of `queries`, for each query index `q`, find the minimum circular distance to any *other* index `j` such that `nums[j] == nums[q]`. If no other such index exists, return -1.

## 💡 Intuition & Approach
Since $N$ and $Q$ are up to $10^5$, we cannot perform a full search for every query. We need a way to jump directly to the same values.

### 🛠️ The Strategy:
1. **Grouping Indices:** Use a `HashMap<Integer, List<Integer>>` to store all indices for each unique number. The indices will naturally be in sorted order.
2. **Circular Neighbors:** For any value at `pos[i]`, the closest identical value in a circular array *must* be either:
   - Its left neighbor: `pos[i-1]` (or the last element if `i=0`).
   - Its right neighbor: `pos[i+1]` (or the first element if `i=last`).
3. **Distance Calculation:**
   - Linear distance: $d = |curr - neighbor|$
   - Circular distance: $\min(d, n - d)$
4. **Pre-computation:** To handle $Q$ queries efficiently, we pre-calculate the answer for every index in `nums` and store it in an `answer` array.
5. **Final Output:** Simply map the `queries` to our `answer` array.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻 + 𝗤) - $O(n)$ to build the map and compute neighbor distances, and $O(Q)$ to process queries.
* **Space Complexity:** 𝙊(𝗻) - To store the map of indices and the pre-computed answer array.

## 💻 Implementation (Java)
```java
class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> positions = new HashMap<>();

        // Group indices by value
        for (int i = 0; i < n; i++) {
            positions.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int[] preComputed = new int[n];
        Arrays.fill(preComputed, -1);

        for (List<Integer> pos : positions.values()) {
            int m = pos.size();
            if (m < 2) continue; // No "other" index exists

            for (int i = 0; i < m; i++) {
                int curr = pos.get(i);
                // Check neighbors in the sorted list (with circular wrap-around)
                int prev = pos.get((i - 1 + m) % m);
                int next = pos.get((i + 1) % m);

                int d1 = Math.abs(curr - prev);
                int distPrev = Math.min(d1, n - d1);

                int d2 = Math.abs(curr - next);
                int distNext = Math.min(d2, n - d2);

                preComputed[curr] = Math.min(distPrev, distNext);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int idx : queries) {
            result.add(preComputed[idx]);
        }
        return result;
    }
}
