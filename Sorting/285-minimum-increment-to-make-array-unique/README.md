# 945. Minimum Increment to Make Array Unique (Medium)

## 📝 Problem Statement

Given an integer array `nums`, find the minimum number of increments required to make every element unique. In one move, any element can be increased by `1`.

## 💡 Intuition & Approach

Use a frequency array to track how many times each value appears. If a value occurs more than once, keep one occurrence and carry the duplicates to the next value, counting each duplicate as one required increment.

### 🛠️ The Strategy:

1. Find the maximum value in `nums`.
2. Create a frequency array of size `n + max`, providing enough space for duplicates to move forward.
3. Count the occurrences of each value.
4. Traverse the frequency array. Whenever a value has duplicates, keep one occurrence and move the remaining occurrences to the next value.
5. Add the number of duplicates to `minIncrements`.
6. Return the total number of increments.

## 📊 Complexity Analysis

- **Time Complexity:** O(n + max), where `max` is the maximum value in the input array.
- **Space Complexity:** O(n + max) for the frequency array.

## 💻 Implementation (Java)

```java
class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        int max = 0;
        int minIncrements = 0;

        for (int val : nums) max = Math.max(max, val);

        int[] frequencyCount = new int[n + max];

        for (int val : nums) frequencyCount[val]++;

        for (int i = 0; i < frequencyCount.length; i++) {
            if (frequencyCount[i] <= 1) continue;

            int duplicates = frequencyCount[i] - 1;
            frequencyCount[i + 1] += duplicates;
            frequencyCount[i] = 1;
            minIncrements += duplicates;
        }

        return minIncrements;
    }
}
```
