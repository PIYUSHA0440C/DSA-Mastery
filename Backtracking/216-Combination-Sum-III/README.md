# 216. Combination Sum III (Medium)

## 📝 Problem Statement
Find all valid combinations of `k` numbers that sum up to `n`, using numbers from 1 to 9 only. Each number can be used at most once, and the result must contain only unique combinations.

## 💡 Intuition & Approach
Since the range of numbers is very small (1-9) and the number of elements is fixed at `k`, we can efficiently use **Backtracking** to explore the search space.

### 🛠️ The Strategy:
1. **Bounded Search:** The loop only runs from `start` to 9.
2. **State Tracking:**
   - `start`: Ensures we only pick numbers in increasing order to avoid duplicate combinations like `[1, 2]` and `[2, 1]`.
   - `k`: Acts as a depth limiter for our recursion.
   - `target`: Tracks the remaining sum needed.
3. **Pruning/Base Case:**
   - If `curr.size() == k`, we stop. If the `target` is exactly 0, we've found a valid set and save it.
4. **Standard Backtrack:**
   - **Add** the current number `i`.
   - **Recurse** with `i + 1` and `target - i`.
   - **Remove** the last number (backtrack) to try the next digit.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗖(𝟵, 𝗸)) - We are choosing $k$ numbers out of 9. In the worst case, this is $P(9, k)$, but since the numbers are sorted, it's significantly less.
* **Space Complexity:** 𝙊(𝗸) - The recursion depth is limited by $k$, which is at most 9.

## 💻 Implementation (Java)
```java
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(1, k, n, list, curr);
        return list;
    }

    void helper(int start, int k, int target, List<List<Integer>> list, List<Integer> curr) {
        // Base Case: We have picked k numbers
        if (curr.size() == k) {
            if (target == 0) {
                list.add(new ArrayList<>(curr));
            }
            return;
        }

        // Try numbers from start up to 9
        for (int i = start; i <= 9; i++) {
            // Optimization: if i > target, no point in continuing the loop
            if (i > target) break; 

            curr.add(i);
            helper(i + 1, k, target - i, list, curr);
            curr.remove(curr.size() - 1); // Backtrack
        }
    }
}
