# 3942. Minimum Operations to Sort a Permutation (Medium)

## 📝 Problem Statement

Given a permutation of integers from `0` to `n - 1`, find the minimum number of operations required to sort it in increasing order. The only allowed operations are reversing the entire array and rotating it left by one position. Return `-1` if sorting is impossible.

## 💡 Intuition & Approach

A left rotation changes the starting position of the permutation, while a reversal changes its direction. Therefore, the array must match either the increasing or decreasing sequence when viewed cyclically from the position containing `0`.

### 🛠️ The Strategy:

1. Find the index of `0`, which determines the cyclic starting position.
2. Traverse the array cyclically from that position.
3. Check whether the remaining elements follow the increasing sequence or the decreasing sequence.
4. If neither pattern matches, return `-1`.
5. Otherwise, calculate the minimum operations needed using rotations alone or a reversal followed by rotations.

## 📊 Complexity Analysis

- **Time Complexity:** O(n), since the array is traversed a constant number of times.
- **Space Complexity:** O(1), as only a few variables are used.

## 💻 Implementation (Java)

```java
class Solution {

    public int minOperations(int[] nums) {
        final int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int start = 0;
        while (nums[start] != 0) {
            start++;
        }

        boolean asc = true;
        boolean desc = true;

        for (int i = 1; i < n; i++) {
            final int value = nums[(start + i) % n];

            if (value != i) {
                asc = false;
            }
            if (value != n - i) {
                desc = false;
            }

            if (!asc && !desc) {
                return -1;
            }
        }

        if (asc) {
            return Math.min(start, n - start + 2);
        }

        return Math.min(n - start, start + 2);
    }
}
```
