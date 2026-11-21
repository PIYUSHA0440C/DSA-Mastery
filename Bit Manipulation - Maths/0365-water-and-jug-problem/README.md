
# 365. Water and Jug Problem (Medium)

## Problem Statement

You are given two jugs with capacities `x` and `y` liters and an infinite water supply.

Determine whether it is possible to measure exactly `target` liters in total using the following operations:

- Fill either jug completely.
- Empty either jug completely.
- Pour water from one jug into the other until the receiving jug is full or the transferring jug is empty.

Return `true` if the target amount can be measured; otherwise, return `false`.

## Intuition & Approach

Instead of simulating every possible jug operation, we can use the mathematical property of the **Greatest Common Divisor (GCD)**.

According to Bézout's identity, the target amount can be measured if and only if:

1. The target does not exceed the combined capacity of both jugs.
2. The target is divisible by the GCD of the two jug capacities.

We first handle cases where either jug has zero capacity. Then, we calculate the GCD using the Euclidean algorithm.

Finally, we check whether `target` is divisible by the calculated GCD.

## Strategy

1. If `x + y` is smaller than `target`, return `false`.
2. Handle cases where either jug has zero capacity.
3. Calculate the GCD of `x` and `y` using the Euclidean algorithm.
4. Return whether `target % gcd == 0`.

## Complexity Analysis

- **Time Complexity:** O(log(min(x, y))) - The Euclidean algorithm efficiently calculates the GCD.
- **Space Complexity:** O(1) - Only a constant amount of extra space is used.

## Java Solution

```java
class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if (x + y < target) return false;
        if (x == 0) return target == y || target == 0;
        if (y == 0) return target == x || target == 0;

        while (x != 0) {
            int temp = x;
            x = y % x;
            y = temp;
        }

        return target % y == 0;
    }
}
```
