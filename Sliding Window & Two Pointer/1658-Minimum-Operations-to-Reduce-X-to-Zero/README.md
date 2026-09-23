# 1658. Minimum Operations to Reduce X to Zero (Medium)

## 📝 Problem Statement

Given an integer array `nums` and an integer `x`, in one operation you can remove either the leftmost or rightmost element and subtract its value from `x`.

Return the minimum number of operations needed to reduce `x` to exactly `0`. If it is impossible, return `-1`.

## 💡 Intuition & Approach

Instead of finding the elements to remove from both ends, we can find the longest contiguous subarray that should remain.

If the total sum of the array is `total`, then the elements that remain must have a sum of:

`target = total - x`

So the problem becomes finding the longest subarray with sum equal to `target`. Since all elements are positive, a sliding window can find this subarray efficiently.

### 🛠️ The Strategy:

1. Calculate the total sum of the array.
2. Compute `target = total - x`.
3. If `target < 0`, reducing `x` to zero is impossible.
4. Use a sliding window to find the longest contiguous subarray whose sum equals `target`.
5. If its length is `longest`, then the minimum number of removed elements is `len - longest`.
6. If no such subarray exists, return `-1`.
7. When `target == 0`, the entire array must be removed, so the answer is `len`.

## 📊 Complexity Analysis

- **Time Complexity:** O(n), where `n` is the length of the array.
- **Space Complexity:** O(1)

## 💻 Implementation (Java)

```java
class Solution {
    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        int total = 0;

        for(int num: nums) total += num;

        int target = total - x;

        if(target < 0) return -1;
        if(target == x) return len;

        int left = 0;
        int sum = 0;
        int longest = -1;

        for(int right = 0; right < len; right++){
            sum += nums[right];

            while(left <= right && sum > target) {
                sum -= nums[left];
                left++;
            }

            if(sum == target) {
                longest = Math.max(longest, right - left + 1);
            }
        }

        return longest == -1 ? -1 : len - longest;
    }
}
```
