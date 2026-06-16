# 322. Coin Change (Medium)

## 📝 Problem Statement
You are given an integer array `coins` representing coins of different denominations and an integer `amount` representing a total amount of money. Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return `-1`. You may assume that you have an infinite number of each kind of coin.

## 💡 Intuition & Approach
This is a classic **Dynamic Programming (Bottom-Up)** problem. The minimum number of coins needed to make change for a target `amount` depends directly on the optimal solutions to smaller sub-amounts.

We define a 1D state array `dp` where `dp[i]` represents the fewest coins required to build value `i`. For every target value `i` from 1 to `amount`, we try subtracting each available coin denomination. If the value `i - coin` is non-negative, the relation is:
`dp[i] = min(dp[i], 1 + dp[i - coin])`

### 🛠️ The Strategy:
1. **Array Initialization:** Create a `dp` array of size `amount + 1`. Fill it with a sentinel value `amount + 1` (acting as a safe substitute for infinity to prevent integer overflow).
2. **Base Case:** Set `dp[0] = 0` since zero coins are required to form an amount of 0.
3. **Tabulation Iteration:** Loop from 1 to `amount`. Inside, iterate through every denomination in `coins` to calculate the minimum step transitions.
4. **Validation Exit:** Check if `dp[amount]` retains the sentinel value. If it does, a valid combination is impossible; return `-1`. Otherwise, return the computed value.

## 📊 Complexity Analysis
* **Time Complexity:** O(Amount * N) - Where N is the number of coin denominations. The outer loop runs `amount` times, and the inner loop checks up to $N$ coins.
* **Space Complexity:** O(Amount) - The size of the DP state table allocation depends linearly on the target amount.

## 💻 Implementation (Java)
```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // Initialize with a value larger than any possible optimal coin count
        Arrays.fill(dp, amount + 1);
        dp[0] = 0; // Base case

        // Populate the DP table from bottom to top
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[dp.length - 1 - (dp.length - 1 - (i - coin))]); 
                    // Simpler view: dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        // If the amount remains unreachable, return -1
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}
