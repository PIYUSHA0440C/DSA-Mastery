# 78. Subsets (Medium)

## 📝 Problem Statement
Given an integer array `nums` of unique elements, return all possible subsets (the power set). The solution set must not contain duplicate subsets.

## 💡 Intuition & Approach
To generate a power set, we explore a decision tree where at each step, we decide whether to include a specific element in our current subset.

### 🛠️ The Strategy:
1. **Recursion Tree:** Every call to the `helper` function represents a valid subset. We add the current state of `temp` to our result list immediately upon entering the function.
2. **Looping for Combinations:** We use a `start` index to ensure we only look forward in the array. This prevents generating different permutations of the same subset (like `[1, 2]` and `[2, 1]`).
3. **Backtracking:**
   - **Choose:** Add `nums[i]` to the current subset.
   - **Explore:** Recurse with `i + 1`.
   - **Un-choose:** Remove the last element to reset the state for the next iteration in the loop.

]

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻 × 𝟮ⁿ) - There are $2^n$ subsets, and we spend $O(n)$ time to copy each one into the final list.
* **Space Complexity:** 𝙊(𝗻) - The depth of the recursion stack and the space used by the `temp` list.

## 💻 Implementation (Java)
```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(0, nums.length, nums, list, new ArrayList<>());
        return list;
    }

    void helper(int s, int len, int[] nums, List<List<Integer>> list, List<Integer> temp) {
        // Every node in the recursion tree is a valid subset
        list.add(new ArrayList<>(temp));

        for (int i = s; i < len; i++) {
            temp.add(nums[i]); // Include nums[i]
            helper(i + 1, len, nums, list, temp); // Move to next elements
            temp.remove(temp.size() - 1); // Backtrack
        }
    }
}
