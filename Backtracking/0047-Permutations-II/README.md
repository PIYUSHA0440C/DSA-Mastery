# 47. Permutations II (Medium)

## 📝 Problem Statement
Given a collection of numbers, `nums`, that might contain duplicates, return all possible unique permutations in any order.

## 💡 Intuition & Approach
Generating permutations of an array with unique numbers is straightforward. However, when duplicates are introduced, multiple branches of the backtracking tree can yield the exact same sequence. 

To prevent duplicate permutations efficiently:
1. **Sort the Array:** Sorting ensures all identical numbers are adjacent to each other.
2. **State Tracking (`used` array):** A boolean array tracks which indices are currently active in our permutation branch.
3. **Pruning Condition:** While iterating through options for the current position, skip the current number if:
   - It matches the previous number: `nums[i] == nums[i - 1]`
   - The previous number has not been used yet in this path: `!used[i - 1]`
   
This specific pruning ensures that out of a set of duplicate values, we only allow them to be picked in a strict left-to-right order, cutting off duplicate recursive branches early.

## 📊 Complexity Analysis
* **Time Complexity:** $O(N \cdot N!)$ - There are at most $N!$ unique permutations. For each permutation, we spend $O(N)$ time copying the elements into the result list. Pruning significantly reduces the actual number of states explored compared to a full brute-force search.
* **Space Complexity:** $O(N)$ - To maintain the recursive call stack, the `temp` path list, and the `used` array tracker.

## 💻 Implementation (Java)
```java
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Group duplicates together
        Arrays.sort(nums);

        backtracking(nums, list, new ArrayList<>(), new boolean[nums.length]);
        return list;
    }

    private void backtracking(int[] nums, List<List<Integer>> list, List<Integer> temp, boolean[] used) {
        // Base case: full permutation found
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            // Prune duplicate branches
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            temp.add(nums[i]);
            
            backtracking(nums, list, temp, used); // Recurse

            // Undo move (Backtrack)
            used[i] = false;
            temp.remove(temp.size() - 1); 
        }
    }
}
