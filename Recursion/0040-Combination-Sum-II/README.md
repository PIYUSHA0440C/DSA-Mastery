# 40. Combination Sum II (Medium)

## 📝 Problem Statement
Given a collection of candidate numbers (`candidates`) and a target number (`target`), find all unique combinations in `candidates` where the candidate numbers sum to `target`. Each number in `candidates` may only be used **once** in the combination. The solution set must not contain duplicate combinations.

## 💡 Intuition & Approach
This problem is efficiently modeled as a **Backtracking Search Tree**. Since candidates can contain duplicate values but the final result cannot contain duplicate combinations, sorting the input array is essential. 

Instead of generating combinations blindly and sorting or checking duplicate structures post-generation (which causes a bottleneck), we prune the recursion tree branches inline. For any choice level inside the recursive loop starting at index `idx`, if an element `arr[i]` matches its predecessor `arr[i - 1]`, we skip it. This ensures that a value is only chosen once to start a structural slot at that specific recursion depth level.

### 🛠️ The Strategy:
1. **Sort Candidates:** Group identical values together to allow inline deduplication.
2. **Backtracking DFS:** Use a pointer `idx` and tracking variable `sum`.
3. **Branch Pruning:** Inside the loop, check if `i > idx && arr[i] == arr[i - 1]`. If true, skip the iteration to stop duplicate branches.
4. **Base Case:** If `sum == target`, copy the current configuration into the result table. If `sum > target`, terminate that path early.

## 📊 Complexity Analysis
* **Time Complexity:** O(2^N) - In the worst case, every element can either be chosen or skipped, generating an exponential recursion framework bounded by the target limits.
* **Space Complexity:** O(N) - The depth of the runtime stack frame map scales linearly with the length of the input array.

## 💻 Implementation (Java)
```java
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates); // Sort to group duplicates and enable pruning

        helper(0, 0, target, candidates, list, curr);
        return list;
    }

    private void helper(int idx, int sum, int target, int[] arr, List<List<Integer>> list, List<Integer> curr) {
        // Base case: target matched
        if (sum == target) {
            list.add(new ArrayList<>(curr));
            return;
        }
        
        // Base case: exceeded target
        if (sum > target) {
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            // Prune duplicate sibling combinations at the same recursion level
            if (i > idx && arr[i] == arr[i - 1]) continue;

            curr.add(arr[i]);
            // Recurse with incremented pointer (i + 1) since each element is used once
            helper(i + 1, sum + arr[i], target, arr, list, curr);
            curr.remove(curr.size() - 1); // Backtrack
        }
    }
}
