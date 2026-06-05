# 42. Trapping Rain Water (Hard)

## 📝 Problem Statement
Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.

## 💡 Intuition & Approach
The water trapped above any individual bar at index `i` is determined by the bottleneck between the tallest bar to its left and the tallest bar to its right:
`Water[i] = min(leftMax, rightMax) - height[i]`

Instead of precomputing these maximum arrays using extra space, we can maintain two pointers (`left` and `right`) and two variables (`leftMax` and `rightMax`) to process the array from both ends inward.

### 🛠️ The Strategy:
1. **Pointers Initialization:** Start `left` at `0` and `right` at `n - 1`.
2. **Boundary Comparison:** At each step, compare `height[left]` and `height[right]`:
   - If `height[left] < height[right]`, we know the water level at `left` is entirely limited by `leftMax` (since a taller wall exists on the right side somewhere).
     - Update `leftMax` if the current height is greater.
     - Otherwise, add the difference `leftMax - height[left]` to `totalWater`.
     - Advance `left++`.
   - If `height[right] <= height[left]`, the water level at `right` is limited by `rightMax`.
     - Update `rightMax` if the current height is greater.
     - Otherwise, add the difference `rightMax - height[right]` to `totalWater`.
     - Retreat `right--`.
3. **Termination:** The loop ends when `left == right`.

## 📊 Complexity Analysis
* **Time Complexity:** O(N) - We process each element in the array exactly once using our converging pointers.
* **Space Complexity:** O(1) - The solution operates strictly in-place using scalar variables to track maximum values and pointer positions.

## 💻 Implementation (Java)
```java
class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        // Two-pointer approach narrowing inwards
        while (left < right) {
            if (height[left] < height[right]) {
                // Left side is the bottleneck
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update new left boundary
                } else {
                    totalWater += leftMax - height[left]; // Collect trapped water
                }
                left++;
            } else {
                // Right side is the bottleneck
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update new right boundary
                } else {
                    totalWater += rightMax - height[right]; // Collect trapped water
                }
                right--;
            }
        }

        return totalWater;
    }
}
