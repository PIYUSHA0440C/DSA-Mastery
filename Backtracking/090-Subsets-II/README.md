# 90. Subsets II (Medium)

## 📝 Problem Statement
Given an integer array `nums` that may contain duplicates, return all possible subsets (the power set). The solution set must not contain duplicate subsets.

## 💡 Intuition & Approach
When an array contains duplicates, a standard power set algorithm will produce identical subsets. To avoid this, we must ensure that at each level of recursion, we don't start a new branch with a number we've already used at that same level.

### 🛠️ The Strategy:
1. **Sorting:** First, sort the array. This brings duplicate elements together, making them easy to identify.
2. **Recursive Backtracking:** - Add the `current` path to our result list immediately (since every node in the recursion tree is a valid subset).
   - Loop from `start` to `end`.
3. **Duplicate Pruning:** The condition `if(i > start && nums[i] == nums[i-1])` is key. 
   - If the current number is the same as the previous one AND we are not at the very first element of the current loop, we **skip** it. This prevents creating the same subset structure twice.
4. **Standard Backtrack:** Add element $\to$ Recurse $\to$ Remove element.



## 📊 Complexity Analysis
* **Time Complexity:** $O(n \cdot 2^n)$ - There are $2^n$ possible subsets, and we spend $O(n)$ time to copy each subset into the result list.
* **Space Complexity:** $O(n)$ - To store the current subset and the recursion stack.

## 💻 Implementation (Java)
```java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); // Necessary for duplicate handling
        backtrack(nums, 0, list, new ArrayList<>());
        return list;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> list, List<Integer> curr) {
        list.add(new ArrayList<>(curr));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates at the same recursive level
            if (i > start && nums[i] == nums[i - 1]) continue;

            curr.add(nums[i]);
            backtrack(nums, i + 1, list, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
