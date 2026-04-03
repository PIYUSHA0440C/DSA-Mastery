# 55. Jump Game (Medium)

## 📝 Problem Statement
You are given an integer array `nums` where each element represents your maximum jump length at that position. Starting at the first index, determine if you can reach the last index.

## 💡 Intuition & Approach
The most intuitive way to solve this is to work backward from the finish line to the start. 

### 🛠️ The Strategy:
1. **The Goal Post:** Initialize `goal` as the last index of the array.
2. **Backward Iteration:** Start a loop from the second-to-last element and move toward the first element (index 0).
3. **Shift the Goal:** For each index `i`, check if the jump available at that index (`nums[i]`) is enough to reach the current `goal`.
   - Condition: `i + nums[i] >= goal`
   - If true, it means from index `i`, we can reach our destination. Therefore, `i` becomes our new `goal`.
4. **Final Check:** After the loop, if the `goal` has moved all the way to `0`, it means there is a continuous chain of jumps from the start to the end.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We perform a single linear scan of the array from right to left.
* **Space Complexity:** 𝙊(𝟭) - We only use one integer variable (`goal`) to track our target.

## 💻 Implementation (Java)
```java
class Solution {
    public boolean canJump(int[] nums) {
        // Start by trying to reach the last index
        int goal = nums.length - 1;

        // Iterate backwards from the end to the start
        for (int i = nums.length - 1; i >= 0; i--) {
            // If current index + jump power can reach or pass the current goal
            if (i + nums[i] >= goal) {
                // Move the goal closer to the start
                goal = i;
            }
        }

        // If the goal reaches the starting index, a path exists
        return goal == 0;
    }
}
