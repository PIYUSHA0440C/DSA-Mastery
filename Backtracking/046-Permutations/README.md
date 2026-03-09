# 46. Permutations (Medium)

## 📝 Problem Statement
Given an array `nums` of distinct integers, return all possible permutations. A permutation is an arrangement of all the elements in the array in a specific order.

## 💡 Intuition & Approach
Unlike combinations, permutations require us to use every element in different orders. We use **Backtracking** to build these arrangements step-by-step.

### 🛠️ The Strategy:
1. **Decision Tree:** At each level of recursion, we attempt to add every number from the input array to our current permutation.
2. **Constraint Check:** Since all numbers in `nums` are unique, we check `if (temp.contains(arr[i]))` to skip numbers already present in the current path.
3. **Recursive Exploration:**
   - **Add** an available number.
   - **Recurse** to fill the next position.
   - **Backtrack** by removing the last number to try the next available candidate.
4. **Base Case:** When the size of our temporary list matches the length of the input array, we have a complete permutation.

]

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻 × 𝗻!) - There are $n!$ permutations, and it takes $O(n)$ to copy each one to the result list.
* **Space Complexity:** 𝙊(𝗻) - The depth of the recursion stack and the temporary list.

## 💻 Implementation (Java)
```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtracking(nums.length, nums, list, new ArrayList<>());
        return list;
    }

    void backtracking(int len, int[] arr, List<List<Integer>> list, List<Integer> temp) {
        // Base case: we have used all numbers
        if (temp.size() == len) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < len; i++) {
            // Skip if element is already in the current permutation
            if (temp.contains(arr[i])) continue;
            
            temp.add(arr[i]); // Choose
            backtracking(len, arr, list, temp); // Explore
            temp.remove(temp.size() - 1); // Un-choose (Backtrack)
        }
    }
}
