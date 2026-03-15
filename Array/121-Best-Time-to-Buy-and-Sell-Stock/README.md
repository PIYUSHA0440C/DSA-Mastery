# 121. Best Time to Buy and Sell Stock (Easy)

## 📝 Problem Statement
Given an array `prices` where `prices[i]` is the price of a stock on the $i^{th}$ day, find the maximum profit you can achieve by buying on one day and selling on a different day in the future.

## 💡 Intuition & Approach: Greedy
To maximize profit, we want to buy at the lowest possible price and sell at the highest possible price *after* that buy date.

### 🛠️ The Strategy:
1. **Initialize:** Set `minPrice` to the first day's price and `maxProfit` to 0.
2. **Iterate:** For each price in the array:
   - **Update Minimum:** If the current price is lower than `minPrice`, update `minPrice`.
   - **Calculate Profit:** Otherwise, calculate the potential profit (`price - minPrice`) and update `maxProfit` if this new profit is higher than our previous best.
3. **Efficiency:** This is done in a single pass ($O(n)$), making it highly efficient for large datasets.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We traverse the prices array exactly once.
* **Space Complexity:** 𝙊(𝟭) - Only two variables are used to store the state.

## 💻 Implementation (Java)
```java
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                // Found a new potential buying day
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                // Selling today gives a better profit than before
                maxProfit = price - minPrice;
            }
        }
        
        return maxProfit;
    }
}
