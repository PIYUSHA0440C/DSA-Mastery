# 334. Increasing Triplet Subsequence (Medium)

## 📝 Problem Statement

Given an integer array, determine whether there exist three indices `i`, `j`, and `k` such that `i < j < k` and `nums[i] < nums[j] < nums[k]`.

Return `true` if such an increasing triplet exists; otherwise, return `false`.

## 💡 Intuition & Approach

Instead of checking every possible triplet, maintain two variables representing the smallest possible first and second elements of an increasing subsequence.

If we find a number greater than both, an increasing triplet exists.

## 🛠️ The Strategy:

1. Initialize `a` and `b` with `Integer.MAX_VALUE`.
2. Traverse the array:
   - If the current number is less than or equal to `a`, update `a`.
   - Otherwise, if it is less than or equal to `b`, update `b`.
   - Otherwise, the current number is greater than both `a` and `b`, so return `true`.
3. If no such number is found, return `false`.

## 📊 Complexity Analysis

- **Time Complexity:** O(n), as the array is traversed once.
- **Space Complexity:** O(1), as only two variables are maintained.

## 💻 Implementation (Java)

```java
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;

        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        for (int num: nums) {
            if (num <= a) a = num;
            else if (num <= b) b = num;
            else return true;
        }

        return false;
    }
}
```
