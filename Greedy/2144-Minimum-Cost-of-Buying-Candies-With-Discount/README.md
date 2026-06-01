# 2144. Minimum Cost of Buying Candies With Discount (Easy)

## 📝 Problem Statement
A shop offers a discount: for every two candies you buy, you get a third candy for free. The only catch is that the free candy's cost must be less than or equal to the minimum cost of the two purchased candies. Given an integer array `cost`, return the minimum cost of buying all the candies.

## 💡 Intuition & Approach
To minimize the total out-of-pocket cost, we need to maximize the value of the candies we get for free. 

The strategy is strictly **Greedy**:
1. **Sort the array** in ascending order so that we can easily access the most expensive items.
2. **Process from right to left** (highest to lowest cost).
3. Buy the two most expensive available candies (`cost[i]` and `cost[i-1]`).
4. The rule allows us to take the next most expensive candy (`cost[i-2]`) for free because its value is naturally less than or equal to the two we just bought.
5. Skip that free candy by decrementing our pointer and repeat the cycle.

## 📊 Complexity Analysis
* **Time Complexity:** O(N log N) - Sorting the `cost` array dominates the runtime complexity. The subsequent loop runs in linear O(N) time.
* **Space Complexity:** O(1) or O(log N) - The space complexity depends on the language's internal sorting mechanism (Java's `Arrays.sort` uses Dual-Pivot Quicksort, requiring O(log N) space for the recursive call stack).

## 💻 Implementation (Java)
```java
class Solution {
    public int minimumCost(int[] cost) {
        // Step 1: Sort the candies to apply our greedy strategy
        Arrays.sort(cost);
        int ans = 0;

        // Step 2: Iterate backward from the most expensive candies
        for (int i = cost.length - 1; i >= 0; i--) {
            // Buy the 1st most expensive available candy
            ans += cost[i--];
            
            // Buy the 2nd most expensive available candy (if it exists)
            if (i >= 0) {
                ans += cost[i--];
            }
            
            // The next iteration automatically skips the 3rd candy (the free one)
        }

        return ans;
    }
}
