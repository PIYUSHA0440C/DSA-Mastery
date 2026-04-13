# 1848. Minimum Distance to the Target Element (Easy)

## 📝 Problem Statement
Given an integer array `nums`, a `target` value, and a `start` index, find an index `i` such that `nums[i] == target` and $|i - start|$ is minimized. Return the minimum distance.

## 💡 Intuition & Approach
The problem asks for the minimum "distance" between a specific starting point and any occurrence of the target. Since the array isn't sorted by value, we must check all occurrences to find the one closest to our `start`.

### 🛠️ The Strategy:
1. **Initialize:** Set a variable `ans` to the largest possible integer value.
2. **Linear Scan:** Traverse the array from index `0` to `n-1`.
3. **Match & Compare:** - Every time `nums[i]` matches the `target`, calculate the absolute distance: `Math.abs(i - start)`.
   - Update `ans` if this new distance is smaller than our current minimum.
4. **Result:** Return the final value of `ans`.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We visit each element in the array exactly once.
* **Space Complexity:** 𝙊(𝟭) - We only use one integer variable to track the minimum distance.

## 💻 Implementation (Java)
```java
class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int ans = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            // Check if the current element is our target
            if (nums[i] == target) {
                // Calculate distance from start and keep the minimum
                int currentDistance = Math.abs(i - start);
                if (currentDistance < ans) {
                    ans = currentDistance;
                }
            }
        }
        
        return ans;
    }
}
