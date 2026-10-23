# 2441. Largest Positive Integer That Exists With Its Negative (Easy)

## 📝 Problem Statement

Given an integer array containing no zeros, find the largest positive integer `k` such that both `k` and `-k` exist in the array. Return `-1` if no such integer exists.

## 💡 Intuition & Approach

After sorting the array, negative numbers are placed at the beginning and positive numbers at the end. Two pointers can compare the absolute value of the smallest element with the largest element to find a matching positive-negative pair.

### 🛠️ The Strategy:

1. Sort the array in ascending order.
2. Initialize `low` at the beginning and `high` at the end.
3. If `-nums[low]` equals `nums[high]`, return the matching positive integer.
4. If `-nums[low]` is greater than `nums[high]`, move `low` forward.
5. Otherwise, move `high` backward.
6. Return `-1` if no matching pair is found.

## 📊 Complexity Analysis

- **Time Complexity:** O(n log n), dominated by sorting.
- **Space Complexity:** O(log n) auxiliary space for Java's primitive-array sorting implementation.

## 💻 Implementation (Java)

```java
class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            if (-nums[low] == nums[high]) return nums[high];

            else if (-nums[low] > nums[high]) low++;
            else high--;
        }

        return -1;
    }
}
```
