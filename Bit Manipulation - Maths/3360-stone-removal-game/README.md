
# 3360. Stone Removal Game (Easy)

## Problem Statement

Alice and Bob take turns removing stones from a pile, with Alice playing first.

- Alice must remove exactly 10 stones on her first turn.
- On each subsequent turn, a player must remove exactly one fewer stone than the previous opponent removed.

The player who cannot make the required move loses.

Given a positive integer `n`, return `true` if Alice wins; otherwise, return `false`.

## Intuition & Approach

The key observation is that the number of stones removed decreases by exactly one after every turn.

Alice starts by removing 10 stones, Bob must remove 9, Alice must remove 8, and so on.

We can simulate the game using a simple loop:

- Initialize `take` to 10, representing the stones to remove on the current turn.
- If enough stones remain, subtract `take` from `n`.
- Decrease `take` by one and increment the turn counter.
- Continue until the remaining stones are insufficient for the required move.

Since Alice starts first, she wins if the number of successful moves is odd. Otherwise, Bob wins.

## Strategy

1. Initialize `take = 10` and `k = 0`.
2. While `n >= take`, remove the required stones.
3. Decrease `take` by one after each successful move.
4. Increment the move counter.
5. Return `true` if the number of successful moves is odd; otherwise, return `false`.

## Complexity Analysis

- **Time Complexity:** O(1) - At most 10 iterations are possible because the required number of stones decreases from 10 to 1.
- **Space Complexity:** O(1) - Only two additional variables are used.

## Java Solution

```java id="q8v3mx"
class Solution {
    public boolean canAliceWin(int n) {
        int take = 10;
        int k = 0;

        while (n >= take) {
            n -= take;
            take--;
            k++;
        }

        return k % 2 == 1;
    }
}
```

## Key Takeaway

This problem can be solved through straightforward simulation. Counting successful moves and checking their parity determines which player makes the final valid move.
