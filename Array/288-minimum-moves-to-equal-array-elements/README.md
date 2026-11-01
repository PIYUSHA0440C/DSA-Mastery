# 453. Minimum Moves to Equal Array Elements (Medium)

## 📝 Problem Statement

Given an integer array, find the minimum number of moves required to make all elements equal. In one move, you can increment exactly `n - 1` elements by 1.

## 💡 Intuition & Approach

Incrementing `n - 1` elements by 1 has the same effect on the differences between elements as decrementing the remaining element by 1.

Therefore, instead of simulating the moves, we can calculate how many increments each element needs to reach the minimum element's value difference.

## 🛠️ The Strategy:

1. Find the minimum value in the array.
2. Calculate the difference between every element and the minimum value.
3. Add all differences to get the minimum number of moves.
4. Use `long` for the total to avoid intermediate integer overflow.

## 📊 Complexity Analysis

- **Time Complexity:** O(n), using two traversals of the array.
- **Space Complexity:** O(1), using only a few variables.

## 💻 Implementation (Java)

```java
class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int x: nums) if (x < min) min = x;

        long moves = 0;

        for (int x: nums) moves += x - min;

        return (int) moves;
    }
}
```
