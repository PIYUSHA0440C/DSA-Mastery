# 122. Best Time to Buy and Sell Stock II (Medium)

## 📝 Problem Statement
You are given an array `prices` where `prices[i]` is the price of a given stock on the $i^{th}$ day. You can buy and sell multiple times, but you can only hold at most one share at a time. Find the maximum profit possible.

## 💡 Intuition & Approach
The goal is to capture all possible price increases. If you think of the prices as a line graph, you want to sum up every segment where the slope is positive.

### 🛠️ The Strategy:
1. **Greedy Profit:** We iterate through the price array starting from the second day.
2. **Local Gains:** If `prices[i]` (today) is greater than `prices[i-1]` (yesterday), we treat it as a profit-making opportunity.
3. **The Logic:**
   - Subtract yesterday's price from today's price and add it to `max`.
   - Update our "buying price" (`start`) to today's price.
4. **Why it works:** Even if the price goes up for three consecutive days (1, 5, 10), adding $(5-1) + (10-5)$ is exactly the same as $(10-1)$. This approach automatically handles both short-term trades and long-term holds.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We perform a single linear scan of the prices array.
* **Space Complexity:** 𝙊(𝟭) - We only store a few integer variables.

## 💻 Implementation (Java)
```java
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int start = prices[0];
        int len = prices.length;

        for (int i = 1; i < len; i++) {
            // If price today is higher than our reference price, take the profit
            if (start < prices[i]) {
                maxProfit += prices[i] - start;
            }
            // Move our reference to today's price
            start = prices[i];
        }

        return maxProfit;
    }
}
