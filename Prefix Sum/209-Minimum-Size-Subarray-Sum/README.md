# 209. Minimum Size Subarray Sum (Medium)

## 📝 Problem Statement

Given an array of positive integers `nums` and a positive integer `target`, find the minimal length of a contiguous subarray whose sum is greater than or equal to `target`. Return `0` if no such subarray exists.

## 💡 Intuition & Approach

Because all elements are positive, a sliding window can efficiently find the minimum-length valid subarray. Expand the window by moving the right pointer and shrink it from the left whenever the current sum reaches or exceeds the target.

### 🛠️ The Strategy:

1. Initialize two pointers `i` and `j` to represent the sliding window.
2. Add elements to `sum` while moving the right pointer `j`.
3. Whenever `sum >= target`, update the minimum window length.
4. Remove `nums[i]` from the sum and move the left pointer forward.
5. Continue shrinking while the window remains valid.
6. Continue expanding until the right pointer reaches the end of the array.
7. Return the minimum length, or `0` if no valid subarray was found.

## 📊 Complexity Analysis

* **Time Complexity:** O(n)
* **Space Complexity:** O(1)

## 💻 Implementation (Java)

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j++];

            while (sum >= target) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
```
