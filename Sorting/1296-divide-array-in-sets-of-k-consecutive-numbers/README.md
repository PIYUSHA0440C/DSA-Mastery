
# 1296. Divide Array in Sets of K Consecutive Numbers (Medium)

## Problem Statement

Given an integer array `nums` and a positive integer `k`, determine whether the array can be divided into groups of exactly `k` consecutive numbers.

Return `true` if such a division is possible; otherwise, return `false`.

## Intuition & Approach

The key observation is that every group must contain consecutive numbers, and each number can only be used as many times as it appears in the original array.

We can use a HashMap to maintain the frequency of each number and sorting to process the numbers in ascending order.

For every number with a remaining frequency, we try to form a group of `k` consecutive numbers starting from that number.

## Strategy

1. Create a HashMap to store the frequency of each number.
2. Sort the array in ascending order.
3. Traverse the sorted array and check whether the current number has a remaining frequency.
4. If its frequency is greater than zero, try to form a consecutive group of size `k`.
5. Decrease the frequency of every number used in the group.
6. If any required consecutive number is unavailable, return `false`.
7. If all groups are formed successfully, return `true`.

## Complexity Analysis

- **Time Complexity:** O(n log n + nk)
  - O(n log n) for sorting.
  - O(n) for building the frequency map.
  - O(nk) for checking and forming consecutive groups in the worst case.

- **Space Complexity:** O(n) for storing the frequency map.

## Java Solution

```java
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(nums);

        for (int num : nums) {
            if (map.get(num) > 0) {
                for (int i = num + 1; i < num + k; i++) {
                    if (map.getOrDefault(i, 0) == 0) {
                        return false;
                    }

                    map.put(i, map.get(i) - 1);
                }

                map.put(num, map.get(num) - 1);
            }
        }

        return true;
    }
}
```

## Key Takeaway

Combining sorting with frequency counting provides an effective way to construct consecutive groups while handling duplicate elements correctly.
```
