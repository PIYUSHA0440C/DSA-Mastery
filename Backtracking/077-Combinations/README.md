# 77. Combinations (Medium)

## 📝 Problem Statement
Given two integers `n` and `k`, return all possible combinations of `k` numbers chosen from the range `[1, n]`.

## 💡 Intuition & Approach
This is a classic backtracking problem where we need to explore all subsets of a specific size `k`.

### 🛠️ The Strategy:
1. **Backtracking Function:** Use a helper function that takes a starting number `s`.
2. **Looping with a Range:** Iterate from `s` to `n`. For each number:
   - **Add** it to the current combination.
   - **Recurse** starting from `i + 1` to ensure we don't reuse numbers or create unordered duplicates.
   - **Backtrack** by removing the last number before the next iteration.
3. **Base Case:** When the size of the current list equals `k`, we've found a valid combination. Create a deep copy and add it to the result list.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗸 × 𝗖(𝗻, 𝗸)) - Where $C(n, k)$ is the number of combinations. We spend $O(k)$ to copy each valid combination into the result.
* **Space Complexity:** 𝙊(𝗸) - The recursion stack depth and the space used to store the current combination.

## 💻 Implementation (Java)
```java
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(1, n, k, result, new ArrayList<>());
        return result;
    }

    private void backtracking(int start, int n, int k, List<List<Integer>> list, List<Integer> current) {
        // Base case: combination is complete
        if (current.size() == k) {
            list.add(new ArrayList<>(current));
            return;
        }

        // Standard backtracking loop
        for (int i = start; i <= n; i++) {
            current.add(i); // Choose
            backtracking(i + 1, n, k, list, current); // Explore
            current.remove(current.size() - 1); // Un-choose (Backtrack)
        }
    }
}
