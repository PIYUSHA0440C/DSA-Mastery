# 39. Combination Sum (Medium)

## 📝 Problem Statement
Given an array of distinct integers `candidates` and a `target` integer, return a list of all unique combinations where the chosen numbers sum to the target. You may use the same number from candidates an unlimited number of times.

## 💡 Intuition & Approach
This is an exhaustive search problem that can be modeled as a decision tree. At each step, we have two choices: include the current element in our sum or skip it.

### 🛠️ The Strategy:
1. **Recursive Decision Tree:**
   - **Choice 1 (Pick):** If the current element `arr[idx]` is less than or equal to the remaining `target`, add it to our list. Since we can reuse elements, we call the helper function again with the **same index** but a reduced target.
   - **Choice 2 (Skip):** Move to the next index `idx + 1` to explore combinations without the current element.
2. **Backtracking:** After the "Pick" recursion returns, we remove the last element (`current.remove`) to restore the state before trying the "Skip" path.
3. **Base Case:** - If we've exhausted the array (`idx == arr.length`), check if the target is 0. If it is, we found a valid combination.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝟮ᵗ) - Where $t$ is the target value. The actual complexity depends on the number of recursive calls, which is bounded by the target and the smallest candidate value.
* **Space Complexity:** 𝙊(𝗸 × 𝘅) - $k$ is the average length of a combination and $x$ is the total number of combinations.

## 💻 Implementation (Java)
```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        helper(0, target, candidates, list, current);
        return list;
    }

    void helper(int idx, int target, int[] arr, List<List<Integer>> list, List<Integer> current) {
        if (idx == arr.length) {
            if (target == 0) {
                list.add(new ArrayList<>(current));
            }
            return;
        }

        // Pick the element
        if (arr[idx] <= target) {
            current.add(arr[idx]);
            // Stay at idx to allow repeated use
            helper(idx, target - arr[idx], arr, list, current);
            current.remove(current.size() - 1);
        }

        // Don't pick the element
        helper(idx + 1, target, arr, list, current);
    }
}
