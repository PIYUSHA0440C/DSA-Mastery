# 462. Minimum Moves to Equal Array Elements II (Medium)

## 📝 Problem Statement

Given an integer array, find the minimum number of moves required to make all elements equal. In one move, you can increment or decrement any single element by 1.

## 💡 Intuition & Approach

The optimal value to make all elements equal is the median of the sorted array. The median minimizes the sum of absolute differences between all elements and the chosen value.

## 🛠️ The Strategy:

1. Sort the array in increasing order.
2. Select the middle element as the median.
3. Calculate the absolute difference between each element and the median.
4. Sum all differences to get the minimum number of moves.

## 📊 Complexity Analysis

- **Time Complexity:** O(n log n), due to sorting. Calculating the differences takes O(n).
- **Space Complexity:** O(log n) auxiliary space for Java's primitive array sorting implementation.

## 💻 Implementation (Java)

```java
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int median = nums[nums.length / 2];
        int moves = 0;

        for (int num: nums) moves += Math.abs(num - median);

        return moves;
    }
}
```
