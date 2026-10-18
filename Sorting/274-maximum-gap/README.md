# 164. Maximum Gap (Medium)

## 📝 Problem Statement

Given an integer array `nums`, return the maximum difference between two successive elements in its sorted order. If the array contains fewer than two elements, return `0`.

## 💡 Intuition & Approach

Sort the array in ascending order so that consecutive elements can be compared directly. Traverse the sorted array and calculate the difference between each element and its predecessor, keeping track of the maximum difference.

### 🛠️ The Strategy:

1. If the array contains fewer than two elements, return `0`.
2. Sort the array in ascending order.
3. Initialize `maxValue` to `0`.
4. Traverse the array from index `1`, calculating the difference between consecutive elements.
5. Update `maxValue` whenever a larger difference is found.
6. Return the maximum difference.

## 📊 Complexity Analysis

- **Time Complexity:** O(n log n), due to sorting.
- **Space Complexity:** O(log n) auxiliary space for Java primitive-array sorting.

**Note:** This solution works for the problem's expected output, but it does not meet the stated requirement of linear time and linear extra space. A linear-time bucket-based approach would be needed to satisfy that requirement.

## 💻 Implementation (Java)

```java
class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;

        Arrays.sort(nums);
        long maxValue = 0;

        for (int i = 1; i < nums.length; i++){
            if (nums[i] - nums[i - 1] > maxValue){
                maxValue = nums[i] - nums[i - 1];
            }
        }

        return (int)maxValue;
    }
}
```
