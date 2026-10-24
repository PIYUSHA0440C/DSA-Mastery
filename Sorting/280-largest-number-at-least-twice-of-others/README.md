# 747. Largest Number At Least Twice of Others (Easy)

## 📝 Problem Statement

Given an integer array where the largest element is unique, return its index if it is at least twice every other element. Otherwise, return `-1`.

## 💡 Intuition & Approach

First, find the index of the largest element. Then compare it with every other element to check whether the largest value is at least twice as large.

### 🛠️ The Strategy:

1. Initialize `maxIndex` to `0`.
2. Traverse the array to find the index of the largest element.
3. Traverse the array again, skipping the largest element's index.
4. If the largest value is less than twice any other value, return `-1`.
5. If all comparisons pass, return `maxIndex`.

## 📊 Complexity Analysis

- **Time Complexity:** O(n), using two linear traversals.
- **Space Complexity:** O(1), using only a constant number of variables.

## 💻 Implementation (Java)

```java
class Solution {
    public int dominantIndex(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }

        for (int i = 0; i < nums.length; i++) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i]) return -1;
        }

        return maxIndex;
    }
}
```
