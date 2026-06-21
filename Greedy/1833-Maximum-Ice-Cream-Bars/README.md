# 1833. Maximum Ice Cream Bars (Medium)

## 📝 Problem Statement
It is a sweltering summer day, and a boy wants to buy some ice cream bars. At the store, there are `n` ice cream bars. You are given an array `costs` of length `n`, where `costs[i]` is the price of the `i`-th ice cream bar in coins. The boy initially has `coins` coins to spend, and he wants to buy as many ice cream bars as possible. 

Note: The boy can buy the ice cream bars in any order. Return the maximum number of ice cream bars the boy can buy with `coins` coins. You must solve the problem by counting sort.

## 💡 Intuition & Approach
To maximize the number of ice cream bars purchased, a greedy strategy dictates buying the cheapest bars first. While standard sorting algorithms take $O(N \log N)$ time, the constraints state we must solve it using **Counting Sort**, which achieves a linear time complexity of $O(N + \text{maxCost})$.

Instead of fully rebuilding a sorted array, we use a frequency map where the array indices represent the prices of the ice cream bars. We iterate through this frequency distribution from the lowest price upwards, greedily exhausting as many bars at each price tier as our budget permits.

### 🛠️ The Strategy:
1. **Find Maximum Range:** Scan `costs` to determine the maximum value `maxCost` to build a localized frequency table window.
2. **Frequency Mapping:** Construct a `frequency` array of size `maxCost + 1`. Map out how many bars exist at every price checkpoint.
3. **Greedy Purchase Cycle:** Iterate sequentially from price index `1` to `maxCost`. If bars are available at the current price, determine the maximum count we can afford via `Math.min(frequency[price], coins / price)`.
4. **Early Termination:** Deduct the transaction cost from `coins`, update the total count, and terminate early if remaining coins fall below the next price requirement.

## 📊 Complexity Analysis
* **Time Complexity:** O(N + M) - Where $N$ is the number of elements in `costs` and $M$ is the value of `maxCost`. The array is scanned to populate frequencies, followed by a linear loop through the frequency table slots.
* **Space Complexity:** O(M) - An auxiliary frequency table is allocated, scaled directly to the maximum cost found in the input.

## 💻 Implementation (Java)
```java
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxCost = 0;
        for (int cost : costs) {
            if (cost > maxCost) maxCost = cost;
        }

        // Create the tracking frequency map bucket array
        int[] frequency = new int[maxCost + 1];
        for (int cost : costs) {
            frequency[cost]++;
        }

        int iceCreamCount = 0;
        
        // Greedily buy the cheapest bars using counting sort indices
        for (int price = 1; price <= maxCost; price++) {
            if (frequency[price] == 0) continue;

            // Short-circuit if the single bar price exceeds the wallet balance
            if (price > coins) break;

            // Calculate exact transaction counts allowed by the budget cap
            int quantityToBuy = Math.min(frequency[price], coins / price);

            coins -= quantityToBuy * price;
            iceCreamCount += quantityToBuy;

            // Terminate processing if subsequent bars are definitely unaffordable
            if (coins < price) break;
        }

        return iceCreamCount;
    }
}
