# 3736. Minimum Moves to Equal Array Elements III (Easy)

## 📝 Problem Statement

Given an integer array, find the minimum number of moves required to make all elements equal. In one move, you can increase any single element by 1.

## 💡 Intuition & Approach

Since we can only increase elements, the optimal target is the maximum element in the array. Every other element must be increased until it reaches this maximum.

Instead of calculating the difference for each element separately, we can use the sum of the array.

## 🛠️ The Strategy:

1. Find the maximum element and calculate the sum of all elements.
2. Consider the maximum element as the target value.
3. Calculate the total moves using:

   `nums.length * max - sum`

This gives the total difference between the target values and the current array values.

## 📊 Complexity Analysis

- **Time Complexity:** O(n), as we traverse the array once.
- **Space Complexity:** O(1), as we use only two variables.

## 💻 Implementation (Java)

```java
class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int num: nums) {
            if (num > max) max = num;
            sum += num;
        }

        return nums.length * max - sum;
    }
}
```
